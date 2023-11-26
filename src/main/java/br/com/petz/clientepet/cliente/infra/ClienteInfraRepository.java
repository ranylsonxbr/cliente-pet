package br.com.petz.clientepet.cliente.infra;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finaliza] ClienteInfraRepository - salva");
        return cliente;
    }

    @Override
    public List<Cliente> buscaTodosCLientes() {
        log.info("[inicia] ClienteInfraRepository - buscaTodosCLientes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finaliza] ClienteInfraRepository - buscaTodosCLientes");
        return todosClientes;
    }

    @Override
    public Cliente buscaClienteAtravesId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - buscaClienteAtravesId");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        log.info("[finaliza] ClienteInfraRepository - buscaClienteAtravesId");
        return cliente;
    }
}
