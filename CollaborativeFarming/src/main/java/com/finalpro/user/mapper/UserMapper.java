package com.finalpro.user.mapper;

import org.mapstruct.Mapper;
import com.finalpro.user.dto.UserResponseDto;
import com.finalpro.user.dto.RequestDto;
import com.finalpro.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto userToUserResponseDto(User user);

    User userRequestDtoToUser(RequestDto userRequestDto);
}