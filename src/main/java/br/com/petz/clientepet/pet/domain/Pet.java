package br.com.petz.clientepet.pet.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(columnDefinition = "uuid", name = "idPet", updatable = false, unique = true, nullable = false)
        private UUID idPet;
        @NotBlank
        private String nomePet;
        @Enumerated(EnumType.STRING)
        private Porte porte;
        @Enumerated(EnumType.STRING)
        private TipoPet tipoPet;
        private String microchip;
        private String raca;
        @Enumerated(EnumType.STRING)
        private SexoPet sexoPet;
        private String pelagemCor;
        private LocalDate dataNascimento;
        private String rga;
        private Integer peso;

        private LocalDateTime dataHoraDoCadastro;
        private LocalDateTime dataHoraDaUltimaAlteracao;


}
