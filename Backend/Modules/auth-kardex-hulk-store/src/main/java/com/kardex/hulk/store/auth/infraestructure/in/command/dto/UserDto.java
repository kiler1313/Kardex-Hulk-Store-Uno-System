package com.kardex.hulk.store.auth.infraestructure.in.command.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Entity level Data Base Kardex - Hulk Store
 */
@Data
public class UserDto {

      @JsonProperty
      @ApiModelProperty(value = "Id (opcional)", required = true)
      private Integer id;  //Id general de la solicitud

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Nombres del usuario", required = true)
      private String names; // Nombres

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Apellidos del usuario", required = true)
      private String surnames; // Apellidos

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Nickname del usuario", required = true)
      private String userName; // NickName

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Contraseña", required = true)
      private String password; // Contraseña

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Fecha de nacimiento", required = true)
      private Date dateOfBirth; // Fecha de nacimiento

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Numero de tarjeta de credito", required = true)
      private String creditCard; // Numero de tarjeta de credito

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Tipo de tarjeta de credito", required = true)
      private String typeCreditCard; // Tipo de tarjeta de credito

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Dirección de facturación", required = true)
      private String address; // Dirección de facturación

      @NotNull
      @NotBlank
      @JsonProperty
      @ApiModelProperty(value = "Roles", required = true)
      private Integer idRoles; // Roles
}
