package br.com.luaraamaral.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String nome;
    @NotBlank
    @Pattern(regexp = "^[a-z]{1,15}$",
            message = "Aceito somente letras de A-Z, contendo 1 a 15 caracteres, sem espaços em branco! Exemplo: exemplo")
    private String usuario;
    @Email(message = "Requer um email valido! Exemplo: exemplo@exemplo.com.br")
    private String email;
    @NotBlank
    @Length(min = 10, max = 20)
    private String senha;
    @Length(min = 10, max = 50)
    private String descricao;
    private String curriculo;
    @CreationTimestamp
    private LocalDateTime criacao;

}
