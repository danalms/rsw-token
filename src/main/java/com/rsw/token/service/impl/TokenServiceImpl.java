package com.rsw.token.service.impl;

import com.rsw.token.domain.PasswordGrantResponse;
import com.rsw.token.domain.TokenRequest;
import com.rsw.token.domain.TokenResponse;
import com.rsw.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by DAlms on 12/26/16.
 */
@Service
public class TokenServiceImpl implements TokenService {

    private RestTemplate restTemplate;
    private String authUri;
    private String clientId;
    private String clientSecret;

    @Autowired
    public TokenServiceImpl(RestTemplate restTemplate,
                            @Value("${token.authTokenUri}") String authUri,
                            @Value("${token.authClientId}") String clientId,
                            @Value("${token.authClientSecret}") String clientSecret) {
        this.restTemplate = restTemplate;
        this.authUri = authUri;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    public TokenResponse requestToken(TokenRequest tokenRequest) {

        String credentials = String.format("%s:%s", clientId, clientSecret);
        String encodedCredentials = Base64.getEncoder()
                .encodeToString(credentials.getBytes(Charset.forName("UTF-8")));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add(HttpHeaders.ACCEPT, "*/*");

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("username", tokenRequest.getUserName());
        map.add("password", tokenRequest.getPassword());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<PasswordGrantResponse> responseEntity = restTemplate.exchange(authUri, HttpMethod.POST, request,
                PasswordGrantResponse.class);
        PasswordGrantResponse grantResponse = responseEntity.getBody();

        TokenResponse result = new TokenResponse();
        return result.setAuthToken(grantResponse.getAccess_token())
                    .setRefreshToken(grantResponse.getRefresh_token())
                    .setExpirationSeconds(grantResponse.getExpires_in())
                    .setScope(grantResponse.getScope());
    }

}
