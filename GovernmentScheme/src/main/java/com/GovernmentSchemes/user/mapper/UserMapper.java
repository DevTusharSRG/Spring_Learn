package com.GovernmentSchemes.user.mapper;

import org.mapstruct.Mapper;
import com.GovernmentSchemes.user.dto.UserResponseDto;
import com.GovernmentSchemes.user.dto.RequestDto;
import com.GovernmentSchemes.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto userToUserResponseDto(User user);

    User userRequestDtoToUser(RequestDto userRequestDto);
}