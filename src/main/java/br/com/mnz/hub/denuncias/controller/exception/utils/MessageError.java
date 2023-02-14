package br.com.mnz.hub.denuncias.controller.exception.utils;

import lombok.Data;

@Data
public class MessageError {

    private String message;
    private String code;

    public MessageError(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
