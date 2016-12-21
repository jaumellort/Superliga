package com.superliga.jllort.bencosuperleague.dto;

/**
 * Created by jllort on 12/21/2016.
 */

public class LoginResponse {

    private String exception;
    private boolean loginOK;

    public boolean isLoginOK() {
        return this.loginOK;
    }

    public void setLoginOK(boolean loginOK) {
        this.loginOK = loginOK;
    }

    public String getException() {
        return this.exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}

