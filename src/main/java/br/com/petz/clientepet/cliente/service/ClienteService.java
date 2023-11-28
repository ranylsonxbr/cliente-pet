package br.com.petz.clientepet.cliente.service;

import br.com.petz.clientepet.cliente.application.api.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface ClienteService {

    ClienteResponse criaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();

    ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente);

    void deletaClienteAtravesId(UUID idCliente);

    void patchAlteraCliente(UUID idCliente,@Valid ClienteAlteracaoRequest clienteAlteracaoRequest);
}
