package com.kardex.hulk.store.shopping.domain.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
public class User {

      private Integer id;  //Id general de la solicitud
      private String names; // Codigo de autorizaciòn generado de la factura
      private Integer surnames; // Estado de la factura
      private String userName; // Fecha de creaciòn de la factura
      private String password; // Fecha de despacho o recogida de los productos
      private Boolean dateOfBirth; // Validaciòn de envio a domicilio
      private String creditCard; // Validaciòn de recoger en tienda
      private String typeCreditCard; // Valor total de la factura
      private String address; // Usuario creador de la factura
      private Integer idRoles; // Usuario que actualizo la factura
}
