package com.kardex.hulk.store.auth.application.port.in;

import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.domain.models.User;

import java.util.List;

public interface IUserCreateUseCase {

    Token createUser(User user);
}
