package com.rsw.token.controller;

import com.rsw.token.domain.TokenRequest;
import com.rsw.token.domain.TokenResponse;
import com.rsw.token.service.TokenService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DAlms on 12/26/16.
 *
 * Token service endpoint - utility service to create OAuth2 tokens
 *
 */
@RestController
@RequestMapping(value = "/util/token")
public class TokenController {

    private static final Logger LOG = LoggerFactory.getLogger(TokenController.class);

    private TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "getToken")
    public ResponseEntity<TokenResponse> getToken(@RequestBody TokenRequest tokenRequest) {
        TokenResponse response = tokenService.requestToken(tokenRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
