package br.com.mnz.hub.denuncias.service.exception;

public class InvalidJsonException extends RuntimeException {
    public InvalidJsonException(String msg) {
        super(msg);
    }
}
