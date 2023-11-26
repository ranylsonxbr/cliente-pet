package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ClienteDetalhadoResponse {
     UUID idCliente;
     String nomeCompleto;
     String cpf;
     String email;
     String celular;
     String telefone;
     Sexo sexo;
     Boolean aceitaTermos;
     LocalDateTime dataHoraDoCadastro;


    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
        this.telefone = cliente.getTelefone();
        this.sexo = cliente.getSexo();
        this.aceitaTermos = cliente.getAceitaTermos();
        this.dataHoraDoCadastro = cliente.getDataHoraDoCadastro();
    }
}
