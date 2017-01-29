package com.rsw.token.domain;

/**
 * Created by DAlms on 12/26/16.
 */
public class PasswordGrantResponse {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Long expires_in;
    private String scope;
    private String jti;

    public String getAccess_token() {
        return access_token;
    }

    public PasswordGrantResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getToken_type() {
        return token_type;
    }

    public PasswordGrantResponse setToken_type(String token_type) {
        this.token_type = token_type;
        return this;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public PasswordGrantResponse setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
        return this;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public PasswordGrantResponse setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
        return this;
    }

    public String getScope() {
        return scope;
    }

    public PasswordGrantResponse setScope(String scope) {
        this.scope = scope;
        return this;
    }

    public String getJti() {
        return jti;
    }

    public PasswordGrantResponse setJti(String jti) {
        this.jti = jti;
        return this;
    }
}
