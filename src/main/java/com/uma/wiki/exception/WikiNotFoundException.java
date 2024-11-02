package com.uma.wiki.exception;

public class WikiNotFoundException extends RuntimeException {
    public WikiNotFoundException (String message){
        super(message);
    }
}
