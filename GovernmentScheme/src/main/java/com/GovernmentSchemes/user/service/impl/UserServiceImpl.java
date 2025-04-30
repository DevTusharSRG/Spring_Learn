//package com.GovernmentSchemes.user.service.impl;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.GovernmentSchemes.GovernmentSchemeReport.dto.UserRequestDto;
//import com.GovernmentSchemes.user.dao.UserDao;
//import com.GovernmentSchemes.user.dto.RequestDto;
//import com.GovernmentSchemes.user.dto.UserResponseDto;
//import com.GovernmentSchemes.user.mapper.UserMapper;
//import com.GovernmentSchemes.user.model.User;
//import com.GovernmentSchemes.user.service.UserService;
//
//@Service
//public class UserServiceImpl implements UserService {
//	
//	@Autowired
//    private ModelMapper modelMapper; 
//
//
//    @Autowired
//    private UserDao userDao;
//
////    @Autowired
////    private UserMapper userMapper;
////    
//    // Convert UserDTO to User entity using ModelMapper
//    public User dtoToEntity(RequestDto dto) {
//        User user = modelMapper.map(dto, User.class);
//        user.setCreateDate(new Timestamp(System.currentTimeMillis())); // Ensure createDate is set
//        return user;
//    }
//
//
//    // Convert User entity to UserDTO using ModelMapper
//    private RequestDto entityToDto(User user) {
//        return modelMapper.map(user, RequestDto.class);
//    }
//
//
//    @Transactional
//    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
//    }
//
//    
//    @Transactional
//    public void saveUser(RequestDto userDTO) {
//        userDao.save(dtoToEntity(userDTO));
//    }
//
//    
//    @Transactional
//    public boolean updateUser(int id, UserRequestDto dto) {
//        User user = userDao.getUserById(id);
//        if (user != null) {
//            // Use ModelMapper to update the user entity from DTO
//            modelMapper.map(dto, user);  // This updates the user fields from the UserRequestDto
//            
//            // If necessary, set the modified date or perform other actions:
//            user.setCreateDate(new Timestamp(System.currentTimeMillis()));
//
//            // Save updated user
//            userDao.updateUser(user);
//            return true;
//        }
//        return false;
//    }
//
//    @Transactional
//    public boolean deleteUser(int id) {
//        User user = userDao.getUserById(id);
//        if (user != null) {
//            userDao.deleteUser(user);
//            return true;
//        }
//        return false;
//    }
//
//
//    @Transactional
//    public User getUserById(int id) {
//        return userDao.getUserById(id);
//    }

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
//}


package com.GovernmentSchemes.user.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GovernmentSchemes.GovernmentSchemeReport.dto.UserRequestDto;
import com.GovernmentSchemes.user.dao.UserDao;
import com.GovernmentSchemes.user.dto.RequestDto;
import com.GovernmentSchemes.user.dto.UserResponseDto;
import com.GovernmentSchemes.user.model.User;
import com.GovernmentSchemes.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserDao userDao;

    // Convert RequestDto to User entity
    public User dtoToEntity(RequestDto dto) {
        User user = modelMapper.map(dto, User.class);
        user.setCreateDate(new Timestamp(System.currentTimeMillis()));
        return user;
    }

    // Convert User entity to ResponseDto
    private UserResponseDto entityToResponseDto(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    // Convert User entity to RequestDto (if needed)
    private RequestDto entityToRequestDto(User user) {
        return modelMapper.map(user, RequestDto.class);
    }

    // ✅ Get all users and map to UserResponseDto
    @Transactional
    public List<UserResponseDto> getAllUsers() {
        return userDao.getAllUsers()
                .stream()
                .map(this::entityToResponseDto)
                .collect(Collectors.toList());
    }

    // ✅ Save user from DTO
    @Transactional
    public void saveUser(RequestDto userDTO) {
        userDao.save(dtoToEntity(userDTO));
    }

    // ✅ Update user with fields from UserRequestDto using ModelMapper
    @Transactional
    public boolean updateUser(int id, UserRequestDto dto) {
        User user = userDao.getUserById(id);
        if (user != null) {
            modelMapper.map(dto, user);
            user.setCreateDate(new Timestamp(System.currentTimeMillis()));
            userDao.updateUser(user);
            return true;
        }
        return false;
    }

    // ✅ Delete user and return true/false (optional: return DTO if needed)
    @Transactional
    public boolean deleteUser(int id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(user);
            return true;
        }
        return false;
    }

    // ✅ Get user by ID and return UserResponseDto
    @Transactional
    public UserResponseDto getUserById(int id) {
        User user = userDao.getUserById(id);
        return (user != null) ? entityToResponseDto(user) : null;
    }
}

