package com.MyProjects.E_Commerce.ExceptionHandler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class ErrorResponse
{
   private String message ;
    private int status ;
    private LocalDateTime timeStamp ;

    public ErrorResponse(String message, int status, LocalDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
