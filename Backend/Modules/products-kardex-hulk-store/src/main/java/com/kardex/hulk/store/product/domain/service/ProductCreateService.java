package com.kardex.hulk.store.product.domain.service;

import com.kardex.hulk.store.product.application.port.out.db.IProductPersistencePort;
import com.kardex.hulk.store.product.commons.Constants;
import com.kardex.hulk.store.product.application.port.in.IProductCreateUseCase;
import com.kardex.hulk.store.product.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductCreateService implements IProductCreateUseCase {

    @Autowired
    IProductPersistencePort persistencePort;

    @Override
    public Map<Boolean, List<Product>> createProduct(List<Product> listProduct) {
        Map<Boolean, List<Product>> response = new HashMap<>();
        List<Product> findListProductsExist = new ArrayList<>();
        listProduct.stream().forEach(product -> {
            Product findProductUnique = persistencePort.findFirstByCodeAndColorAndWeightAndHeight(product.getCode(),product.getColor(),product.getWeight(),product.getHeight());
            if (Objects.isNull(findProductUnique))
            {
                persistencePort.createProduct(product);
            }
            else
            {
                findListProductsExist.add(findProductUnique);
            }
        });
        if (findListProductsExist.size() > Constants.ZERO)
        {
            response.put(Boolean.FALSE,findListProductsExist);
        }
        else
        {
            response.put(Boolean.TRUE,listProduct);
        }
        return  response;
    }

}
