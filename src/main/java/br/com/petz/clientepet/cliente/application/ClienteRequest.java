package br.com.petz.clientepet.cliente.application;

import br.com.petz.clientepet.cliente.domain.Sexo;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class ClienteRequest {
    private String nomeCompleto;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String celular;
    private String telefone;
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    private String cpf;
    @NotNull
    private Boolean aceitaTermos;
}
