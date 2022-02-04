package com.kardex.hulk.store.product.domain.service;


import com.kardex.hulk.store.product.application.port.in.IProductQueryUseCase;
import com.kardex.hulk.store.product.application.port.out.db.IProductPersistencePort;
import com.kardex.hulk.store.product.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryService implements IProductQueryUseCase {

    @Autowired
    IProductPersistencePort persistencePort;

    @Override
    public List<Product> findByCode(String code) {
      return persistencePort.findByCode(code);
    }

    @Override
    public List<Product> findByIsFreeSend(Boolean status) {
        return persistencePort.findByIsFreeSend(status);
    }

    @Override
    public Product findByCodeAndStatus(String code, Integer status) {
        return persistencePort.findFirstByCodeAndStatus(code,status);
    }

    @Override
    public Product findByCodeAndColorAndWeightAndHeight(String code, String color, String weight, String height) {
        return persistencePort.findFirstByCodeAndColorAndWeightAndHeight(code,color,weight,height);
    }

    @Override
    public List<Product> findByStatus(Integer status) {
        return persistencePort.findByStatus(status);
    }
}
