package br.com.petz.clientepet.cliente.application;

import br.com.petz.clientepet.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteController - postCliente");
        ClienteResponse clienteCriado = clienteService.criacliente(clienteRequest);
        log.info("[finaliza] ClienteController - postCliente");

        return clienteCriado;
    }
}
