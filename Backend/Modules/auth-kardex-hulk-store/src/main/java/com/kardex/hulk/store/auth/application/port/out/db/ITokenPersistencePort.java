package com.kardex.hulk.store.auth.application.port.out.db;

import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.domain.models.User;

public interface ITokenPersistencePort {

    public boolean createToken(Token token);
    public boolean updateToken(Token tokenFind, Token tokenUpdate);
    public Token findByToken(String token);
    public Token finByUser(Integer id);

}
