package com.MyProjects.E_Commerce.ExceptionHandler;

public class NotFoundException extends  RuntimeException
{
    public NotFoundException(String message)
    {
        super(message);
    }
}
