package Entrevista_JAVA.demo.service.servicePatrimonio;

import Entrevista_JAVA.demo.entity.EntityPatrimonio;
import Entrevista_JAVA.demo.repository.RepositoryPatrimonio;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RetirarBaixaPatrimonio {

    private final RepositoryPatrimonio repositoryPatrimonio;

    public RetirarBaixaPatrimonio(RepositoryPatrimonio repositoryPatrimonio) {
        this.repositoryPatrimonio = repositoryPatrimonio;
    }

    public void retirarBaixaPatrimonio(UUID id) {
        Optional<EntityPatrimonio> exist = repositoryPatrimonio.findById(id);

        if(exist.isEmpty()) {
            throw new RuntimeException("Patrimônio não existe");
        }

        EntityPatrimonio entityPatrimonio = exist.get();

        if(entityPatrimonio.getBaixa().equals(false)) {
            throw new RuntimeException("Patrimônio já está ativo");
        }

        entityPatrimonio.setBaixa(false);
        entityPatrimonio.setDataBaixa(null);
        entityPatrimonio.setMotivoBaixa(null);

        repositoryPatrimonio.save(entityPatrimonio);
    }
}
