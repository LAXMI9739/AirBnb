package com.agoda.controller;

import com.agoda.dto.AppUserDto;
import com.agoda.payload.JWTTokenDto;
import com.agoda.payload.LoginDto;
import com.agoda.repository.AppUserRepository;
import com.agoda.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class AppUserController {
private AppUserService appUserService;
private AppUserRepository appUserRepository;

    public AppUserController(AppUserService appUserService, AppUserRepository appUserRepository) {
        this.appUserService = appUserService;
        this.appUserRepository = appUserRepository;
    }
    @PostMapping("/addUser")
    public ResponseEntity<?>  addUser(@RequestBody AppUserDto appUserDto){
         if(appUserRepository.existsByEmail(appUserDto.getEmail())){
             return new ResponseEntity<>("Email Exists",HttpStatus.BAD_REQUEST);
         }
         if(appUserRepository.existsByUsername(appUserDto.getUsername())){
             return new ResponseEntity<>("username exists",HttpStatus.BAD_REQUEST);
         }

        AppUserDto appUserDto1 = appUserService.addUser(appUserDto);
        return new ResponseEntity<>(appUserDto1, HttpStatus.CREATED);
    }
    @PostMapping("/verifyLogin")
    public ResponseEntity<?> verifyLogin(@RequestBody LoginDto loginDto){
        String token=appUserService.verifyLogin(loginDto);
        if(token!=null){
            JWTTokenDto jwtTokenDto=new JWTTokenDto();
            jwtTokenDto.setType("JWT token");
            jwtTokenDto.setToken(token);
            return new ResponseEntity<>(jwtTokenDto,HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid token",HttpStatus.OK);
    }

}
