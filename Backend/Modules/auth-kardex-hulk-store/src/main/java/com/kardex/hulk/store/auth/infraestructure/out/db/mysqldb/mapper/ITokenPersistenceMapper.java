package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.mapper;


import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.TokenEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ITokenPersistenceMapper {

    Token toDomain (TokenEntity tokenEntity);
    TokenEntity toInfraestructure (Token token);
    void updateTokenEntityFromToken(Token token, @MappingTarget TokenEntity tokenEntity);
}
