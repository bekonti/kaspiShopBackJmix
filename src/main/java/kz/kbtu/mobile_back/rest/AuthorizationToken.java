package kz.kbtu.mobile_back.rest;

import java.io.Serializable;

public class AuthorizationToken implements Serializable {
    private String authorizationToken;

    public AuthorizationToken() {
    }

    public AuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }
}
