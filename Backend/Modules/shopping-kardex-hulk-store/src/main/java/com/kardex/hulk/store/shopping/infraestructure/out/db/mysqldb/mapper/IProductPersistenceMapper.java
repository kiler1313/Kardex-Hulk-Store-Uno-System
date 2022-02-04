package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper;


import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.BillEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.ProductEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.SaleProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IProductPersistenceMapper {

    Product toDomain(ProductEntity productEntity);
    ProductEntity toInfraestructure(Product product);
}
