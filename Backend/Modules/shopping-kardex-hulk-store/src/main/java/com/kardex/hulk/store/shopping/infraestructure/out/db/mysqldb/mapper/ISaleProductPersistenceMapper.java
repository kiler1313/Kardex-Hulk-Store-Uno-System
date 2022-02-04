package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper;


import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.BillEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.ProductEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.SaleProductEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ISaleProductPersistenceMapper {

    SaleProduct toDomain (SaleProductEntity saleProductEntity);
    SaleProductEntity toInfraestructure (SaleProduct saleProduct);
}
