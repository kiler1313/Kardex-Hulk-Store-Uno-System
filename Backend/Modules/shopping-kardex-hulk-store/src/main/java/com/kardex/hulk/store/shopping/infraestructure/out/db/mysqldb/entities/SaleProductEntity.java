package com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities;

import com.kardex.hulk.store.shopping.commons.Constants;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
@Entity
@Table(name = "bills", schema = "kardex_hulk_store")
public class SaleProductEntity {

      @Id
      @GeneratedValue(strategy= GenerationType.IDENTITY)
      private Integer id;  //Id general de la solicitud
      @Column( name = "code")
      private String code; // Codigo general del detalle de la factura para el filtro
      @ManyToOne
      @JoinColumn( name = "id_products")
      private ProductEntity product; // Productos adquiridos
      @ManyToOne
      @JoinColumn( name = "id_bills")
      private BillEntity bill; // Facturas que adquirieron dichos productos
      @Column( name = "quantity")
      private Integer quantity; // Cantidades de productos comprados
      @Column( name = "sub_total")
      @ColumnTransformer(
              read =  "AES_DECRYPT(value, '"+ Constants.ENCRYPTED_PASSWORD +"')",
              write = "AES_ENCRYPT(?, '"+ Constants.ENCRYPTED_PASSWORD +"')")
      private String subTotal; // Precio de las cantidades de los productos comprados
      @Column( name = "user_create")
      private String userCreate; // Usuario de creaciòn
      @Column( name = "user_update")
      private String userUpdate; // Usuario de actualizacion
      @Column( name = "date_create")
      private String dateCreate; // Fecha de creaciòn
      @Column( name = "date_update")
      private String dateUpdate; // Fecha de actualizaciòn
}
