package com.kardex.hulk.store.shopping.domain.service;


import com.kardex.hulk.store.shopping.application.port.in.IBillQueryUseCase;
import com.kardex.hulk.store.shopping.application.port.out.db.IBillPersistencePort;
import com.kardex.hulk.store.shopping.application.port.out.db.ISaleProductPersistencePort;
import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillQueryService implements IBillQueryUseCase {

    @Autowired
    IBillPersistencePort persistencePort;

    @Override
    public List<Bill> findByUserBills(User user) {
        return persistencePort.findByUserBills(user);
    }
}
