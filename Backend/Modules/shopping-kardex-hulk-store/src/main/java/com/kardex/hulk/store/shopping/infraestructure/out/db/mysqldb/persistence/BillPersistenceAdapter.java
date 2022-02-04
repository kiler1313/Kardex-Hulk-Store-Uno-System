package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.persistence;

import com.kardex.hulk.store.shopping.application.port.out.db.IBillPersistencePort;
import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.domain.models.SaleProduct;
import com.kardex.hulk.store.shopping.domain.models.User;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.BillEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.ProductEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper.IBillPersistenceMapper;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper.ISaleProductPersistenceMapper;
import com.kardex.hulk.store.shopping.application.port.out.db.ISaleProductPersistencePort;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper.IUserPersistenceMapper;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.repository.IBillRepository;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.repository.ISaleProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BillPersistenceAdapter implements IBillPersistencePort {

    private final IBillRepository iBillRepository;
    private final IBillPersistenceMapper iBillPersistenceMapper;
    private final IUserPersistenceMapper iUserPersistenceMapper;

    /**
     * Metodo de creación de la factura. persistencia a base de datos
     * @param bill
     * @return
     */
    @Override
    public boolean createBill(Bill bill) {
        iBillRepository.save(iBillPersistenceMapper.toInfraestructure(bill));
        return true;
    }

    /**
     * Metodo de actualización de la factura para confirmar entrega o recogida de producto
     * @param billFind
     * @param billUpdate
     * @return
     */
    @Override
    public boolean updateBill(Bill billFind, Bill billUpdate) {
        BillEntity billFindForUpdate = iBillPersistenceMapper.toInfraestructure(billFind);
        iBillPersistenceMapper.updateBillEntityFromBill(billUpdate, billFindForUpdate);
        iBillRepository.save(billFindForUpdate);
        return true;
    }

    /**
     * Metodo que permite buscar las facturas asociadas al usuario, persistencia a base de datos
     * @param user
     * @return
     */
    @Override
    public List<Bill> findByUserBills(User user) {
        return iBillRepository.findByUser(iUserPersistenceMapper.toInfraestructure(user)).stream().map(res -> iBillPersistenceMapper.toDomain(res)).collect(Collectors.toList());
    }

    /**
     * Metodo que permite buscar las facturas asociadas al codigo generado, persistencia a base de datos
     * @param codeAuthorization
     * @return
     */
    @Override
    public Bill findByCodeBill(String codeAuthorization) {
        return iBillPersistenceMapper.toDomain(iBillRepository.findFirstByCodeAuthorization(codeAuthorization));
    }
}
