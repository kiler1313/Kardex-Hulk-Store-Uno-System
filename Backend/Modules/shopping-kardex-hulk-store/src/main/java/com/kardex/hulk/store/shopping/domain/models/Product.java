package com.kardex.hulk.store.shopping.domain.models;

import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.SaleProductEntity;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * Model to level in domain Kardex - Hulk Store
 */
@Data
public class Product {

      private Integer id; //Id general de la solicitud
      private String code; // Codigo del producto
      private String name; // Nombre del producto
      private Integer stock; // Numero de stock
      private String value; // Valor del producto
      private Integer status; // Estado del producto
      private String color;  // Opciones adicionales color
      private String weight;  // Opciones adicionales peso
      private String height;  // Opciones adicionales altura
      private Boolean isFreeSend; // Tiene envio gratis?
      private String userCreate; // Usuario de creacion
      private String userUpdate; // Usuario de actualizacion
      private Date dateCreation; // Fecha de creacion
      private Date dateUpdate; // Fecha de actualizaciòn
      private String img; // Imagen del producto
      private Integer quantity ; // Cantidad vendida
      Set<SaleProductEntity> salesProducts; // Mapping de la relaciòn de muchos a muchos de la table SalesProducts
}
