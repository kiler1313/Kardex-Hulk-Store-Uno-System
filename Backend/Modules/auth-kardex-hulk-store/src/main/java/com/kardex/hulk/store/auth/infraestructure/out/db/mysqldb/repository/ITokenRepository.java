package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.repository;

import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.TokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITokenRepository extends CrudRepository<TokenEntity, Integer> {

    TokenEntity findByToken(String token);
    TokenEntity findByUserId(Integer id);
    TokenEntity save(TokenEntity tokenEntity);
}