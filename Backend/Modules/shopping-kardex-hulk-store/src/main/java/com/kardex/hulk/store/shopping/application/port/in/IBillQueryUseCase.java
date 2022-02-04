package com.kardex.hulk.store.shopping.application.port.in;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.User;

import java.util.List;

public interface IBillQueryUseCase {

    List<Bill> findByUserBills(User user);
}
