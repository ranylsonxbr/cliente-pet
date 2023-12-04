package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Repository
public class PetInfraRepository implements PetRepository {
    private final PetSpringDataJPARepository petSpringDataJPARepository;

    @Override
    public Pet salvaPet(Pet pet) {
        log.info("[inicia] PetInfraRepository - salvaPet");
        petSpringDataJPARepository.save(pet);
        log.info("[finaliza] PetInfraRepository - salvaPet");
        return pet;
    }

    @Override
    public List<Pet> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[inicia] PetInfraRepository - buscaPetsDoClienteComId");
        var pets = petSpringDataJPARepository.findByIdClienteTutor(idCliente);
        log.info("[finaliza] PetInfraRepository - buscaPetsDoClienteComId");
        return pets;
    }

    @Override
    public Pet buscaPet(UUID idPet) {
        log.info("[inicia] PetInfraRepository - buscaPet");
        var pet = petSpringDataJPARepository.findById(idPet)
                .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND,"Pet não encontrado para o idPet = " + idPet));
        log.info("[finaliza] PetInfraRepository - buscaPet");
        return pet;
    }
}
