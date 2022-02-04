package com.kardex.hulk.store.product.domain.service;

import com.kardex.hulk.store.product.application.port.in.   IProductUpdateUseCase;
import com.kardex.hulk.store.product.application.port.out.db.IProductPersistencePort;
import com.kardex.hulk.store.product.commons.Constants;
import com.kardex.hulk.store.product.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductUpdateService implements IProductUpdateUseCase {

    @Autowired
    IProductPersistencePort persistencePort;

    @Override
    public Map<Boolean, List<Product>> updateProduct(List<Product> listProduct) {
        List<Product> listProductsNotFound = new ArrayList<>();
        Map<Boolean, List<Product>> response = new HashMap<>();
        listProduct.stream().forEach(product -> {
            Product findProductUpdate = persistencePort.findFirstByCodeAndColorAndWeightAndHeight(product.getCode(),product.getColor(),product.getWeight(),product.getHeight());
            if (!Objects.isNull(findProductUpdate))
            {
                if (product.getStock() == Constants.ZERO)
                {
                    product.setStatus(Constants.OUT_OF_STOCK);
                }
                else
                {
                    product.setStatus(Constants.ACTIVED);
                }
                persistencePort.updateProductSend(findProductUpdate, product);
            }
            else
            {
                listProductsNotFound.add(findProductUpdate);
            }
        });
        if (listProductsNotFound.size() > Constants.ZERO)
        {
            response.put(Boolean.FALSE, listProduct);
        }
        else
        {
            response.put(Boolean.TRUE, listProduct);
        }
        return response;
    }

}
