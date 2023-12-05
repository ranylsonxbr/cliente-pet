package br.com.petz.clientepet.pet.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID idCliente,
                        @Valid @RequestBody PetRequest petRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PetClienteListResponse> getPetsDoClienteComId(@PathVariable UUID idCliente);

    @GetMapping(value = "{idPet}")
    @ResponseStatus(code = HttpStatus.OK)
    PetClienteDetalhaResponse getPetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);

    @DeleteMapping(value = "{idPet}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePet(@PathVariable UUID idCliente, @PathVariable UUID idPet);

    @PatchMapping(value = "{idPet}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchPet(@PathVariable UUID idCliente,@PathVariable UUID idPet,
                        @Valid @RequestBody PetAlteracaoRequest petRequest);
}
