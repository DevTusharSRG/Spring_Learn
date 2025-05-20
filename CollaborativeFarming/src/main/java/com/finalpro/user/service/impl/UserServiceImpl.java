package com.finalpro.user.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalpro.user.dao.UserDao;
import com.finalpro.user.dto.LoginRequestDto;
import com.finalpro.user.dto.LoginResponseDto;
import com.finalpro.user.dto.RequestDto;
import com.finalpro.user.dto.UserResponseDto;
import com.finalpro.user.mapper.UserMapper;
import com.finalpro.user.model.User;
import com.finalpro.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private ModelMapper modelMapper;  // Autowire ModelMapper


    @Autowired
    private UserDao userDao;

//    @Autowired
//    private UserMapper userMapper;
//    
    // Convert UserDTO to User entity using ModelMapper
    public User dtoToEntity(RequestDto dto) {
        User user = modelMapper.map(dto, User.class);
        user.setCreateDate(new Timestamp(System.currentTimeMillis())); // Ensure createDate is set
        return user;
    }


    // Convert User entity to UserDTO using ModelMapper
    private RequestDto entityToDto(User user) {
        return modelMapper.map(user, RequestDto.class);
    }


    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    
    @Transactional
    public void saveUser(RequestDto userDTO) {
        userDao.save(dtoToEntity(userDTO));
    }


	@Transactional
    public LoginResponseDto login(String email, String password, String name) {
        User user = userDao.findByEmailId(email); // fetch user from DB
        if (user != null && user.getPassword().equals(password)) {
            LoginResponseDto response = new LoginResponseDto();
            response.setEmail(user.getEmail());
            response.setName(user.getName()); // Make sure User has getName()
            response.setPassword(user.getPassword()); // Optional: avoid returning raw password
            return response;
        } else {
            return null; // or throw exception
        }
    }


    

//  @Transactional
//  public UserResponseDto createUser(RequestDto dto) {
//      // Convert RequestDto to User entity
//      User user = userMapper.userRequestDtoToUser(dto);
//
//      // Set additional fields if necessary, for example:
//      user.setCreateDate(new Timestamp(System.currentTimeMillis()));
//
//      // Save the user to the database
//      userDao.save(user);
//
//      // Return the response DTO
//      return userMapper.userToUserResponseDto(user);
//  }
  

//    @Transactional
//    public UserResponseDto findUserById(Long userId) {
//        // Find user by ID
//        User user = userDao.findUserById(userId);
//        
//        // Return the response DTO
//        return userMapper.userToUserResponseDto(user);
//    }
}
