package Entrevista_JAVA.demo.service.serviceEstabelecimento;

import Entrevista_JAVA.demo.entity.EntityEstabelecimento;
import Entrevista_JAVA.demo.repository.RepositoryEstabelecimento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTodosEstabelecimentos {

    private final RepositoryEstabelecimento repositoryEstabelecimento;

    public ListarTodosEstabelecimentos(RepositoryEstabelecimento repositoryEstabelecimento) {
        this.repositoryEstabelecimento = repositoryEstabelecimento;
    }

    public List<EntityEstabelecimento> listarTodosEstabelecimentos() {
        return repositoryEstabelecimento.findAll();
    }
}
