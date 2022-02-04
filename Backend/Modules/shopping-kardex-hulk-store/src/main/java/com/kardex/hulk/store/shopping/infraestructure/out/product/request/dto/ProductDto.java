package com.kardex.hulk.store.shopping.infraestructure.out.product.request.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto
{

    private Integer id; //Id general de la solicitud
    private String code; // Codigo del producto
    private String name; // Nombre del producto
    private Integer stock; // Numero de stock
    private String value; // Valor del producto
    private Integer status; // Estado del producto
    private String color;  // Opciones adicionales color
    private String weight;  // Opciones adicionales peso
    private String height;  // Opciones adicionales altura
    private Boolean isFreeSend; // Tiene envio gratis?
    private String img; // Imagen del producto
    private Integer quantity ; // Cantidad vendida
}
