package Entrevista_JAVA.demo.repository;

import Entrevista_JAVA.demo.entity.EntityEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryEmprestimo extends JpaRepository<EntityEmprestimo, UUID> {
}
