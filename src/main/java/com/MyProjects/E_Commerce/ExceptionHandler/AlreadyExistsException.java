package com.MyProjects.E_Commerce.ExceptionHandler;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message)
    {
        super(message);
    }
}
