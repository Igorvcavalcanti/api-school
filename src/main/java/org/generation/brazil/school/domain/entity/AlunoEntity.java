package org.generation.brazil.school.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(name = "nome")
    private String name;

    @NotNull
    @Column(name = "idade")
    private Integer idade;

    @Column(name = "nota1_sem")
    private Double nota1sem;

    @Column(name = "nota2_sem")
    private Double nota2sem;

    @Column(name = "professor")
    private String professor;

    @Column(name = "num_sala")
    private String numSala;

    @Column(name = "ativo")
    private boolean active;

}
