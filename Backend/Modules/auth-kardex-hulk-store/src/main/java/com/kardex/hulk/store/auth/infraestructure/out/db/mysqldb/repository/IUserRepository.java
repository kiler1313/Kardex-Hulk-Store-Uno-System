package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.repository;

import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findFirstByUserNameAndPassword(String userName, String password);
    UserEntity save(UserEntity tokenEntity);
}
