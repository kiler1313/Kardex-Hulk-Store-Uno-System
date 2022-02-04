package com.kardex.hulk.store.auth.infraestructure.in.rest.resources;

import com.kardex.hulk.store.auth.application.port.in.IUserAuthenticationUseCase;
import com.kardex.hulk.store.auth.commons.Constants;
import com.kardex.hulk.store.auth.commons.UtilHelper;
import com.kardex.hulk.store.auth.infraestructure.in.command.dto.TokenDto;
import com.kardex.hulk.store.auth.infraestructure.in.command.dto.UserDto;
import com.kardex.hulk.store.auth.infraestructure.in.mapper.ITokenMapper;
import com.kardex.hulk.store.auth.infraestructure.in.mapper.IUserMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping(Constants.PROJECT_PATH + "${spring.application.services.names.authentication.path-authentication-query}")
@Tag(name="User Authentication", description = "User authentication in Kardex of Hulk Store")
public class UserAuthenticationController {

    @Autowired
    IUserAuthenticationUseCase authenticationUseCase;
    
    @Autowired
    IUserMapper iUserMapper;

    @Autowired
    ITokenMapper iTokenMapper;

    @PostMapping( value = "${spring.application.services.methods.find.path}")
    @ApiOperation(value = "Authentication User", notes = "Authentication user for system Kardex of Hulk Store")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User Exist", content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))}),
            @ApiResponse(responseCode = "400", description = "User No Exist",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = ResponseEntity.class))})
    })
    public ResponseEntity<Object> authenticationUser(@RequestBody UserDto userDto)
    {
        TokenDto tokenDto = iTokenMapper.toDto(authenticationUseCase.authenticationUser(iUserMapper.toDomain(userDto)));
        return UtilHelper.utilCreateResponseQueryProducts(tokenDto.getToken() != null && tokenDto.getToken() != "" ? tokenDto : null);
    }
}
