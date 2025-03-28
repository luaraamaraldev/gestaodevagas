package br.com.luaraamaral.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ManipuladorGlobalException {

    private MessageSource messageSource;

    public ManipuladorGlobalException(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroMensagemDto>> manipularExcecaoArgumentoMetodoInvalido(
            MethodArgumentNotValidException argumentosInvalidos) {

        List<ErroMensagemDto> listaMensagemErros = new ArrayList<>();

        for (FieldError campoComErro : argumentosInvalidos.getBindingResult().getFieldErrors()) {
            String msg = messageSource.getMessage(campoComErro, LocaleContextHolder.getLocale());
            ErroMensagemDto mensagemEcampoComErro = new ErroMensagemDto(msg, campoComErro.getField());
            listaMensagemErros.add(mensagemEcampoComErro);
        }

        return new ResponseEntity<>(listaMensagemErros, HttpStatus.BAD_REQUEST);

    }

}
