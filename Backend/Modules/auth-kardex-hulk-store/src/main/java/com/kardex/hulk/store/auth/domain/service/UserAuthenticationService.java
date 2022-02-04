package com.kardex.hulk.store.auth.domain.service;


import com.kardex.hulk.store.auth.application.port.in.IUserAuthenticationUseCase;
import com.kardex.hulk.store.auth.application.port.out.db.ITokenPersistencePort;
import com.kardex.hulk.store.auth.application.port.out.db.IUserPersistencePort;
import com.kardex.hulk.store.auth.commons.Constants;
import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.domain.models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class UserAuthenticationService implements IUserAuthenticationUseCase {

    @Autowired
    ITokenPersistencePort tokenPersistencePort;

    @Autowired
    IUserPersistencePort userPersistencePort;

    @Override
    public Token authenticationUser(User user) {
        User userAuthentication = userPersistencePort.findByUserIdAuthenticate(user);
        Token token = new Token();
        if (!Objects.isNull(userAuthentication))
        {
            token.setUser(userAuthentication);
            Token tokenUserAuthenticate = tokenPersistencePort.finByUser(userAuthentication.getId());
            if (!Objects.isNull(tokenUserAuthenticate))
            {
                token.setToken(RandomStringUtils.randomAlphabetic(Constants.RANDOM_CODE_ID).toUpperCase(Locale.ROOT));
                tokenPersistencePort.updateToken(tokenUserAuthenticate, token);
            }
            else
            {
                token.setToken(RandomStringUtils.randomAlphabetic(Constants.RANDOM_CODE_ID).toUpperCase(Locale.ROOT));
                tokenPersistencePort.createToken(token);
            }
        }
        return token;
    }
}
