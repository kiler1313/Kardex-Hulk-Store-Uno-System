package com.kardex.hulk.store.shopping.infraestructure.out.authentication.adapter;

import com.kardex.hulk.store.shopping.application.port.out.authentication.IAuthenticationPort;
import com.kardex.hulk.store.shopping.commons.GeneralBasicResponse;
import com.kardex.hulk.store.shopping.configuration.conector.rest.RestBaseService;
import com.kardex.hulk.store.shopping.infraestructure.out.authentication.request.TokenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class AuthenticationAdapter extends RestBaseService implements IAuthenticationPort {

    @Value(value = "${adapters.components.authentication.url}")
    private String uriTokenComponent;

    @Value(value = "${adapters.components.authentication.methods.confirm.root}")
    private String uriTokenComponentMethodUpdate;


    @Override
    public boolean confirmTokenAccess(String token) {
        String uriComplete = uriTokenComponent + uriTokenComponentMethodUpdate;
        TokenDto request = new TokenDto();
        request.setToken(token);
        Map<String, String> headers = new HashMap<>();
        GeneralBasicResponse response = getClient().post(uriComplete,request, GeneralBasicResponse.class, MediaType.APPLICATION_JSON, headers);
        return response.getHttpStatus() == HttpStatus.OK.value() ? Boolean.TRUE : Boolean.FALSE;
    }
}