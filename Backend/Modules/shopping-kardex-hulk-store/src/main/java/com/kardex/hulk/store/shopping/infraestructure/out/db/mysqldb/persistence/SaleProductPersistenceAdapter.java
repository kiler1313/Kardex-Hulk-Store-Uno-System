package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.persistence;

import com.kardex.hulk.store.shopping.application.port.out.db.ISaleProductPersistencePort;
import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.ProductEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper.IBillPersistenceMapper;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper.ISaleProductPersistenceMapper;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.repository.ISaleProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SaleProductPersistenceAdapter implements ISaleProductPersistencePort {

    private final ISaleProductRepository iSaleProductRepository;
    private final ISaleProductPersistenceMapper iSaleProductPersistenceMapper;
    private final IBillPersistenceMapper iBillPersistenceMapper;

    /**
     * Metodo de creación de productos vendidos persistencia a base de datos
     * @param saleProduct
     * @return
     */
    @Override
    public boolean createSalesProducts(SaleProduct saleProduct) {
        iSaleProductRepository.save(iSaleProductPersistenceMapper.toInfraestructure(saleProduct));
        return true;
    }

    /**
     * Metodo de creaciòn masiva de los productos vendidos, persistencia a base de datos
     * @param saleProducts
     * @return
     */
    @Override
    public boolean createListSalesProducts(List<SaleProduct> saleProducts) {
        iSaleProductRepository.saveAll(saleProducts.stream().map(resp -> iSaleProductPersistenceMapper.toInfraestructure(resp)).collect(Collectors.toList()));
        return true;
    }

    /**
     * Metodo de busqueda de los productos vendidos segùn la factura del usuario
     * @param bill
     * @return
     */
    @Override
    public List<SaleProduct> findByBill(Bill bill) {
        return iSaleProductRepository.findByBill(iBillPersistenceMapper.toInfraestructure(bill)).stream().map(resp -> iSaleProductPersistenceMapper.toDomain(resp)).collect(Collectors.toList());
    }
}
