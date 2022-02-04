package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.mapper;

import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:28-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class IUserPersistenceMapperImpl implements IUserPersistenceMapper {

    @Override
    public User toDomain(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setNames( userEntity.getNames() );
        user.setSurnames( userEntity.getSurnames() );
        user.setUserName( userEntity.getUserName() );
        user.setPassword( userEntity.getPassword() );
        user.setDateOfBirth( userEntity.getDateOfBirth() );
        user.setCreditCard( userEntity.getCreditCard() );
        user.setTypeCreditCard( userEntity.getTypeCreditCard() );
        user.setAddress( userEntity.getAddress() );
        user.setIdRoles( userEntity.getIdRoles() );

        return user;
    }

    @Override
    public UserEntity toInfraestructure(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setNames( user.getNames() );
        userEntity.setSurnames( user.getSurnames() );
        userEntity.setUserName( user.getUserName() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setDateOfBirth( user.getDateOfBirth() );
        userEntity.setCreditCard( user.getCreditCard() );
        userEntity.setTypeCreditCard( user.getTypeCreditCard() );
        userEntity.setAddress( user.getAddress() );
        userEntity.setIdRoles( user.getIdRoles() );

        return userEntity;
    }

    @Override
    public void updateUserEntityFromUser(User bill, UserEntity tokenEntity) {
        if ( bill == null ) {
            return;
        }

        if ( bill.getId() != null ) {
            tokenEntity.setId( bill.getId() );
        }
        if ( bill.getNames() != null ) {
            tokenEntity.setNames( bill.getNames() );
        }
        if ( bill.getSurnames() != null ) {
            tokenEntity.setSurnames( bill.getSurnames() );
        }
        if ( bill.getUserName() != null ) {
            tokenEntity.setUserName( bill.getUserName() );
        }
        if ( bill.getPassword() != null ) {
            tokenEntity.setPassword( bill.getPassword() );
        }
        if ( bill.getDateOfBirth() != null ) {
            tokenEntity.setDateOfBirth( bill.getDateOfBirth() );
        }
        if ( bill.getCreditCard() != null ) {
            tokenEntity.setCreditCard( bill.getCreditCard() );
        }
        if ( bill.getTypeCreditCard() != null ) {
            tokenEntity.setTypeCreditCard( bill.getTypeCreditCard() );
        }
        if ( bill.getAddress() != null ) {
            tokenEntity.setAddress( bill.getAddress() );
        }
        if ( bill.getIdRoles() != null ) {
            tokenEntity.setIdRoles( bill.getIdRoles() );
        }
    }
}
