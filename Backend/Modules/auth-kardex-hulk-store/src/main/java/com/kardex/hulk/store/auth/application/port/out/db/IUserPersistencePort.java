package com.kardex.hulk.store.auth.application.port.out.db;

import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.domain.models.User;

import java.util.List;

public interface IUserPersistencePort {

    public User createUser(User user);
    boolean updateUser(User userFind, User userUpdate);
    public User findByUserIdAuthenticate(User user);

}
