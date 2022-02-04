package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.repository;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.BillEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.ProductEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.SaleProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISaleProductRepository extends CrudRepository<SaleProductEntity, Integer> {

    List<SaleProductEntity> findByBill(BillEntity bill);
    SaleProductEntity save(SaleProductEntity saleProductEntity);
}
