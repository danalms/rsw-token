package com.rsw.token.service;

import com.rsw.token.domain.TokenRequest;
import com.rsw.token.domain.TokenResponse;

/**
 * Created by DAlms on 12/26/16.
 */
public interface TokenService {

    /**
     * Request a token from the authorization server using a password grant type
     * @param request - credentials to be submitted for the token grant
     * @return
     */
    TokenResponse requestToken(TokenRequest request);

}
