package com.kardex.hulk.store.auth.infraestructure.in.mapper;

import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.infraestructure.in.command.dto.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:29-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setNames( user.getNames() );
        userDto.setSurnames( user.getSurnames() );
        userDto.setUserName( user.getUserName() );
        userDto.setPassword( user.getPassword() );
        userDto.setDateOfBirth( user.getDateOfBirth() );
        userDto.setCreditCard( user.getCreditCard() );
        userDto.setTypeCreditCard( user.getTypeCreditCard() );
        userDto.setAddress( user.getAddress() );
        userDto.setIdRoles( user.getIdRoles() );

        return userDto;
    }

    @Override
    public User toDomain(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setNames( userDto.getNames() );
        user.setSurnames( userDto.getSurnames() );
        user.setUserName( userDto.getUserName() );
        user.setPassword( userDto.getPassword() );
        user.setDateOfBirth( userDto.getDateOfBirth() );
        user.setCreditCard( userDto.getCreditCard() );
        user.setTypeCreditCard( userDto.getTypeCreditCard() );
        user.setAddress( userDto.getAddress() );
        user.setIdRoles( userDto.getIdRoles() );

        return user;
    }
}
