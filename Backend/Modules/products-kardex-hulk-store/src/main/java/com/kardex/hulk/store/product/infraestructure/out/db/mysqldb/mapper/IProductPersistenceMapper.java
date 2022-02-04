package com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.mapper;


import com.kardex.hulk.store.product.domain.models.Product;
import com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.entities.ProductEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IProductPersistenceMapper {

    Product toDomain(ProductEntity productEntity);
    ProductEntity toInfraestructure(Product product);
    void updateProductEntityFromProduct(Product product, @MappingTarget ProductEntity productEntity);
}
