package com.kardex.hulk.store.auth.infraestructure.in.command.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kardex.hulk.store.auth.infraestructure.out.db.mysqldb.entities.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Entity level Data Kardex - Hulk Store
 */
@Data
@NoArgsConstructor
@ApiModel(value = "TokenDto", description = "Solicitud para operaciones del token")
public class TokenDto {

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Informaciòn de la factura", required = true)
      private String token; // Token del usuario
}
