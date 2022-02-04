package com.kardex.hulk.store.auth.infraestructure.in.mapper;

import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.infraestructure.in.command.dto.TokenDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ITokenMapper {
    TokenDto toDto(Token token);
    Token toDomain(TokenDto tokenDto);
}

