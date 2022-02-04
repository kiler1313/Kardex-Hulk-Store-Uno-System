package com.kardex.hulk.store.shopping.application.port.out.db;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.User;

import java.util.List;

public interface IBillPersistencePort {

    public boolean createBill(Bill bill);
    boolean updateBill(Bill billFind, Bill billUpdate);
    public List<Bill> findByUserBills(User user);
    public Bill findByCodeBill(String codeAuthorization);

}
