package com.kardex.hulk.store.product.infraestructure.in.rest.resources;

import com.kardex.hulk.store.product.application.port.in.IProductCreateUseCase;
import com.kardex.hulk.store.product.application.port.out.authentication.IAuthenticationPort;
import com.kardex.hulk.store.product.commons.Constants;
import com.kardex.hulk.store.product.commons.GeneralBasicResponse;
import com.kardex.hulk.store.product.commons.StatusMessages;
import com.kardex.hulk.store.product.domain.models.Product;
import com.kardex.hulk.store.product.infraestructure.in.command.request.ProductRequest;
import com.kardex.hulk.store.product.infraestructure.in.mapper.IProductMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.product.path-product-create}")
@Tag(name="Create Product", description = "Creation of a product record for Kardex of Hulk Store")
public class ProductCreateController {

    @Autowired
    private IProductCreateUseCase productServiceCreate;

    @Autowired
    private IProductMapper requestMapper;

    @Autowired
    IAuthenticationPort authenticationPort;

    @PostMapping( value = "${spring.application.services.methods.create.path}")
    @ApiOperation(value = "Create Product", notes = "Create request for product for Kardex of Hulk Store")
    @Schema(name = "ProductRequest")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product Success", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> createProduct(@RequestHeader("Auth-Token") String token, @RequestBody ProductRequest productRequest)
    {

        boolean authenticationValidation = authenticationPort.confirmTokenAccess(token);
        ResponseEntity responseEntity = null;
        if (authenticationValidation)
        {
            if (!Objects.isNull(productRequest.getListProducts()))
            {
                Map<Boolean, List<Product>> productsCreate = productServiceCreate.createProduct(productRequest.getListProducts().stream().map(resp -> requestMapper.toDomain(resp)).collect(Collectors.toList()));
                if (productsCreate.containsKey(Boolean.TRUE))
                {
                    responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_OK.getStatusCode(),StatusMessages.HTTP_OK.getDescriptionCode(), HttpStatus.OK.value(), HttpStatus.OK, productsCreate.values().stream().collect(Collectors.toList()));
                }
                else
                {
                    responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getStatusCode(),StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, productsCreate.values().stream().collect(Collectors.toList()));
                }
            }
            else
            {
                responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_REQUEST_REPEATED.getStatusCode(),StatusMessages.HTTP_REQUEST_REPEATED.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, null);
            }
        }else
        {
            responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_FORBBIDEN_RESOURCE.getStatusCode(),StatusMessages.HTTP_FORBBIDEN_RESOURCE.getDescriptionCode(), HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN, null);
        }
        return responseEntity;
    }

}
