package com.kardex.hulk.store.shopping.application.port.out.product;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.User;

import java.util.List;

public interface IProductPort {

    public boolean updateQuantitiesOfProductsSales(List<Product> productList);
}
