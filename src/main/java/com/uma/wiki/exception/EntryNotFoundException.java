package com.uma.wiki.exception;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException (String message){
        super(message);
    }
}
