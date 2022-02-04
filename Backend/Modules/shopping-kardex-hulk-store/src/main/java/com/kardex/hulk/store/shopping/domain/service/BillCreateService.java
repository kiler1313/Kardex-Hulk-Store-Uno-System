package com.kardex.hulk.store.shopping.domain.service;

import com.kardex.hulk.store.shopping.application.port.out.db.IBillPersistencePort;
import com.kardex.hulk.store.shopping.application.port.out.db.ISaleProductPersistencePort;
import com.kardex.hulk.store.shopping.application.port.out.product.IProductPort;
import com.kardex.hulk.store.shopping.commons.Constants;
import com.kardex.hulk.store.shopping.application.port.in.IBillCreateUseCase;
import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BillCreateService implements IBillCreateUseCase {

    @Autowired
    ISaleProductPersistencePort saleProductPersistencePort;

    @Autowired
    IBillPersistencePort billPersistencePort;

    @Autowired
    IProductPort productPort;

    @Override
    public Boolean createBill(List<Product> listProduct, Bill bill) {
        AtomicReference<Integer> totalValuesProductsToBill = new AtomicReference<>(0);
        List<SaleProduct> listSalesProductForCreate = new ArrayList<>();
        Boolean isCreateAllBill = false;
        bill.setCodeAuthorization(RandomStringUtils.randomAlphabetic(Constants.RANDOM_CODE_ID).toUpperCase(Locale.ROOT));
        bill.setStatus(bill.getIsSend() ? Constants.PENDING_SHIPPING : bill.getIsPickUpStore() ? Constants.PENDING_OUT_PICK_UP_STORE : Constants.COMPLETE_AND_DELIVERED);
        bill.setDateCreate(new Date());
        listProduct.stream().forEach(product -> {
            SaleProduct saleProduct = new SaleProduct();
            Integer subTotalDetail  = (Integer.parseInt(product.getValue()) * product.getQuantity());
            saleProduct.setCode(RandomStringUtils.randomAlphabetic(Constants.RANDOM_CODE_ID).toUpperCase(Locale.ROOT));
            saleProduct.setProduct(product);
            saleProduct.setBill(bill);
            saleProduct.setQuantity(product.getQuantity());
            saleProduct.setSubTotal(subTotalDetail.toString());
            listSalesProductForCreate.add(saleProduct);
            totalValuesProductsToBill.updateAndGet(value -> value + subTotalDetail);
        });
        bill.setTotalValue(totalValuesProductsToBill.get().toString());
        Boolean isUpdateProductsInStock = productPort.updateQuantitiesOfProductsSales(listProduct);
        if (isUpdateProductsInStock)
        {
            billPersistencePort.createBill(bill);
            saleProductPersistencePort.createListSalesProducts(listSalesProductForCreate);
            isCreateAllBill = Boolean.TRUE;
        }else
        {
            isCreateAllBill = Boolean.FALSE;
        }
        return  isCreateAllBill;
    }

}
