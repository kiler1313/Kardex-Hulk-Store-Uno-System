package com.kardex.hulk.store.shopping.application.port.out.db;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;

import java.util.List;

public interface ISaleProductPersistencePort {

    public boolean createSalesProducts(SaleProduct saleProduct);
    public boolean createListSalesProducts(List<SaleProduct> saleProducts);
    public List<SaleProduct> findByBill(Bill bill);

}
