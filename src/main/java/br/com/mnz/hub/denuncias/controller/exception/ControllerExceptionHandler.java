package br.com.mnz.hub.denuncias.controller.exception;

import br.com.mnz.hub.denuncias.controller.exception.utils.MessageError;
import br.com.mnz.hub.denuncias.controller.exception.utils.StandardError;
import br.com.mnz.hub.denuncias.controller.exception.utils.ValidationError;
import br.com.mnz.hub.denuncias.service.exception.EnderecoNotFoundException;
import br.com.mnz.hub.denuncias.service.exception.InvalidJsonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErrors(MethodArgumentNotValidException ex,
                                                          HttpServletRequest request) {

        ValidationError errors = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation error", "Field validation error", request.getRequestURI());

        for (FieldError x : ex.getBindingResult().getFieldErrors()) {
            errors.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errors);
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<MessageError> enderecoNotFoundException(EnderecoNotFoundException ex,
                                                                   HttpServletRequest request) {

        MessageError error = new MessageError(ex.getMessage(), "02");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidJsonException.class)
    public ResponseEntity<MessageError> invalidJsonException(InvalidJsonException ex,
                                                              HttpServletRequest request) {

        MessageError error = new MessageError(ex.getMessage(), "01");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
