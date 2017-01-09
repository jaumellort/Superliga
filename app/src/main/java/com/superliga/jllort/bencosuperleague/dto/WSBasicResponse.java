package com.superliga.jllort.bencosuperleague.dto;

/**
 * Created by jllort on 12/21/2016.
 */

public class WSBasicResponse {

    private String exception;
    private boolean resultOk;

    public boolean isResultOk() {
        return this.resultOk;
    }

    public void setResultOk(boolean resultOk) {
        this.resultOk = resultOk;
    }

    public String getException() {
        return this.exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}

