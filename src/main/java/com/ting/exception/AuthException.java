package com.ting.exception;

/**
 * Created by tingsky on 16/1/13.
 */
public class AuthException extends RuntimeException{
    public AuthException(){
        super();
    }

    public AuthException(String message, Throwable cause){
        super(message, cause);
    }
}
