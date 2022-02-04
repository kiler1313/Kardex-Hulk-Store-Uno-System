package com.kardex.hulk.store.product.infraestructure.out.authentication.adapter;

import com.kardex.hulk.store.product.application.port.out.authentication.IAuthenticationPort;
import com.kardex.hulk.store.product.configuration.conector.rest.RestBaseService;
import com.kardex.hulk.store.product.infraestructure.out.authentication.request.TokenDto;
import com.kardex.hulk.store.product.commons.GeneralBasicResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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