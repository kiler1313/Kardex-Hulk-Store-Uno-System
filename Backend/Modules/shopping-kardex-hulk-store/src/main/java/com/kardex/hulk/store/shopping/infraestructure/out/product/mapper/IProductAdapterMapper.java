package com.kardex.hulk.store.shopping.infraestructure.out.product.mapper;

import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.infraestructure.out.product.request.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IProductAdapterMapper {
    ProductDto toDto(Product product);
    Product toDomain(ProductDto productDto);
}

