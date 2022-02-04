package com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.persistence;

import com.kardex.hulk.store.product.application.port.out.db.IProductPersistencePort;
import com.kardex.hulk.store.product.domain.models.Product;
import com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.entities.ProductEntity;
import com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.mapper.IProductPersistenceMapper;
import com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements IProductPersistencePort {

    private final IProductRepository iProductRepository;
    private final IProductPersistenceMapper iProductPersistenceMapper;

    /**
     * Metodo de creación de producto persistencia a base de datos
     * @param product
     * @return
     */
    @Override
    public boolean createProduct(Product product) {
        iProductRepository.save(iProductPersistenceMapper.toInfraestructure(product));
        return true;
    }

    /**
     * Metodo de creación de producto persistencia a base de datos
     * @param product
     * @return
     */
    @Override
    public boolean createListProduct(List<Product> product) {
        iProductRepository.saveAll(product.stream().map(resp -> iProductPersistenceMapper.toInfraestructure(resp)).collect(Collectors.toList()));
        return true;
    }

    /**
     * Metodo de actualización de producto persistencia a base de datos
     * @param productFind
     * @param productUpdate
     * @return
     */
    @Override
    public boolean updateProductSend(Product productFind, Product productUpdate) {
        ProductEntity productEntityFindToUpdate = iProductPersistenceMapper.toInfraestructure(productFind);
        iProductPersistenceMapper.updateProductEntityFromProduct(productUpdate, productEntityFindToUpdate);
        iProductRepository.save(productEntityFindToUpdate);
        return true;
    }

    /**
     * Metodo para busqueda de producto segun el codigo, persistencia a base de datos
     * @param code
     * @return
     */
    @Override
    public List<Product> findByCode(String code) {
        return iProductRepository.findByCode(code).stream().map(resp -> iProductPersistenceMapper.toDomain(resp)).collect(Collectors.toList());
    }

    /**
     * Metodo para busqueda de producto según el codigo y el estado (Constante = 1 Activo, 2 = Sin Stock, 3 = Promocion, 4 = Desactivado ), persistencia a base de datos
     * @param code
     * @param status
     * @return
     */
    @Override
    public Product findFirstByCodeAndStatus(String code, Integer status) {
        return iProductPersistenceMapper.toDomain(iProductRepository.findFirstByCodeAndStatusOrderByDateCreationAsc(code, status));
    }

    /**
     * Metodo para busqueda de producto segun el codigo, color, peso y altura
     * @param code
     * @param color
     * @param weight
     * @param height
     * @return
     */
    @Override
    public Product findFirstByCodeAndColorAndWeightAndHeight(String code, String color, String weight, String height) {
        return iProductPersistenceMapper.toDomain(iProductRepository.findFirstByCodeAndColorAndWeightAndHeight( code,  color,  weight, height));
    }

    /**
     * Metodo para busqueda de producto según tenga envio gratis, persistencia a base de datos
     * @param status
     * @return
     */
    @Override
    public List<Product> findByIsFreeSend(Boolean status) {
        return iProductRepository.findByIsFreeSend(status).stream().map(resp -> iProductPersistenceMapper.toDomain(resp)).collect(Collectors.toList());
    }

    /**
     * Metodo para busqueda de producto según el estado (Constante = 1 Activo, 2 = Sin Stock, 3 = Promocion, 4 = Desactivado )
     * @param status
     * @return
     */
    @Override
    public List<Product> findByStatus(Integer status) {
        return iProductRepository.findByStatus(status).stream().map(resp -> iProductPersistenceMapper.toDomain(resp)).collect(Collectors.toList());
    }
}
