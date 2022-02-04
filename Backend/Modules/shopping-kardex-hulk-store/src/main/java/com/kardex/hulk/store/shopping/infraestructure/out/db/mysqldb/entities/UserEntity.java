package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities;

import com.kardex.hulk.store.shopping.commons.Constants;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
@Entity
@Table(name = "bills", schema = "kardex_hulk_store")
public class UserEntity {

      @Id
      @GeneratedValue(strategy= GenerationType.IDENTITY)
      private Integer id;  //Id general de la solicitud
      @Column( name = "names")
      private String names; // Codigo de autorizaciòn generado de la factura
      @Column( name = "surnames")
      private Integer surnames; // Estado de la factura
      @Column( name = "user_name")
      private String userName; // Fecha de creaciòn de la factura
      @Column( name = "password")
      private String password; // Fecha de despacho o recogida de los productos
      @Column( name = "date_of_birth")
      private Boolean dateOfBirth; // Validaciòn de envio a domicilio
      @Column( name = "credit_card")
      private String creditCard; // Validaciòn de recoger en tienda
      @Column(name = "type_credit_card")
      private String typeCreditCard; // Valor total de la factura
      @Column( name = "address")
      private String address; // Usuario creador de la factura
      @Column( name = "id_roles")
      private Integer idRoles; // Usuario que actualizo la factura
}
