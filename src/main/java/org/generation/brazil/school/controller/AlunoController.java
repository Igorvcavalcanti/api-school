package org.generation.brazil.school.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.generation.brazil.school.domain.dto.EscolaDTO;
import org.generation.brazil.school.domain.vo.AlunoVO;
import org.generation.brazil.school.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
@Tag(name = "Alunos", description = "Conjunto de endpoints para gerenciar os dados relacionados a aluno.")
public class AlunoController {

    private final AlunoService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EscolaDTO> all() {
        return service.all(true);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cria um novo aluno.", responses = {
            @ApiResponse(responseCode = "201", description = "Aluno criada com sucesso!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EscolaDTO.class))), //
    })
    public EscolaDTO create(@RequestBody @Valid AlunoVO data) {
        return service.create(data);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualiza um aluno existente.", responses = {
            @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso!", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EscolaDTO.class))), //
    })
    public EscolaDTO update(@RequestBody @Valid AlunoVO data) {
        EscolaDTO dto = service.update(data);

        System.out.println(dto);

        return dto;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Exclui um aluno existente.", responses = { //
            @ApiResponse(responseCode = "204", description = "Pessoa excluída com sucesso!", content = @Content), //
    })
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
