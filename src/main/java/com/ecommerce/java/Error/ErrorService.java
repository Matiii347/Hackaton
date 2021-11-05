package com.ecommerce.java.Error;

public class ErrorService extends Exception {

    private static final long serialVersionUID = 1L;

    public ErrorService(String msn) {
        super(msn);

    }
}
