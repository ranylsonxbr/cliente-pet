package br.com.petz.clientepet.cliente.infra;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPA;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        clienteSpringDataJPA.save(cliente);
        log.info("[finaliza] ClienteInfraRepository - salva");
        return cliente;
    }
}
