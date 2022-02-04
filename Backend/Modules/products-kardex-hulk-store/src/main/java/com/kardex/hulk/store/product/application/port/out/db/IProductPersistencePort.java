package com.kardex.hulk.store.product.application.port.out.db;

import com.kardex.hulk.store.product.domain.models.Product;

import java.util.List;

public interface IProductPersistencePort {

    public boolean createProduct(Product product);
    public boolean createListProduct(List<Product> product);
    public boolean updateProductSend(Product productFind, Product productUpdate);
    public List<Product> findByCode(String code);
    public List<Product> findByIsFreeSend(Boolean status);
    public Product findFirstByCodeAndStatus(String code, Integer status);
    public Product findFirstByCodeAndColorAndWeightAndHeight(String code, String color, String weight, String height);
    public List<Product> findByStatus(Integer status);

}
