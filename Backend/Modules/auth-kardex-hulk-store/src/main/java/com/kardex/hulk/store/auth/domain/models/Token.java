package com.kardex.hulk.store.auth.domain.models;

import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
public class Token {

      private User user; // Usuario a quien le pertenece el token
      private String token; // Token del usuario
}
