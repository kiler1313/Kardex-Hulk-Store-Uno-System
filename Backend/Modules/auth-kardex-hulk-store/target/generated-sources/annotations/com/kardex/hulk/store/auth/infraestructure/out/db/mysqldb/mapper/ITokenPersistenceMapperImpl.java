package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.mapper;

import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.TokenEntity;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:28-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ITokenPersistenceMapperImpl implements ITokenPersistenceMapper {

    @Override
    public Token toDomain(TokenEntity tokenEntity) {
        if ( tokenEntity == null ) {
            return null;
        }

        Token token = new Token();

        token.setUser( userEntityToUser( tokenEntity.getUser() ) );
        token.setToken( tokenEntity.getToken() );

        return token;
    }

    @Override
    public TokenEntity toInfraestructure(Token token) {
        if ( token == null ) {
            return null;
        }

        TokenEntity tokenEntity = new TokenEntity();

        tokenEntity.setUser( userToUserEntity( token.getUser() ) );
        tokenEntity.setToken( token.getToken() );

        return tokenEntity;
    }

    @Override
    public void updateTokenEntityFromToken(Token token, TokenEntity tokenEntity) {
        if ( token == null ) {
            return;
        }

        if ( token.getUser() != null ) {
            if ( tokenEntity.getUser() == null ) {
                tokenEntity.setUser( new UserEntity() );
            }
            userToUserEntity1( token.getUser(), tokenEntity.getUser() );
        }
        if ( token.getToken() != null ) {
            tokenEntity.setToken( token.getToken() );
        }
    }

    protected User userEntityToUser(UserEntity userEntity) {
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

    protected UserEntity userToUserEntity(User user) {
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

    protected void userToUserEntity1(User user, UserEntity mappingTarget) {
        if ( user == null ) {
            return;
        }

        if ( user.getId() != null ) {
            mappingTarget.setId( user.getId() );
        }
        if ( user.getNames() != null ) {
            mappingTarget.setNames( user.getNames() );
        }
        if ( user.getSurnames() != null ) {
            mappingTarget.setSurnames( user.getSurnames() );
        }
        if ( user.getUserName() != null ) {
            mappingTarget.setUserName( user.getUserName() );
        }
        if ( user.getPassword() != null ) {
            mappingTarget.setPassword( user.getPassword() );
        }
        if ( user.getDateOfBirth() != null ) {
            mappingTarget.setDateOfBirth( user.getDateOfBirth() );
        }
        if ( user.getCreditCard() != null ) {
            mappingTarget.setCreditCard( user.getCreditCard() );
        }
        if ( user.getTypeCreditCard() != null ) {
            mappingTarget.setTypeCreditCard( user.getTypeCreditCard() );
        }
        if ( user.getAddress() != null ) {
            mappingTarget.setAddress( user.getAddress() );
        }
        if ( user.getIdRoles() != null ) {
            mappingTarget.setIdRoles( user.getIdRoles() );
        }
    }
}
