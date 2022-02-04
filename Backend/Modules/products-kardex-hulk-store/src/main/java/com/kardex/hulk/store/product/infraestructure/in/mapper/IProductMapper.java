package com.kardex.hulk.store.product.infraestructure.in.mapper;

import com.kardex.hulk.store.product.domain.models.Product;
import com.kardex.hulk.store.product.infraestructure.in.command.request.ProductRequest;
import com.kardex.hulk.store.product.infraestructure.in.command.dto.ProductDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface IProductMapper {
    ProductDto toDto(Product product);
    Product toDomain(ProductDto productDto);
}

