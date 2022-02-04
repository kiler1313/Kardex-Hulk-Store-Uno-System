package com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities;

import com.kardex.hulk.store.auth.commons.Constants;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
@Entity
@Table(name = "tokens", schema = "kardex_hulk_store")
public class TokenEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;  //Id general de la solicitud
      @ManyToOne
      @JoinColumn( name = "id_user")
      private UserEntity user; // Usuario a quien le pertenece el token
      @Column( name = "token")
      @ColumnTransformer(
              read =  "AES_DECRYPT(token, '"+ Constants.ENCRYPTED_PASSWORD +"')",
              write = "AES_ENCRYPT(?, '"+ Constants.ENCRYPTED_PASSWORD +"')")
      private String token; // Token del usuario
}
