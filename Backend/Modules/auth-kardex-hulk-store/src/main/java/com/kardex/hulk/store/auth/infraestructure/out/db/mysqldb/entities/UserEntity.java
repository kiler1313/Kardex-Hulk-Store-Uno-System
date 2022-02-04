package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities;

import com.kardex.hulk.store.auth.commons.Constants;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
@Entity
@Table(name = "users", schema = "kardex_hulk_store")
public class UserEntity {

      @Id
      @GeneratedValue(strategy= GenerationType.IDENTITY)
      private Integer id;  //Id general de la solicitud
      @Column( name = "names")
      private String names; // Nombres
      @Column( name = "surnames")
      private String surnames; // Apellidos
      @Column( name = "user_name")
      @ColumnTransformer(
              read =  "AES_DECRYPT(user_name, '"+ Constants.ENCRYPTED_PASSWORD +"')",
              write = "AES_ENCRYPT(?, '"+ Constants.ENCRYPTED_PASSWORD +"')")
      private String userName; // NickName
      @Column( name = "password")
      @ColumnTransformer(
              read =  "AES_DECRYPT(password, '"+ Constants.ENCRYPTED_PASSWORD +"')",
              write = "AES_ENCRYPT(?, '"+ Constants.ENCRYPTED_PASSWORD +"')")
      private String password; // Contraseña
      @Column( name = "date_of_birth")
      private Date dateOfBirth; // Fecha de nacimiento
      @Column( name = "credit_card")
      @ColumnTransformer(
              read =  "AES_DECRYPT(credit_card, '"+ Constants.ENCRYPTED_PASSWORD +"')",
              write = "AES_ENCRYPT(?, '"+ Constants.ENCRYPTED_PASSWORD +"')")
      private String creditCard; // Numero de tarjeta de credito
      @Column(name = "type_credit_card")
      private String typeCreditCard; // Tipo de tarjeta de credito
      @Column( name = "address")
      private String address; // Dirección de facturación
      @Column( name = "id_roles")
      private Integer idRoles; // Roles
      @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
      private Set<TokenEntity> token;
}
