package br.com.petz.clientepet.pet.application.api;

import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Value;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class PetAlteracaoRequest {
    @NotBlank
    private String nomePet;
    private Porte porte;
    @NotNull
    private TipoPet tipoPet;
    private String microchip;
    @NotBlank
    private String raca;
    @Enumerated(EnumType.STRING)
    @NotNull
    private SexoPet sexoPet;
    private String pelagemCor;
    @NotNull
    private LocalDate dataNascimento;
    private String rga;
    private Integer peso;

}
