package com.kardex.hulk.store.auth.domain.service;

import com.kardex.hulk.store.auth.application.port.in.IUserTokenConfirmUseCase;
import com.kardex.hulk.store.auth.application.port.out.db.ITokenPersistencePort;
import com.kardex.hulk.store.auth.domain.models.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserTokenConfirmService implements IUserTokenConfirmUseCase {

    @Autowired
    ITokenPersistencePort persistencePort;

    @Override
    public Boolean tokenConfirm(String token) {
        Token tokenAuthentication = persistencePort.findByToken(token);
        return tokenAuthentication != null ? tokenAuthentication.getToken() != null & tokenAuthentication.getToken() != "" ? Boolean.TRUE : Boolean.FALSE : Boolean.FALSE;
    }
}
