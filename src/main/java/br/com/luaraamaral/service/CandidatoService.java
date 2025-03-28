package br.com.luaraamaral.service;

import br.com.luaraamaral.exceptions.UsuarioEncontradoException;
import br.com.luaraamaral.model.CandidatoEntity;
import br.com.luaraamaral.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public CandidatoEntity findByNomeOrUsuario(CandidatoEntity candidatoEntity) {
        Optional<CandidatoEntity> byNomeAndId = this.candidatoRepository.findByNomeOrUsuario(
                candidatoEntity.getNome(), candidatoEntity.getUsuario());
        if (byNomeAndId.isPresent()) {
            throw new UsuarioEncontradoException();

        } else return candidatoRepository.save(candidatoEntity);

    }


}
