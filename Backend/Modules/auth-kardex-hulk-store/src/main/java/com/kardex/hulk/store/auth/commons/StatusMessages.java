package com.kardex.hulk.store.auth.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum StatusMessages {


    HTTP_OK(HttpStatus.OK, 200,"Petición recibida con exito"),
    HTTP_SEND_OK(HttpStatus.OK,200,"Envio de solicitud exitosa"),
    HTTP_STATUS_NOT_FOUND(HttpStatus.NOT_FOUND, 605,"No se obtuvieron resultados asociados a la busqueda"),
    HTTP_REQUEST_REPEATED(HttpStatus.BAD_REQUEST, 606,"La lista de productos y/o los datos de la facture vienen vacios"),
    HTTP_BAD_REQUEST_JSON_STRUCTURE(HttpStatus.BAD_REQUEST, 607,"El JSON ingresado tiene problemas de estructura"),
    HTTP_BAD_REQUEST_DATA_INTEGRITY_VIOLATION(HttpStatus.BAD_REQUEST, 609,"Se ha violado una regla de integridad de la base de datos."),
    HTTP_BAD_REQUEST_IDENTIFIER_GENERATION(HttpStatus.BAD_REQUEST, 608,"No se puede crear un objeto sin la llave primaria."),
    HTTP_BAD_REQUEST_EMPTY_DATASET(HttpStatus.BAD_REQUEST, 610,"No se encontraron resultados asociados al ID ingresado"),
    HTTP_BAD_REQUEST(HttpStatus.BAD_REQUEST,611,"Los parametros ingresados nos son validos"),
    HTTP_BAD_REQUEST_DATA_NO_FOUND(HttpStatus.BAD_REQUEST, 612,"La siguiente factura no pudo se procesada por el sistema, volver a intentarlo"),
    HTTP_BAD_REQUEST_NOT_QUANTITY(HttpStatus.BAD_REQUEST, 613,"Los siguientes productos, no pudieron ser comprados debido a que no cuentan con stock");

    @Getter private final HttpStatus httpStatusCode;
    @Getter private final int statusCode;
    @Getter private final String descriptionCode;

}