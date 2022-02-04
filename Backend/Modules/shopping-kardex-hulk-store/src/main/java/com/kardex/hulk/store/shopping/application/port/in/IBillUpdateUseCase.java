package com.kardex.hulk.store.shopping.application.port.in;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;

import java.util.List;
import java.util.Map;

public interface IBillUpdateUseCase {

    Map<Boolean, Bill> updateBill(Bill bill);
}
