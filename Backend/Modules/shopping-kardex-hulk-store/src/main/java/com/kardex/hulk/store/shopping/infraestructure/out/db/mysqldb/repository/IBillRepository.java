package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.repository;

import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.BillEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends CrudRepository<BillEntity, Integer> {

    List<BillEntity> findByUser(UserEntity userEntity);
    BillEntity save(BillEntity billEntity);
    BillEntity findFirstByCodeAuthorization(String codeAuthorization);
}
