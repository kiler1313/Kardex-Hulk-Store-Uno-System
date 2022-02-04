package com.kardex.hulk.store.shopping.domain.service;

import com.kardex.hulk.store.shopping.application.port.in.IBillUpdateUseCase;
import com.kardex.hulk.store.shopping.application.port.out.db.IBillPersistencePort;
import com.kardex.hulk.store.shopping.domain.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class BillUpdateService implements IBillUpdateUseCase {

    @Autowired
    IBillPersistencePort persistencePort;

    @Override
    public Map<Boolean, Bill> updateBill(Bill bill) {
        Map<Boolean, Bill> response = new HashMap<>();
        Bill findBillUpdate = persistencePort.findByCodeBill(bill.getCodeAuthorization());
        if (!Objects.isNull(findBillUpdate))
        {
            persistencePort.updateBill(findBillUpdate, bill);
            response.put(Boolean.TRUE, bill);
        }
        else
        {
            response.put(Boolean.FALSE, bill);
        }
        return response;
    }

}
