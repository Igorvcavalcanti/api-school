package org.generation.brazil.school.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.generation.brazil.school.domain.dto.*;
import org.generation.brazil.school.domain.entity.AlunoEntity;
import org.generation.brazil.school.domain.vo.AlunoVO;
import org.generation.brazil.school.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/**
 * O Lombok @RequiredArgsConstructor é uma anotação que automatiza a geração de construtores
 * com argumentos para todas as variáveis de instância marcadas como 'final'.
 *
 * Vantagens de Uso:
 * 1. Redução de Código: Elimina a necessidade de escrever manualmente construtores com argumentos.
 * 2. Clareza e Legibilidade: Torna o código mais conciso e fácil de entender.
 * 3. Suporte a Classes Imutáveis: Útil para criar classes imutáveis, onde os campos não podem ser alterados após a inicialização.
 *
 * Exemplo Simples:
 *
 * {@code
 * import lombok.RequiredArgsConstructor;
 *
 * @RequiredArgsConstructor
 * public class Aluno {
 *     private final String nome;
 *     private final int idade;
 * }
 * }
 */
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    public List<EscolaDTO> all(boolean active) {
        final List<AlunoEntity> alunos = repository.findAllByActive(active);

        final List<EscolaDTO> dtos = new ArrayList<>();
        for (AlunoEntity entity : alunos) {
            AlunoDTO alunoDTO = new AlunoDTO(entity.getId(), entity.getName(), entity.getIdade());

            final List<SemestreDTO> semestresDTO = new ArrayList<>();
            semestresDTO.add(new SemestreDTO("1", entity.getNota1sem()));
            semestresDTO.add(new SemestreDTO("2", entity.getNota2sem()));

            SalaDTO salaDTO = new SalaDTO(entity.getProfessor(), entity.getNumSala());

            dtos.add(new EscolaDTO(alunoDTO, new NotaDTO(semestresDTO), salaDTO));
        }
        return dtos;

//        return alunos.stream().map(entity -> {
//            return new AlunoDTO(entity.getId(), entity.getName());
//        }).toList();
    }

    public EscolaDTO create(AlunoVO data) {
        final AlunoEntity entity = new AlunoEntity();

        entity.setName(data.name());
        entity.setIdade(Integer.parseInt(data.idade()));
        entity.setNota1sem(Double.parseDouble(data.nota1sem()));
        entity.setNota2sem(Double.parseDouble(data.nota2sem()));
        entity.setProfessor(data.professor());
        entity.setNumSala(data.numSala());
        entity.setActive(true);

        final AlunoEntity saved = repository.save(entity);

        AlunoDTO alunoDTO = new AlunoDTO(saved.getId(), saved.getName(), saved.getIdade());

        final List<SemestreDTO> semestresDTO = new ArrayList<>();
        semestresDTO.add(new SemestreDTO("1", entity.getNota1sem()));
        semestresDTO.add(new SemestreDTO("2", entity.getNota2sem()));

        SalaDTO salaDTO = new SalaDTO(entity.getProfessor(), entity.getNumSala());

        return new EscolaDTO(alunoDTO, new NotaDTO(semestresDTO), salaDTO);
    }


    @Transactional
    public EscolaDTO update(AlunoVO data) {
        final AlunoEntity found = repository.findById(data.id()).orElseThrow(() -> new RuntimeException("Registro não encontrado com o ID: " + data.id()));

        if (StringUtils.isNotBlank(data.name())) {
            found.setName(data.name());
        }

        if (StringUtils.isNotBlank(data.idade())) {
            found.setIdade(Integer.valueOf(data.idade()));
        }

        if (StringUtils.isNotBlank(data.professor())) {
            found.setProfessor(data.professor());
        }

        if (StringUtils.isNotBlank(data.nota1sem())) {
            found.setNota1sem(Double.valueOf(data.nota1sem()));
        }

        if (StringUtils.isNotBlank(data.nota2sem())) {
            found.setNota2sem(Double.valueOf(data.nota2sem()));
        }

        if (StringUtils.isNotBlank(data.numSala())) {
            found.setNumSala(data.numSala());
        }

        final AlunoEntity saved = repository.save(found);

        final AlunoDTO alunoDTO = new AlunoDTO(saved.getId(), saved.getName(), saved.getIdade());

        final List<SemestreDTO> semestresDTO = new ArrayList<>();
        semestresDTO.add(new SemestreDTO("1", saved.getNota1sem()));
        semestresDTO.add(new SemestreDTO("2", saved.getNota2sem()));

        final SalaDTO salaDTO = new SalaDTO(saved.getProfessor(), saved.getNumSala());

        return new EscolaDTO(alunoDTO, new NotaDTO(semestresDTO), salaDTO);
    }

    @Transactional
    public EscolaDTO delete(String id) {
        final AlunoEntity found = repository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado com o ID: " + id));

        found.setActive(false);

        repository.delete(found);

        final AlunoDTO alunoDTO = new AlunoDTO(found.getId(), found.getName(), found.getIdade());

        final List<SemestreDTO> semestresDTO = new ArrayList<>();
        semestresDTO.add(new SemestreDTO("1", found.getNota1sem()));
        semestresDTO.add(new SemestreDTO("2", found.getNota2sem()));

        final SalaDTO salaDTO = new SalaDTO(found.getProfessor(), found.getNumSala());

        return new EscolaDTO(alunoDTO, new NotaDTO(semestresDTO), salaDTO);
    }

}
