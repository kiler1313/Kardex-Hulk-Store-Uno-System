package com.kardex.hulk.store.shopping.infraestructure.in.command.dto;

import com.kardex.hulk.store.shopping.infraestructure.out.db.mysqldb.entities.ProductEntity;
import lombok.Data;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
public class SaleProductDto {

      private Integer id;  //Id general de la solicitud
      private String code; // Codigo general del detalle de la factura para el filtro
      private ProductEntity product; // Productos adquiridos
      private BillDto billDto; // Facturas que adquirieron dichos productos
      private Integer quantity; // Cantidades de productos comprados
      private String subTotal; // Precio de las cantidades de los productos comprados
      private String userCreate; // Usuario de creaciòn
      private String userUpdate; // Usuario de actualizacion
      private String dateCreate; // Fecha de creaciòn
      private String dateUpdate; // Fecha de actualizaciòn
}
