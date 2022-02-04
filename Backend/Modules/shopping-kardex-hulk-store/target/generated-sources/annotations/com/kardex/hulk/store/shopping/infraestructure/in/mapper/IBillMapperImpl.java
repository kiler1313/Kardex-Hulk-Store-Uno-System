package com.kardex.hulk.store.shopping.infraestructure.in.mapper;

import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.User;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.BillDto;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-04T00:34:39-0500",
    comments = "version: 1.5.0.Beta2, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class IBillMapperImpl implements IBillMapper {

    @Override
    public BillDto toDto(Bill bill) {
        if ( bill == null ) {
            return null;
        }

        BillDto billDto = new BillDto();

        billDto.setId( bill.getId() );
        billDto.setCodeAuthorization( bill.getCodeAuthorization() );
        billDto.setStatus( bill.getStatus() );
        billDto.setDateCreate( bill.getDateCreate() );
        billDto.setDateSendProduct( bill.getDateSendProduct() );
        billDto.setIsSend( bill.getIsSend() );
        billDto.setIsPickUpStore( bill.getIsPickUpStore() );
        billDto.setTotalValue( bill.getTotalValue() );
        billDto.setUserCreate( bill.getUserCreate() );
        billDto.setUserUpdate( bill.getUserUpdate() );
        billDto.setUser( userToUserDto( bill.getUser() ) );

        return billDto;
    }

    @Override
    public Bill toDomain(BillDto billDto) {
        if ( billDto == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setId( billDto.getId() );
        bill.setCodeAuthorization( billDto.getCodeAuthorization() );
        bill.setStatus( billDto.getStatus() );
        bill.setDateCreate( billDto.getDateCreate() );
        bill.setDateSendProduct( billDto.getDateSendProduct() );
        bill.setIsSend( billDto.getIsSend() );
        bill.setIsPickUpStore( billDto.getIsPickUpStore() );
        bill.setTotalValue( billDto.getTotalValue() );
        bill.setUserCreate( billDto.getUserCreate() );
        bill.setUserUpdate( billDto.getUserUpdate() );
        bill.setUser( userDtoToUser( billDto.getUser() ) );

        return bill;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setNames( user.getNames() );
        userDto.setUserName( user.getUserName() );

        return userDto;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setNames( userDto.getNames() );
        user.setUserName( userDto.getUserName() );

        return user;
    }
}
