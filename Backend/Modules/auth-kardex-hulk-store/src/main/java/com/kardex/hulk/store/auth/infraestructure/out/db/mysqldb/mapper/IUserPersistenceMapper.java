package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.mapper;


import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IUserPersistenceMapper {

    User toDomain (UserEntity userEntity);
    UserEntity toInfraestructure (User user);
    void updateUserEntityFromUser(User bill, @MappingTarget UserEntity tokenEntity);
}
