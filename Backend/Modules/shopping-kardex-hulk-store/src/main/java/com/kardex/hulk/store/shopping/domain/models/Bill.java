package com.kardex.hulk.store.shopping.domain.models;

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
public class Bill {

      private Integer id;  //Id general de la solicitud
      private String codeAuthorization;  //Id general de la solicitud
      private Integer status; // Estado de la factura
      private Date dateCreate; // Codigo de autorizaciòn generado de la factura
      private Date dateSendProduct; // Fecha de creaciòn de la factura
      private Boolean isSend; // Fecha de despacho o recogida de los productos
      private Boolean isPickUpStore; // Validaciòn de envio a domicilio
      private String totalValue; // Validaciòn de recoger en tienda
      private String userCreate; // Valor total de la factura
      private String userUpdate; // Usuario creador de la factura
      private User user;

}
