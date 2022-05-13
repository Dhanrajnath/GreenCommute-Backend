package com.GreenCommute.Backend.Mapper;

import com.GreenCommute.Backend.Dto.UserDto;
import com.GreenCommute.Backend.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {User.class, UserDto.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userId", target = "userId")
    UserDto toUserDto(User optionalUser);

}
