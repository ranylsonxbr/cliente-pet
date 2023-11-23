package br.com.petz.clientepet.cliente.service;

import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteResponse;

public interface ClienteService {

    ClienteResponse criaCliente(ClienteRequest clienteRequest);
}
