package br.edu.iftm.serviceordersystem.util.exception;


public class ErrorBusinessException extends Exception {

    public ErrorBusinessException(String message) {
        super(message);
    }

    public ErrorBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}