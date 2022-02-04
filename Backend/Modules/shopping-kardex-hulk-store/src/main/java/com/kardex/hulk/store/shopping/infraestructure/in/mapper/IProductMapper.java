package com.kardex.hulk.store.shopping.infraestructure.in.mapper;

import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.ProductDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IProductMapper {
    ProductDto toDto(Product product);
    Product toDomain(ProductDto productDto);
}

