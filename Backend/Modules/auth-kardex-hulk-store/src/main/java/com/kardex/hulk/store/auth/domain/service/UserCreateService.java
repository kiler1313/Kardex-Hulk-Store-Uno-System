package com.kardex.hulk.store.auth.domain.service;

import com.kardex.hulk.store.auth.application.port.in.IUserCreateUseCase;
import com.kardex.hulk.store.auth.application.port.out.db.ITokenPersistencePort;
import com.kardex.hulk.store.auth.application.port.out.db.IUserPersistencePort;
import com.kardex.hulk.store.auth.commons.Constants;
import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.domain.models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserCreateService implements IUserCreateUseCase {

    @Autowired
    ITokenPersistencePort tokenPersistencePort;

    @Autowired
    IUserPersistencePort userPersistencePort;

    @Override
    public Token createUser( User user) {
        User userCreated = userPersistencePort.createUser(user);
        Token tokenCreate = new Token();
        tokenCreate.setUser(userCreated);
        tokenCreate.setToken(RandomStringUtils.randomAlphabetic(Constants.RANDOM_CODE_ID).toUpperCase(Locale.ROOT));
        tokenPersistencePort.createToken(tokenCreate);
        return  tokenCreate;
    }

}
