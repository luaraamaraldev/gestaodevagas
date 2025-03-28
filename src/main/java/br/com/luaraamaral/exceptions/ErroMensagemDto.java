package br.com.luaraamaral.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroMensagemDto {

    private String mensagem;
    private String campo;
}
