package Entrevista_JAVA.demo.service.serviceEstabelecimento;

import Entrevista_JAVA.demo.entity.EntityEstabelecimento;
import Entrevista_JAVA.demo.model.CadastrarEstabelecimentoRequest;
import Entrevista_JAVA.demo.repository.RepositoryEstabelecimento;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastrarEstabelecimento {

    private final RepositoryEstabelecimento repositoryEstabelecimento;

    public CadastrarEstabelecimento(RepositoryEstabelecimento repositoryEstabelecimento) {
        this.repositoryEstabelecimento = repositoryEstabelecimento;
    }

    public void cadastrarEstabelecimento(CadastrarEstabelecimentoRequest estabelecimentoRequest) {
        Optional<EntityEstabelecimento> exist = repositoryEstabelecimento.findByCnpj(estabelecimentoRequest.getCnpj());

        if(exist.isPresent()) {
            throw new RuntimeException("Estabelecimento já existe");
        }

        EntityEstabelecimento estabelecimento = new EntityEstabelecimento(estabelecimentoRequest.getNome(),
                estabelecimentoRequest.getCnpj(),
                estabelecimentoRequest.getTipoEstabelecimento(),
                estabelecimentoRequest.getTempoMaximoEmprestimo());

        repositoryEstabelecimento.save(estabelecimento);
    }
}
