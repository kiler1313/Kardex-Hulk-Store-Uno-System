package com.kardex.hulk.store.shopping.infraestructure.out.product.request.request;

import com.fasterxml.jackson.annotation.JsonProperty;;
import com.kardex.hulk.store.shopping.infraestructure.out.product.request.dto.ProductDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@ApiModel(value = "ProductRequest", description = "Solicitud de operaciòn con los productos de Hulk Store")
public class ProductRequest  {

    @NotNull
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value = "Lista de productos", required = true)
    private List<ProductDto> listProducts; // Lista de productos para los controladores correspondientes

}
