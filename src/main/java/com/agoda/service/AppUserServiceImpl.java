package com.agoda.service;

import com.agoda.dto.AppUserDto;
import com.agoda.entity.AppUser;
import com.agoda.payload.LoginDto;
import com.agoda.repository.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService{
    private AppUserRepository appUserRepository;
    private JWTService jwtService;

    public AppUserServiceImpl(AppUserRepository appUserRepository, JWTService jwtService) {
        this.appUserRepository = appUserRepository;
        this.jwtService = jwtService;
    }

    public AppUserDto entityToDto(AppUser user){
        AppUserDto dto=new AppUserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setMobile(user.getMobile());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }

    public AppUser dtoToEntity(AppUserDto dto){
        AppUser user=new AppUser();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setMobile(dto.getMobile());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return user;
    }

    @Override
    public AppUserDto addUser(AppUserDto appUserDto) {
        AppUser user = dtoToEntity(appUserDto);
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10)));
        AppUser savedUser = appUserRepository.save(user);
        AppUserDto appUserDto1 = entityToDto(savedUser);
        return appUserDto1;
    }

    @Override
    public String verifyLogin(LoginDto loginDto) {
        Optional<AppUser> opUsername = appUserRepository.findByUsername(loginDto.getUsername());
        if(opUsername.isPresent()){
            AppUser user = opUsername.get();
            if(BCrypt.checkpw(loginDto.getPassword(),user.getPassword())){
                String tocken=jwtService.generateToken(user);
                return tocken;
            }

        }
        return null;
    }
}
