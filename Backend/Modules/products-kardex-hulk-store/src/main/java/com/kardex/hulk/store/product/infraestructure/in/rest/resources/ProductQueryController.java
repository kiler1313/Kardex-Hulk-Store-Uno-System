package com.kardex.hulk.store.product.infraestructure.in.rest.resources;

import com.kardex.hulk.store.product.application.port.in.IProductQueryUseCase;
import com.kardex.hulk.store.product.commons.Constants;
import com.kardex.hulk.store.product.commons.UtilHelper;
import com.kardex.hulk.store.product.infraestructure.in.command.dto.ProductDto;
import com.kardex.hulk.store.product.infraestructure.in.mapper.IProductMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.product.path-product-query}")
@Tag(name="Queries Products", description = "Creation of a product record in Kardex of Hulk Store")
public class ProductQueryController {

    @Autowired
    IProductQueryUseCase productService;

    @Autowired
    IProductMapper requestMapper;

    @GetMapping( value = "${spring.application.services.methods.find.path}")
    @ApiOperation(value = "Query Products", notes = "Query of products activated for Kardex of Hulk Store")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Query product exist", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Query product not exist",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> queryProducts()
    {
        List<ProductDto> productsListDto = productService.findByStatus(Constants.ACTIVED).stream().map(resp -> requestMapper.toDto(resp)).collect(Collectors.toList());
        return UtilHelper.utilCreateResponseQueryProducts(productsListDto);
    }

    @GetMapping(value = "${spring.application.services.methods.find.path}/{code}")
    @ApiOperation(value = "Query Products query Code", notes = "Query of products by code for Kardex of Hulk Store")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Query product exist", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Query product not exist",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> queryByCode(@PathParam("code") String code){
        List<ProductDto> productsListDto = productService.findByCode(code).stream().map(resp -> requestMapper.toDto(resp)).collect(Collectors.toList());
        return UtilHelper.utilCreateResponseQueryProducts(productsListDto);
    }

    @GetMapping(value = "${spring.application.services.methods.find.path}/{status}")
    @ApiOperation(value = "Query Products By Status", notes = "Query of products by status for Kardex of Hulk Store")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Query product exist", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Query product not exist",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> queryByIsFreeSend(@PathParam("status") Boolean status)
    {
        List<ProductDto> productsListDto = productService.findByIsFreeSend(status).stream().map(resp -> requestMapper.toDto(resp)).collect(Collectors.toList());
        return UtilHelper.utilCreateResponseQueryProducts(productsListDto);
    }

    @GetMapping(value = "${spring.application.services.methods.find.path}/{code}/{status}")
    @ApiOperation(value = "Query Products By Code and Status", notes = "Query of products by code and status for Kardex of Hulk Store")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Query product exist", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Query product not exist",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> queryByCodeAndStatus(@PathParam("code") String code, @PathParam("status") Integer status)
    {
        List<ProductDto> listProductsDto = new ArrayList<>();
        ProductDto productsDto = requestMapper.toDto(productService.findByCodeAndStatus(code,status));
        if (!Objects.isNull(productsDto)){ listProductsDto.add(productsDto);}
        return UtilHelper.utilCreateResponseQueryProducts(listProductsDto);
    }

    @GetMapping(value = "${spring.application.services.methods.find.path}/{code}/{color}/{weight}/{height}")
    @ApiOperation(value = "Query Products By Code, Color, Weight and Height", notes = "Query of products by code, color, weight and height for Kardex of Hulk Store")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Query product exist", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Query product not exist",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> queryByCodeAndColorAndWeightAndHeight(@PathParam("code") String code,@PathParam("color") String color, @PathParam("weight") String weight, @PathParam("height") String height)
    {
        List<ProductDto> listProductsDto = new ArrayList<>();
        ProductDto productsDto = requestMapper.toDto(productService.findByCodeAndColorAndWeightAndHeight(code,color,weight,height));
        if (!Objects.isNull(productsDto)){ listProductsDto.add(productsDto);}
        return UtilHelper.utilCreateResponseQueryProducts(listProductsDto);
    }
}
