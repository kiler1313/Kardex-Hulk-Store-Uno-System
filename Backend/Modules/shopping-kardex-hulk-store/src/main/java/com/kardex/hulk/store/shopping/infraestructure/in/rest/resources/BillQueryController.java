package com.kardex.hulk.store.shopping.infraestructure.in.rest.resources;

import com.kardex.hulk.store.shopping.application.port.in.IBillQueryUseCase;
import com.kardex.hulk.store.shopping.application.port.out.authentication.IAuthenticationPort;
import com.kardex.hulk.store.shopping.commons.Constants;
import com.kardex.hulk.store.shopping.commons.GeneralBasicResponse;
import com.kardex.hulk.store.shopping.commons.StatusMessages;
import com.kardex.hulk.store.shopping.commons.UtilHelper;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.BillDto;
import com.kardex.hulk.store.shopping.infraestructure.in.command.dto.UserDto;
import com.kardex.hulk.store.shopping.infraestructure.in.mapper.IBillMapper;
import com.kardex.hulk.store.shopping.infraestructure.in.mapper.IProductMapper;
import com.kardex.hulk.store.shopping.infraestructure.in.mapper.IUserMapper;
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

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RestController
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.shopping.path-shopping-query}")
@Tag(name="Queries Bills", description = "Creation of a product record in Kardex of Hulk Store")
public class BillQueryController {

    @Autowired
    IBillQueryUseCase billService;

    @Autowired
    IBillMapper iBillMapper;
    
    @Autowired
    IUserMapper iUserMapper;

    @Autowired
    IAuthenticationPort authenticationPort;

    @PostMapping( value = "${spring.application.services.methods.find.path}")
    @ApiOperation(value = "Query Bills", notes = "Query of billies for Kardex of Hulk Store to User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Query product exist", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Query product not exist",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> queryBillsOfUser(@RequestHeader("Auth-Token") String token, @RequestBody UserDto userDto)
    {
        boolean authenticationValidation = authenticationPort.confirmTokenAccess(token);
        ResponseEntity responseEntity = null;
        List<BillDto> billListDto = new ArrayList<>();
        if (authenticationValidation)
        {
            billListDto = billService.findByUserBills(iUserMapper.toDomain(userDto)).stream().map(resp -> iBillMapper.toDto(resp)).collect(Collectors.toList());
            if (billListDto.isEmpty())
            {
                responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_SEND_OK.getStatusCode(),
                        StatusMessages.HTTP_SEND_OK.getDescriptionCode(),
                        StatusMessages.HTTP_SEND_OK.getHttpStatusCode().value(), HttpStatus.OK, billListDto);
            }
            else
            {
                responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_STATUS_NOT_FOUND.getStatusCode(),
                        StatusMessages.HTTP_STATUS_NOT_FOUND.getDescriptionCode(),
                        StatusMessages.HTTP_STATUS_NOT_FOUND.getHttpStatusCode().value(), HttpStatus.BAD_REQUEST, null);
            }
        }else
        {
            responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_FORBBIDEN_RESOURCE.getStatusCode(),StatusMessages.HTTP_FORBBIDEN_RESOURCE.getDescriptionCode(), HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN, null);
        }
        return responseEntity;
    }
}
