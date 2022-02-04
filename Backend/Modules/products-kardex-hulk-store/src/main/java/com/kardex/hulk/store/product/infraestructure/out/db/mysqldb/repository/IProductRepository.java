package com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.repository;

import com.kardex.hulk.store.product.domain.models.Product;
import com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<ProductEntity, Integer> {

    List<ProductEntity> findByCode(String code);
    ProductEntity findFirstByCodeAndStatusOrderByDateCreationAsc(String code, Integer status);
    ProductEntity findFirstByCodeAndColorAndWeightAndHeight(String code, String color, String weight, String height);
    List<ProductEntity> findByIsFreeSend(Boolean status);
    List<ProductEntity> findByStatus(Integer status);
    ProductEntity save(ProductEntity productEntity);
}
