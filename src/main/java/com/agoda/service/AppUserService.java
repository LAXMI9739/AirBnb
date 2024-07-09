package com.agoda.service;

import com.agoda.dto.AppUserDto;
import com.agoda.payload.LoginDto;

public interface AppUserService {
    AppUserDto addUser(AppUserDto appUserDto);

    String verifyLogin(LoginDto loginDto);
}
