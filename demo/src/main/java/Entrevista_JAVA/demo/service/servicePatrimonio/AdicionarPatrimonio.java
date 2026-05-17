package Entrevista_JAVA.demo.service.servicePatrimonio;

import Entrevista_JAVA.demo.entity.EntityEstabelecimento;
import Entrevista_JAVA.demo.entity.EntityPatrimonio;
import Entrevista_JAVA.demo.model.AddPatrimonioRequest;
import Entrevista_JAVA.demo.repository.RepositoryEstabelecimento;
import Entrevista_JAVA.demo.repository.RepositoryPatrimonio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionarPatrimonio {

    private final RepositoryEstabelecimento repositoryEstabelecimento;

    private final RepositoryPatrimonio repositoryPatrimonio;

    public AdicionarPatrimonio(RepositoryEstabelecimento repositoryEstabelecimento,RepositoryPatrimonio repositoryPatrimonio) {
        this.repositoryEstabelecimento = repositoryEstabelecimento;
        this.repositoryPatrimonio = repositoryPatrimonio;
    }


    public void addPatrimonio(AddPatrimonioRequest request) {
        Optional<EntityEstabelecimento> exist = repositoryEstabelecimento.findByCnpj(request.getCnpj());

        if(exist.isEmpty()) {
            throw new RuntimeException("Estabelecimento não existe, impossível add patrimonio");
        }

        EntityEstabelecimento entityEstabelecimento = exist.get();

        EntityPatrimonio entityPatrimonio = new EntityPatrimonio(request.getNome(),
                request.getCodigo(),
                request.getEnumTipo(),request.getDataEntrada(),
                entityEstabelecimento);

        repositoryPatrimonio.save(entityPatrimonio);
    }

}
