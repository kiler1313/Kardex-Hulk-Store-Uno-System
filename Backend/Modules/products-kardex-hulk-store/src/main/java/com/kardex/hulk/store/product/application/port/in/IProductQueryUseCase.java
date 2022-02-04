package com.kardex.hulk.store.product.application.port.in;

import com.kardex.hulk.store.product.domain.models.Product;

import java.util.List;

public interface IProductQueryUseCase {

    List<Product> findByCode(String code);
    public List<Product> findByIsFreeSend(Boolean status);
    public Product findByCodeAndStatus(String code, Integer status);
    public Product findByCodeAndColorAndWeightAndHeight(String code, String color, String weight, String height);
    public List<Product> findByStatus(Integer status);
}
