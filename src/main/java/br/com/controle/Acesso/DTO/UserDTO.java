package br.com.controle.Acesso.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @Column(unique = true) @NotBlank String name,
        @NotBlank @Column(unique = true) @Email String email,
        @NotBlank String password) {

}
