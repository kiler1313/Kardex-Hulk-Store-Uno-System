package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.persistence;

import com.kardex.hulk.store.auth.application.port.out.db.ITokenPersistencePort;
import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.TokenEntity;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.mapper.ITokenPersistenceMapper;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.repository.ITokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenPersistenceAdapter implements ITokenPersistencePort {

    private final ITokenRepository iTokenRepository;
    private final ITokenPersistenceMapper iTokenPersistenceMapper;

    /**
     * Metodo de creación de productos vendidos persistencia a base de datos
     * @param saleProduct
     * @return
     */
    @Override
    public boolean createToken(Token saleProduct) {
        iTokenRepository.save(iTokenPersistenceMapper.toInfraestructure(saleProduct));
        return true;
    }

    /**
     * Metodo de actualización del token para consumir servicios
     * @param tokenFind
     * @param tokenUpdate
     * @return
     */
    @Override
    public boolean updateToken(Token tokenFind, Token tokenUpdate) {
        TokenEntity tokenFindForUpdate = iTokenPersistenceMapper.toInfraestructure(tokenFind);
        iTokenPersistenceMapper.updateTokenEntityFromToken(tokenUpdate, tokenFindForUpdate);
        iTokenRepository.save(tokenFindForUpdate);
        return true;
    }

    /**
     * Metodo de busqueda del token del usuario para autorizar
     * @param token
     * @return
     */
    @Override
    public Token findByToken(String token) {
        return iTokenPersistenceMapper.toDomain(iTokenRepository.findByToken(token));
    }

    @Override
    public Token finByUser(Integer id) {
        return iTokenPersistenceMapper.toDomain(iTokenRepository.findByUserId(id));
    }
}
