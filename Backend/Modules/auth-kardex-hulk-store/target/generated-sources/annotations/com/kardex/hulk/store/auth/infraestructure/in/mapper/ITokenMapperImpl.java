package com.kardex.hulk.store.auth.infraestructure.in.mapper;

import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.infraestructure.in.command.dto.TokenDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:29-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ITokenMapperImpl implements ITokenMapper {

    @Override
    public TokenDto toDto(Token token) {
        if ( token == null ) {
            return null;
        }

        TokenDto tokenDto = new TokenDto();

        tokenDto.setToken( token.getToken() );

        return tokenDto;
    }

    @Override
    public Token toDomain(TokenDto tokenDto) {
        if ( tokenDto == null ) {
            return null;
        }

        Token token = new Token();

        token.setToken( tokenDto.getToken() );

        return token;
    }
}
