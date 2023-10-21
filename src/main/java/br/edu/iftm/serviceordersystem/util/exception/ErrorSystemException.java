package br.edu.iftm.serviceordersystem.util.exception;


public class ErrorSystemException extends Exception {
    
    public ErrorSystemException(String message) {
        super(message);
    }
    
    public ErrorSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
