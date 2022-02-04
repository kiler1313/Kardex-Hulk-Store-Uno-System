package com.kardex.hulk.store.auth.infraestructure.in.rest.resources;

import com.kardex.hulk.store.auth.commons.GeneralBasicResponse;
import com.kardex.hulk.store.auth.application.port.in.IUserTokenConfirmUseCase;
import com.kardex.hulk.store.auth.commons.Constants;
import com.kardex.hulk.store.auth.commons.StatusMessages;
import com.kardex.hulk.store.auth.infraestructure.in.command.dto.TokenDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.authentication.path-authentication-update}")
@Tag(name="Token Confirm", description = "Token confirm for Kardex of Hulk Store")
public class UserTokenConfirmController {

    @Autowired
    IUserTokenConfirmUseCase tokenConfirmServices;


    @PostMapping( value = "${spring.application.services.methods.token.path}")
    @ApiOperation(value = "Token Authentication Confirm", notes = "Token confirm of the user in system Kardex")
    @Schema(name = "TokenDto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Token Confirm Success", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> confirmAuthentication(@RequestBody @NotNull TokenDto tokenDto)
    {
        ResponseEntity responseEntity = null;
        if (!Objects.isNull(tokenDto) && tokenDto.getToken() != null && tokenDto.getToken() != "")
        {
            Boolean tokenConfirm = tokenConfirmServices.tokenConfirm(tokenDto.getToken());
            if (tokenConfirm)
            {
                responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_OK.getStatusCode(),StatusMessages.HTTP_OK.getDescriptionCode(), HttpStatus.OK.value(), HttpStatus.OK, tokenDto);
            }
            else
            {
                responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getStatusCode(),StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,tokenDto);
            }
        }
        else
        {
            responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_REQUEST_REPEATED.getStatusCode(),StatusMessages.HTTP_REQUEST_REPEATED.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, null);
        }
        return responseEntity;
    }

}
