package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.mapper;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.User;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.BillEntity;
import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:39-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class IBillPersistenceMapperImpl implements IBillPersistenceMapper {

    @Override
    public Bill toDomain(BillEntity billEntity) {
        if ( billEntity == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setId( billEntity.getId() );
        bill.setCodeAuthorization( billEntity.getCodeAuthorization() );
        bill.setStatus( billEntity.getStatus() );
        bill.setDateCreate( billEntity.getDateCreate() );
        bill.setDateSendProduct( billEntity.getDateSendProduct() );
        bill.setIsSend( billEntity.getIsSend() );
        bill.setIsPickUpStore( billEntity.getIsPickUpStore() );
        bill.setTotalValue( billEntity.getTotalValue() );
        bill.setUserCreate( billEntity.getUserCreate() );
        bill.setUserUpdate( billEntity.getUserUpdate() );
        bill.setUser( userEntityToUser( billEntity.getUser() ) );

        return bill;
    }

    @Override
    public BillEntity toInfraestructure(Bill bill) {
        if ( bill == null ) {
            return null;
        }

        BillEntity billEntity = new BillEntity();

        billEntity.setId( bill.getId() );
        billEntity.setCodeAuthorization( bill.getCodeAuthorization() );
        billEntity.setStatus( bill.getStatus() );
        billEntity.setDateCreate( bill.getDateCreate() );
        billEntity.setDateSendProduct( bill.getDateSendProduct() );
        billEntity.setIsSend( bill.getIsSend() );
        billEntity.setIsPickUpStore( bill.getIsPickUpStore() );
        billEntity.setTotalValue( bill.getTotalValue() );
        billEntity.setUserCreate( bill.getUserCreate() );
        billEntity.setUserUpdate( bill.getUserUpdate() );
        billEntity.setUser( userToUserEntity( bill.getUser() ) );

        return billEntity;
    }

    @Override
    public void updateBillEntityFromBill(Bill bill, BillEntity billEntity) {
        if ( bill == null ) {
            return;
        }

        if ( bill.getId() != null ) {
            billEntity.setId( bill.getId() );
        }
        if ( bill.getCodeAuthorization() != null ) {
            billEntity.setCodeAuthorization( bill.getCodeAuthorization() );
        }
        if ( bill.getStatus() != null ) {
            billEntity.setStatus( bill.getStatus() );
        }
        if ( bill.getDateCreate() != null ) {
            billEntity.setDateCreate( bill.getDateCreate() );
        }
        if ( bill.getDateSendProduct() != null ) {
            billEntity.setDateSendProduct( bill.getDateSendProduct() );
        }
        if ( bill.getIsSend() != null ) {
            billEntity.setIsSend( bill.getIsSend() );
        }
        if ( bill.getIsPickUpStore() != null ) {
            billEntity.setIsPickUpStore( bill.getIsPickUpStore() );
        }
        if ( bill.getTotalValue() != null ) {
            billEntity.setTotalValue( bill.getTotalValue() );
        }
        if ( bill.getUserCreate() != null ) {
            billEntity.setUserCreate( bill.getUserCreate() );
        }
        if ( bill.getUserUpdate() != null ) {
            billEntity.setUserUpdate( bill.getUserUpdate() );
        }
        if ( bill.getUser() != null ) {
            if ( billEntity.getUser() == null ) {
                billEntity.setUser( new UserEntity() );
            }
            userToUserEntity1( bill.getUser(), billEntity.getUser() );
        }
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setNames( userEntity.getNames() );
        user.setSurnames( userEntity.getSurnames() );
        user.setUserName( userEntity.getUserName() );
        user.setPassword( userEntity.getPassword() );
        user.setDateOfBirth( userEntity.getDateOfBirth() );
        user.setCreditCard( userEntity.getCreditCard() );
        user.setTypeCreditCard( userEntity.getTypeCreditCard() );
        user.setAddress( userEntity.getAddress() );
        user.setIdRoles( userEntity.getIdRoles() );

        return user;
    }

    protected UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setNames( user.getNames() );
        userEntity.setSurnames( user.getSurnames() );
        userEntity.setUserName( user.getUserName() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setDateOfBirth( user.getDateOfBirth() );
        userEntity.setCreditCard( user.getCreditCard() );
        userEntity.setTypeCreditCard( user.getTypeCreditCard() );
        userEntity.setAddress( user.getAddress() );
        userEntity.setIdRoles( user.getIdRoles() );

        return userEntity;
    }

    protected void userToUserEntity1(User user, UserEntity mappingTarget) {
        if ( user == null ) {
            return;
        }

        if ( user.getId() != null ) {
            mappingTarget.setId( user.getId() );
        }
        if ( user.getNames() != null ) {
            mappingTarget.setNames( user.getNames() );
        }
        if ( user.getSurnames() != null ) {
            mappingTarget.setSurnames( user.getSurnames() );
        }
        if ( user.getUserName() != null ) {
            mappingTarget.setUserName( user.getUserName() );
        }
        if ( user.getPassword() != null ) {
            mappingTarget.setPassword( user.getPassword() );
        }
        if ( user.getDateOfBirth() != null ) {
            mappingTarget.setDateOfBirth( user.getDateOfBirth() );
        }
        if ( user.getCreditCard() != null ) {
            mappingTarget.setCreditCard( user.getCreditCard() );
        }
        if ( user.getTypeCreditCard() != null ) {
            mappingTarget.setTypeCreditCard( user.getTypeCreditCard() );
        }
        if ( user.getAddress() != null ) {
            mappingTarget.setAddress( user.getAddress() );
        }
        if ( user.getIdRoles() != null ) {
            mappingTarget.setIdRoles( user.getIdRoles() );
        }
    }
}
