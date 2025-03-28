package br.com.luaraamaral.exceptions;

public class UsuarioEncontradoException extends RuntimeException {

    public UsuarioEncontradoException() {
        super("Usuário já existe na base de dados!");
    }

}
