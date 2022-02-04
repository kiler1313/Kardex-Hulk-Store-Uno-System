package com.kardex.hulk.store.auth.infraestructure.in.rest.resources;

import com.kardex.hulk.store.auth.application.port.in.IUserCreateUseCase;
import com.kardex.hulk.store.auth.commons.Constants;
import com.kardex.hulk.store.auth.commons.GeneralBasicResponse;
import com.kardex.hulk.store.auth.commons.StatusMessages;
import com.kardex.hulk.store.auth.domain.models.Token;
import com.kardex.hulk.store.auth.infraestructure.in.command.dto.UserDto;
import com.kardex.hulk.store.auth.infraestructure.in.mapper.IUserMapper;
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

import java.util.Objects;

@RestController
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.authentication.path-user-create}")
@Tag(name="Create User", description = "Creation user for Kardex of Hulk Store")
public class UserCreateController {

    @Autowired
    private IUserCreateUseCase userServiceCreate;

    @Autowired
    private IUserMapper userMapper;

    @PostMapping( value = "${spring.application.services.methods.create.path}")
    @ApiOperation(value = "Create User", notes = "Create user for system Kardex of Hulk Store")
    @Schema(name = "UserDto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Token access and create user Success", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad request",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> createBill(@RequestBody UserDto userDto)
    {
        ResponseEntity responseEntity = null;
        if (!Objects.isNull(userDto))
        {
            Token tokenCreate = userServiceCreate.createUser(userMapper.toDomain(userDto));
            if (tokenCreate != null )
            {
                responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_OK.getStatusCode(),StatusMessages.HTTP_OK.getDescriptionCode(), HttpStatus.OK.value(), HttpStatus.OK, tokenCreate);
            }
            else
            {
                responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getStatusCode(),StatusMessages.HTTP_BAD_REQUEST_DATA_NO_FOUND.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, tokenCreate);
            }
        }
        else
        {
            responseEntity = new GeneralBasicResponse().buildResponseEntity(StatusMessages.HTTP_REQUEST_REPEATED.getStatusCode(),StatusMessages.HTTP_REQUEST_REPEATED.getDescriptionCode(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, null);
        }
        return responseEntity;
    }

}
