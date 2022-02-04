package com.kardex.hulk.store.shopping.infraestructure.in.mapper;

import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.SaleProductDto;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.ProductEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.SaleProductEntity;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:39-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class ISaleProductMapperImpl implements ISaleProductMapper {

    @Override
    public SaleProductDto toDto(SaleProduct saleProduct) {
        if ( saleProduct == null ) {
            return null;
        }

        SaleProductDto saleProductDto = new SaleProductDto();

        saleProductDto.setId( saleProduct.getId() );
        saleProductDto.setCode( saleProduct.getCode() );
        saleProductDto.setProduct( productToProductEntity( saleProduct.getProduct() ) );
        saleProductDto.setQuantity( saleProduct.getQuantity() );
        saleProductDto.setSubTotal( saleProduct.getSubTotal() );
        saleProductDto.setUserCreate( saleProduct.getUserCreate() );
        saleProductDto.setUserUpdate( saleProduct.getUserUpdate() );
        saleProductDto.setDateCreate( saleProduct.getDateCreate() );
        saleProductDto.setDateUpdate( saleProduct.getDateUpdate() );

        return saleProductDto;
    }

    @Override
    public SaleProduct toDomain(SaleProductDto saleProductDto) {
        if ( saleProductDto == null ) {
            return null;
        }

        SaleProduct saleProduct = new SaleProduct();

        saleProduct.setId( saleProductDto.getId() );
        saleProduct.setCode( saleProductDto.getCode() );
        saleProduct.setProduct( productEntityToProduct( saleProductDto.getProduct() ) );
        saleProduct.setQuantity( saleProductDto.getQuantity() );
        saleProduct.setSubTotal( saleProductDto.getSubTotal() );
        saleProduct.setUserCreate( saleProductDto.getUserCreate() );
        saleProduct.setUserUpdate( saleProductDto.getUserUpdate() );
        saleProduct.setDateCreate( saleProductDto.getDateCreate() );
        saleProduct.setDateUpdate( saleProductDto.getDateUpdate() );

        return saleProduct;
    }

    protected ProductEntity productToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setCode( product.getCode() );
        productEntity.setName( product.getName() );
        productEntity.setStock( product.getStock() );
        productEntity.setValue( product.getValue() );
        productEntity.setStatus( product.getStatus() );
        productEntity.setColor( product.getColor() );
        productEntity.setWeight( product.getWeight() );
        productEntity.setHeight( product.getHeight() );
        productEntity.setIsFreeSend( product.getIsFreeSend() );
        productEntity.setUserCreate( product.getUserCreate() );
        productEntity.setUserUpdate( product.getUserUpdate() );
        productEntity.setDateCreation( product.getDateCreation() );
        productEntity.setDateUpdate( product.getDateUpdate() );
        productEntity.setImg( product.getImg() );
        Set<SaleProductEntity> set = product.getSalesProducts();
        if ( set != null ) {
            productEntity.setSalesProducts( new LinkedHashSet<SaleProductEntity>( set ) );
        }

        return productEntity;
    }

    protected Product productEntityToProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setCode( productEntity.getCode() );
        product.setName( productEntity.getName() );
        product.setStock( productEntity.getStock() );
        product.setValue( productEntity.getValue() );
        product.setStatus( productEntity.getStatus() );
        product.setColor( productEntity.getColor() );
        product.setWeight( productEntity.getWeight() );
        product.setHeight( productEntity.getHeight() );
        product.setIsFreeSend( productEntity.getIsFreeSend() );
        product.setUserCreate( productEntity.getUserCreate() );
        product.setUserUpdate( productEntity.getUserUpdate() );
        product.setDateCreation( productEntity.getDateCreation() );
        product.setDateUpdate( productEntity.getDateUpdate() );
        product.setImg( productEntity.getImg() );
        Set<SaleProductEntity> set = productEntity.getSalesProducts();
        if ( set != null ) {
            product.setSalesProducts( new LinkedHashSet<SaleProductEntity>( set ) );
        }

        return product;
    }
}
