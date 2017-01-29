package com.rsw.token.domain;

/**
 * Created by DAlms on 12/26/16.
 */
public class TokenResponse {
    private String authToken;
    private String refreshToken;
    private String scope;
    private Long expirationSeconds;

    public String getAuthToken() {
        return authToken;
    }

    public TokenResponse setAuthToken(String authToken) {
        this.authToken = authToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public TokenResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public TokenResponse setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public Long getExpirationSeconds() {
        return expirationSeconds;
    }

    public TokenResponse setExpirationSeconds(Long expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
        return this;
    }
}
