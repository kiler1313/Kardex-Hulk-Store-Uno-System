package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper;


import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import com.kardex.hulk.store.shopping.domain.models.User;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.SaleProductEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IUserPersistenceMapper {

    User toDomain (UserEntity userEntity);
    UserEntity toInfraestructure (User user);
}
