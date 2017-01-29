package com.rsw.token.domain;

/**
 * Created by DAlms on 12/26/16.
 * Token request user credentials for password grant type
 */
public class TokenRequest {
    private String userName;
    private String password;

    public TokenRequest() {

    }

    public TokenRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public TokenRequest setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public TokenRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
