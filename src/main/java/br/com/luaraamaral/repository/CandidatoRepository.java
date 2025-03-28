package br.com.luaraamaral.repository;

import br.com.luaraamaral.model.CandidatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidatoRepository extends JpaRepository<CandidatoEntity, UUID> {

    Optional<CandidatoEntity> findByNomeOrUsuario(String nome, String usuario);

}
