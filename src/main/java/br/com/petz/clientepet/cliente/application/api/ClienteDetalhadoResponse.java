package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;

import java.time.LocalDate;
import java.util.UUID;

public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String celular;
    private String telefone;
    private Sexo sexo;
    private Boolean aceitaTermos;
    private LocalDate dataHoraDoCadastro;


    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.celular = cliente.getCelular();
        this.telefone = cliente.getTelefone();
        this.sexo = cliente.getSexo();
        this.aceitaTermos = cliente.getAceitaTermos();
        this.dataHoraDoCadastro = cliente.getDataNascimento();
    }
}
