package com.kardex.hulk.store.shopping.infraestructure.out.product.mapper;

import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.infraestructure.out.product.request.dto.ProductDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:39-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class IProductAdapterMapperImpl implements IProductAdapterMapper {

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setCode( product.getCode() );
        productDto.setName( product.getName() );
        productDto.setStock( product.getStock() );
        productDto.setValue( product.getValue() );
        productDto.setStatus( product.getStatus() );
        productDto.setColor( product.getColor() );
        productDto.setWeight( product.getWeight() );
        productDto.setHeight( product.getHeight() );
        productDto.setIsFreeSend( product.getIsFreeSend() );
        productDto.setImg( product.getImg() );
        productDto.setQuantity( product.getQuantity() );

        return productDto;
    }

    @Override
    public Product toDomain(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setCode( productDto.getCode() );
        product.setName( productDto.getName() );
        product.setStock( productDto.getStock() );
        product.setValue( productDto.getValue() );
        product.setStatus( productDto.getStatus() );
        product.setColor( productDto.getColor() );
        product.setWeight( productDto.getWeight() );
        product.setHeight( productDto.getHeight() );
        product.setIsFreeSend( productDto.getIsFreeSend() );
        product.setImg( productDto.getImg() );
        product.setQuantity( productDto.getQuantity() );

        return product;
    }
}
