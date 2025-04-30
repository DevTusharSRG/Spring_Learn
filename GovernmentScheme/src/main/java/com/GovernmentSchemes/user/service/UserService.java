package com.GovernmentSchemes.user.service;

import java.util.List;

import com.GovernmentSchemes.GovernmentSchemeReport.dto.UserRequestDto;
import com.GovernmentSchemes.user.dto.RequestDto;
import com.GovernmentSchemes.user.dto.UserResponseDto;
import com.GovernmentSchemes.user.model.User;

public interface UserService {
	public List<UserResponseDto> getAllUsers();
    // public UserResponseDto createUser(RequestDto dto);
    public void saveUser(RequestDto userDTO); // <-- Corrected this line
    public UserResponseDto getUserById(int id);
    public boolean updateUser(int id, UserRequestDto dto);
    public boolean deleteUser(int id);
    
}
