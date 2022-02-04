package com.kardex.hulk.store.product.application.port.out.authentication;

import com.kardex.hulk.store.product.domain.models.Product;

import java.util.List;

public interface IAuthenticationPort {

    public boolean confirmTokenAccess(String token);

}
