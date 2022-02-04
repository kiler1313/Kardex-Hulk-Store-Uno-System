package com.kardex.hulk.store.product.infraestructure.out.authentication.request;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TokenDto {

      private String token; // Token del usuario
}
