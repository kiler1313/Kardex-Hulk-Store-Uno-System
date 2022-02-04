package com.kardex.hulk.store.shopping.infraestructure.in.rest.resources;

import com.kardex.hulk.store.shopping.application.port.in.IBillCreateUseCase;
import com.kardex.hulk.store.shopping.application.port.out.authentication.IAuthenticationPort;
import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.infraestructure.in.command.request.BillCreateRequest;
import com.kardex.hulk.store.shopping.commons.Constants;
import com.kardex.hulk.store.shopping.commons.GeneralBasicResponse;
import com.kardex.hulk.store.shopping.commons.StatusMessages;
import com.kardex.hulk.store.shopping.infraestructure.in.mapper.IBillMapper;
import com.kardex.hulk.store.shopping.infraestructure.in.mapper.IProductMapper;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.shopping.path-bill-create}")
@Tag(name="Create BillDto", description = "Creation of a bill record for Kardex of Hulk Store")
public class BillCreateController {

    @Autowired
    private IBillCreateUseCase billServiceCreate;

    @Autowired
    private IBillMapper billMapper;

    @Autowired
    private IProductMapper productMapper;

    @Autowired
    IAuthenticationPort authenticationPort;

    @PostMapping( value = "${spring.application.services.methods.create.path}")
    @ApiOperation(value = "Create BillDto", notes = "Create request for bill for Kardex of Hulk Store")
    @Schema(name = "BillCreateRequest")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BillDto Success", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> createBill(@RequestHeader("Auth-Token") String token, @RequestBody BillCreateRequest billCreateRequest)
    {

        boolean authenticationValidation = authenticationPort.confirmTokenAccess(token);
        ResponseEntity responseEntity = null;
        if (authenticationValidation)
        {
            if (!Objects.isNull(billCreateRequest.getListProducts()) && !Objects.isNull(billCreateRequest.getBillDto()))
            {
                Boolean billsCreate = billServiceCreate.createBill(billCreateRequest.getListProducts().stream().map(resp -> productMapper.toDomain(resp)).collect(Collectors.toList()), billMapper.toDomain(billCreateRequest.getBillDto()));
                if (billsCreate)
                {
                    responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_OK.getStatusCode(),StatusMessages.HTTP_OK.getDescriptionCode(), HttpStatus.OK.value(), HttpStatus.OK, billCreateRequest.getBillDto());
                }
                else
                {
                    responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getStatusCode(),StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, billCreateRequest.getBillDto());
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
