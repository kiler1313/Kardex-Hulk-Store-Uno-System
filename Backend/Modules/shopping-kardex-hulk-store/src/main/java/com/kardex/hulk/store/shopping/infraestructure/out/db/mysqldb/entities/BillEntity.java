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
public class BillEntity {

      @Id
      @GeneratedValue(strategy= GenerationType.IDENTITY)
      private Integer id;  //Id general de la solicitud
      @Column( name = "code_authorization")
      private String codeAuthorization; // Codigo de autorizaciòn generado de la factura
      @Column( name = "status")
      private Integer status; // Estado de la factura
      @Column( name = "date_create")
      private Date dateCreate; // Fecha de creaciòn de la factura
      @Column( name = "date_send_product")
      private Date dateSendProduct; // Fecha de despacho o recogida de los productos
      @Column( name = "is_send")
      @Type(type = "org.hibernate.type.NumericBooleanType")
      private Boolean isSend; // Validaciòn de envio a domicilio
      @Column( name = "is_pick_up_store")
      @Type(type = "org.hibernate.type.NumericBooleanType")
      private Boolean isPickUpStore; // Validaciòn de recoger en tienda
      @Column(name = "total_value")
      @ColumnTransformer(
              read =  "AES_DECRYPT(value, '"+ Constants.ENCRYPTED_PASSWORD +"')",
              write = "AES_ENCRYPT(?, '"+ Constants.ENCRYPTED_PASSWORD +"')")
      private String totalValue; // Valor total de la factura
      @Column( name = "user_create")
      private String userCreate; // Usuario creador de la factura
      @Column( name = "user_update")
      private String userUpdate; // Usuario que actualizo la factura
      @OneToMany(mappedBy = "bill")
      Set<SaleProductEntity> salesProducts; // Mapping de la relaciòn de muchos a muchos de la table SalesProducts
      @ManyToOne
      @JoinColumn(name = "id_user")
      private UserEntity user;

}
