package org.generation.brazil.school.domain.vo;

import jakarta.validation.constraints.NotNull;

public record AlunoVO(

        String id,

        @NotNull
        String name,

        @NotNull
        String idade,

        String nota1sem,

        String nota2sem,

        @NotNull
        String professor,

        @NotNull
        String numSala

) {
}


