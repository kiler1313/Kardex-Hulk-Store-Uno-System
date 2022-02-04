package com.kardex.hulk.store.product.domain.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
}
