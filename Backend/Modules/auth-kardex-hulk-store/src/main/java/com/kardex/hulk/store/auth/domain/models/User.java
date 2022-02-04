package com.kardex.hulk.store.auth.domain.models;

import com.kardex.hulk.store.auth.commons.Constants;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.TokenEntity;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
public class User {

      private Integer id;  //Id general de la solicitud
      private String names; // Nombres
      private String surnames; // Apellidos
      private String userName; // NickName
      private String password; // Contraseña
      private Date dateOfBirth; // Fecha de nacimiento
      private String creditCard; // Numero de tarjeta de credito
      private String typeCreditCard; // Tipo de tarjeta de credito
      private String address; // Dirección de facturación
      private Integer idRoles; // Roles
}
