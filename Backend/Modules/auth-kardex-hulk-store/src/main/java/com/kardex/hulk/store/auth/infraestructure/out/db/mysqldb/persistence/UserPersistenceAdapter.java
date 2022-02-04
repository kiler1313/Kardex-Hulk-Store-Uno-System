package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.persistence;

import com.kardex.hulk.store.auth.application.port.out.db.IUserPersistencePort;
import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.domain.models.User;
import com.kardex.hulk.store.auth.infraestructure.in.mapper.IUserMapper;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.mapper.IUserPersistenceMapper;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {

    private final IUserRepository iUserRepository;
    private final IUserPersistenceMapper iUserPersistenceMapper;

    /**
     * Metodo de creación de la usuario. persistencia a base de datos
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        return iUserPersistenceMapper.toDomain(iUserRepository.save(iUserPersistenceMapper.toInfraestructure(user)));
    }

    /**
     * Metodo de actualización de la usuario para confirmar entrega o recogida de producto
     * @param userFind
     * @param userUpdate
     * @return
     */
    @Override
    public boolean updateUser(User userFind, User userUpdate) {
        UserEntity userFindForUpdate = iUserPersistenceMapper.toInfraestructure(userFind);
        iUserPersistenceMapper.updateUserEntityFromUser(userUpdate, userFindForUpdate);
        iUserRepository.save(userFindForUpdate);
        return true;
    }

    /**
     * Metodo que permite buscar las usuarios asociadas al usuario, persistencia a base de datos
     * @param user
     * @return
     */
    @Override
    public User findByUserIdAuthenticate(User user) {
        return iUserPersistenceMapper.toDomain(iUserRepository.findFirstByUserNameAndPassword(user.getUserName(),user.getPassword()));
    }

}
