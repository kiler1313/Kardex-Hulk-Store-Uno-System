package com.kardex.hulk.store.shopping.infraestructure.in.mapper;

import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.SaleProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ISaleProductMapper {
    SaleProductDto toDto(SaleProduct saleProduct);
    SaleProduct toDomain(SaleProductDto saleProductDto);
}

