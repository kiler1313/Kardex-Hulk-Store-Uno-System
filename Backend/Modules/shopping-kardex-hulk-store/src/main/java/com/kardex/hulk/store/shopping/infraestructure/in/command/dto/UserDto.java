package com.kardex.hulk.store.shopping.infraestructure.in.command.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
public class UserDto {


      private Integer id;  //Id general de la solicitud
      private String names; // Codigo de autorizaciòn generado de la factura
      private String userName; // Fecha de creaciòn de la factura
}
