package Entrevista_JAVA.demo.service.servicePatrimonio;

import Entrevista_JAVA.demo.entity.EntityPatrimonio;
import Entrevista_JAVA.demo.model.BaixaRequest;
import Entrevista_JAVA.demo.repository.RepositoryPatrimonio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DarBaixaPatrimonio {

    private final RepositoryPatrimonio repositoryPatrimonio;

    public DarBaixaPatrimonio(RepositoryPatrimonio repositoryPatrimonio) {
        this.repositoryPatrimonio = repositoryPatrimonio;
    }

    public void darBaixaPatrimonio(BaixaRequest baixaRequest) {

        Optional<EntityPatrimonio> exist =repositoryPatrimonio.findById(baixaRequest.getId());

        if(exist.isEmpty()) {
            throw new RuntimeException("Patrimonio inexistente");
        }

        EntityPatrimonio entity = exist.get();

        entity.setBaixa(true);
        entity.setMotivoBaixa(baixaRequest.getMotivoBaixa());
        entity.setDataBaixa(baixaRequest.getLocalDate());

        repositoryPatrimonio.save(entity);
    }
}
