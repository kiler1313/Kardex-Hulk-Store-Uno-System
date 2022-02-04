package com.kardex.hulk.store.shopping.application.port.out.authentication;

public interface IAuthenticationPort {

    public boolean confirmTokenAccess(String token);

}
