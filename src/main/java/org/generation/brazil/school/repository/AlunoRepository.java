package org.generation.brazil.school.repository;


import org.generation.brazil.school.domain.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, String> {

    List<AlunoEntity> findAllByActive(boolean active);

}
