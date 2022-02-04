package com.kardex.hulk.store.shopping.infraestructure.in.rest.resources;

import com.kardex.hulk.store.shopping.application.port.out.authentication.IAuthenticationPort;
import com.kardex.hulk.store.shopping.commons.GeneralBasicResponse;
import com.kardex.hulk.store.shopping.domain.models.Bill;
import com.kardex.hulk.store.shopping.domain.models.Product;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.BillDto;
import com.kardex.hulk.store.shopping.infraestructure.in.command.request.BillCreateRequest;
import com.kardex.hulk.store.shopping.infraestructure.in.mapper.IBillMapper;
import com.kardex.hulk.store.shopping.infraestructure.in.mapper.IProductMapper;
import com.kardex.hulk.store.shopping.application.port.in.IBillUpdateUseCase;
import com.kardex.hulk.store.shopping.commons.Constants;
import com.kardex.hulk.store.shopping.commons.StatusMessages;
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

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.shopping.path-shopping-update}")
@Tag(name="Update Bills", description = "Update bills for Kardex of Hulk Store")
public class BillUpdateController {

    @Autowired
    IBillUpdateUseCase billServiceUpdate;

    @Autowired
    IBillMapper iBillMapper;

    @Autowired
    IAuthenticationPort authenticationPort;

    @PostMapping( value = "${spring.application.services.methods.create.path}")
    @ApiOperation(value = "Update BillDto", notes = "Update one bill for confirm send or pickup in the store for Kardex of Hulk Store")
    @Schema(name = "BillCreateRequest")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "BillDto Update Success", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> updateProducts(@RequestHeader("Auth-Token") String token, @RequestBody @NotNull BillDto billDto)
    {
        boolean authenticationValidation = authenticationPort.confirmTokenAccess(token);
        ResponseEntity responseEntity = null;
        if (authenticationValidation)
        {
            if (!Objects.isNull(billDto))
            {
                Map<Boolean, Bill> billUpdate = billServiceUpdate.updateBill(iBillMapper.toDomain(billDto));
                if (billUpdate.containsKey(Boolean.TRUE))
                {
                    responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_OK.getStatusCode(),StatusMessages.HTTP_OK.getDescriptionCode(), HttpStatus.OK.value(), HttpStatus.OK, billUpdate.values().stream().collect(Collectors.toList()));
                }
                else
                {
                    responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getStatusCode(),StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, billUpdate.values().stream().collect(Collectors.toList()));
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
