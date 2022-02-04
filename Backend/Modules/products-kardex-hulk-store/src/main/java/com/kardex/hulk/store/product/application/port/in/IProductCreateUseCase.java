package com.kardex.hulk.store.product.application.port.in;

import com.kardex.hulk.store.product.domain.models.Product;

import java.util.List;
import java.util.Map;

public interface IProductCreateUseCase {

    Map<Boolean, List<Product>> createProduct(List<Product> listProduct);
}
