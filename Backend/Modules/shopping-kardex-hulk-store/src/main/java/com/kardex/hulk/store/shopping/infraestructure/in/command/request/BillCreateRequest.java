package com.kardex.hulk.store.shopping.infraestructure.in.command.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.BillDto;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.ProductDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@ApiModel(value = "BillCreateRequest", description = "Solicitud de operaciòn de venta de productos de Hulk Store")
public class BillCreateRequest {

    @NotNull
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value = "Informaciòn de la factura", required = true)
    private BillDto billDto; // Lista de productos para los controladores correspondientes

    @NotNull
    @NotBlank
    @JsonProperty
    @ApiModelProperty(value = "Lista de productos vendidos", required = true)
    private List<ProductDto> listProducts; // Lista de productos para los controladores correspondientes

}
