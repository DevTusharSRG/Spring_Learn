package com.finalpro.user.service;

import java.util.List;

import com.finalpro.user.dto.LoginRequestDto;
import com.finalpro.user.dto.LoginResponseDto;
import com.finalpro.user.dto.RequestDto;
import com.finalpro.user.dto.UserResponseDto;
import com.finalpro.user.model.User;

public interface UserService {
    public List<User> getAllUsers();
    // public UserResponseDto createUser(RequestDto dto);
    public void saveUser(RequestDto userDTO); // <-- Corrected this line
    //LoginResponseDto login(LoginRequestDto loginDto);
    public LoginResponseDto login(String email, String password , String name);

}
