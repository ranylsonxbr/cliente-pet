package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.cliente.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.*;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {

    private final ClienteService clienteService;
    private final PetRepository petRepository;

    @Override
    public PetResponse criaPet(UUID idCliente,@Valid PetRequest petRequest) {
        log.info("[inicia] PetApplicationService - criaPet");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente,petRequest));
        log.info("[finaliza] PetApplicationService - criaPet");
        return new PetResponse(pet.getIdPet());
    }

    @Override
    public List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[inicia] PetApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        List<Pet> petsDoCliente = petRepository.buscaPetsDoClienteComId(idCliente);
        log.info("[finaliza] PetApplicationService - buscaPetsDoClienteComId");
        return PetClienteListResponse.converte(petsDoCliente);
    }

    @Override
    public PetClienteDetalhaResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[inicia] PetApplicationService - buscaPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPet(idPet);
        log.info("[finaliza] PetApplicationService - buscaPetDoClienteComId");
        return new PetClienteDetalhaResponse(pet);
    }

    @Override
    public void deletaPetDoClienteComId(UUID idCliente, UUID idPet) {
        log.info("[inicia] PetApplicationService - deletaPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPet(idPet);
        petRepository.deletaPet(pet);
        log.info("[finaliza] PetApplicationService - deletaPetDoClienteComId");
    }

    @Override
    public void alteraPetDoClienteComId(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest) {
        log.info("[inicia] PetApplicationService - alteraPetDoClienteComId");
        clienteService.buscaClienteAtravesId(idCliente);
        Pet pet = petRepository.buscaPet(idPet);
        pet.altera(petAlteracaoRequest);
        petRepository.salvaPet(pet);
        log.info("[finaliza] PetApplicationService - alteraPetDoClienteComId");

    }
}
