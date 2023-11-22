package br.com.petz.clientepet.cliente.service;

import br.com.petz.clientepet.cliente.application.ClienteRequest;
import br.com.petz.clientepet.cliente.application.ClienteResponse;

public interface ClienteService {

    ClienteResponse criaCliente(ClienteRequest clienteRequest);
}
