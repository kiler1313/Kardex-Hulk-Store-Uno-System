package com.kardex.hulk.store.shopping.domain.models;

import lombok.Data;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
public class SaleProduct {

      private Integer id;  //Id general de la solicitud
      private String code; // Codigo general del detalle de la factura para el filtro
      private Product product; // Productos adquiridos
      private Bill bill; // Facturas que adquirieron dichos productos
      private Integer quantity; // Cantidades de productos comprados
      private String subTotal; // Precio de las cantidades de los productos comprados
      private String userCreate; // Usuario de creaciòn
      private String userUpdate; // Usuario de actualizacion
      private String dateCreate; // Fecha de creaciòn
      private String dateUpdate; // Fecha de actualizaciòn
}
