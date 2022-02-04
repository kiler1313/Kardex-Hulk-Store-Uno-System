package com.kardex.hulk.store.product.application.port.in;

import com.kardex.hulk.store.product.domain.models.Product;

import java.util.List;
import java.util.Map;

public interface IProductSaleUseCase {

    Map<Boolean, List<Product>> updateProduct(List<Product> listProduct);
}
