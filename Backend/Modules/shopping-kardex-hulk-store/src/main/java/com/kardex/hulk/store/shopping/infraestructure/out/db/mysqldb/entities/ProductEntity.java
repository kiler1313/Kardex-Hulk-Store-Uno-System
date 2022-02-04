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
@Table(name = "products", schema = "kardex_hulk_store")
public class ProductEntity {

      @Id
      @GeneratedValue(strategy= GenerationType.IDENTITY)
      private Integer id;  //Id general de la solicitud
      @Column( name = "code")
      private String code; // Codigo del producto
      @Column( name = "name")
      private String name; // Nombre del producto
      @Column( name = "stock")
      private Integer stock; // Numero de stock
      @Column( name = "value")
      @ColumnTransformer(
              read =  "AES_DECRYPT(value, '"+ Constants.ENCRYPTED_PASSWORD +"')",
              write = "AES_ENCRYPT(?, '"+ Constants.ENCRYPTED_PASSWORD +"')")
      private String value; // Valor del producto
      @Column( name = "status")
      private Integer status; // Estado del producto
      @Column( name = "color")
      private String color;  // Opciones adicionales color
      @Column( name = "weight")
      private String weight;  // Opciones adicionales peso
      @Column( name = "height")
      private String height;  // Opciones adicionales altura
      @Column( name = "is_free_send")
      @Type(type = "org.hibernate.type.NumericBooleanType")
      private Boolean isFreeSend; // Tiene envio gratis?
      @Column( name = "user_create")
      private String userCreate; // Usuario de creacion
      @Column( name = "user_update")
      private String userUpdate; // Usuario de actualizacion
      @Column( name = "date_create")
      private Date dateCreation;  // Fecha de creacion
      @Column( name = "date_update")
      private Date dateUpdate;  // Fecha de actualizaciòn
      @Column( name = "img")
      private String img; // Imagen del producto
      @OneToMany(mappedBy = "product")
      Set<SaleProductEntity> salesProducts; // Mapping de la relaciòn de muchos a muchos de la table SalesProducts


}
