package br.com.luaraamaral.controller;

import br.com.luaraamaral.exceptions.UsuarioEncontradoException;
import br.com.luaraamaral.model.CandidatoEntity;
import br.com.luaraamaral.service.CandidatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Luara Amaral
 * @version 1.0
 */

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping("/cadastro")
    public ResponseEntity<Object> cadastrarCandidato(
            @RequestHeader("empresa") String empresa,
            @Valid @RequestBody CandidatoEntity candidatoEntity) {

        try {
            CandidatoEntity cadastrarUsuario = this.candidatoService.findByNomeOrUsuario(candidatoEntity);
            return ResponseEntity.ok(cadastrarUsuario);
        } catch (UsuarioEncontradoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
