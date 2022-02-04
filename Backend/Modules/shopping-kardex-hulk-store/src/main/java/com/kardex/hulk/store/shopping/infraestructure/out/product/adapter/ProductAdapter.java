package com.kardex.hulk.store.shopping.infraestructure.out.product.adapter;

import com.kardex.hulk.store.shopping.application.port.out.product.IProductPort;
import com.kardex.hulk.store.shopping.commons.GeneralBasicResponse;
import com.kardex.hulk.store.shopping.configuration.conector.rest.RestBaseService;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.infraestructure.out.product.mapper.IProductAdapterMapper;
import com.kardex.hulk.store.shopping.infraestructure.out.product.request.request.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ProductAdapter extends RestBaseService implements IProductPort {

    @Value(value = "${adapters.components.shopping.url}")
    private String uriProductComponent;

    @Value(value = "${adapters.components.shopping.methods.update.root}")
    private String uriProductComponentMethodUpdate;

    @Autowired
    private IProductAdapterMapper iProductAdapterMapper;

    @Override
    public boolean updateQuantitiesOfProductsSales(List<Product> productList) {
        String uriComplete = uriProductComponent + uriProductComponentMethodUpdate;
        ProductRequest request = new ProductRequest();
        Map<String, String> headers = new HashMap<>();
        request.setListProducts(productList.stream().map(rep -> iProductAdapterMapper.toDto(rep)).collect(Collectors.toList()));
        GeneralBasicResponse response = getClient().post(uriComplete,request, GeneralBasicResponse.class, MediaType.APPLICATION_JSON, headers);
        return response.getHttpStatus() == HttpStatus.OK.value() ? Boolean.TRUE : Boolean.FALSE;
    }
}
