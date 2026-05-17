package Entrevista_JAVA.demo.service.serviceEmprestimo;

import Entrevista_JAVA.demo.entity.EntityEmprestimo;
import Entrevista_JAVA.demo.entity.EntityEstabelecimento;
import Entrevista_JAVA.demo.entity.EntityPatrimonio;
import Entrevista_JAVA.demo.model.AdicionarEmprestimoRequest;
import Entrevista_JAVA.demo.repository.RepositoryEmprestimo;
import Entrevista_JAVA.demo.repository.RepositoryEstabelecimento;
import Entrevista_JAVA.demo.repository.RepositoryPatrimonio;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class CriarEmprestimo {

    private final RepositoryEstabelecimento repositoryEstabelecimento;
    private final RepositoryPatrimonio repositoryPatrimonio;
    private final RepositoryEmprestimo repositoryEmprestimo;

    public CriarEmprestimo(RepositoryEstabelecimento repositoryEstabelecimento,RepositoryPatrimonio repositoryPatrimonio, RepositoryEmprestimo repositoryEmprestimo) {
        this.repositoryEstabelecimento = repositoryEstabelecimento;
        this.repositoryPatrimonio = repositoryPatrimonio;
        this.repositoryEmprestimo = repositoryEmprestimo;
    }

    public void criarEmprestimo(AdicionarEmprestimoRequest emprestimoRequest) {
        Optional<EntityEstabelecimento> estabelecimentoRequerente = repositoryEstabelecimento.findByCnpj(emprestimoRequest.getCnpjRequerente());

        Optional<EntityEstabelecimento> estabelecimentoAtendente = repositoryEstabelecimento.findByCnpj(emprestimoRequest.getCnpjAtendente());

        if(estabelecimentoRequerente.isEmpty() || estabelecimentoAtendente.isEmpty()) {
            throw new RuntimeException("Estabelecimento inexistente");
        }

        EntityEstabelecimento entityEstabelecimentoRequerente = estabelecimentoRequerente.get();

        EntityEstabelecimento entityEstabelecimentoAtendente = estabelecimentoAtendente.get();

        if(!entityEstabelecimentoRequerente.getTipoEstabelecimento().equals(entityEstabelecimentoAtendente.getTipoEstabelecimento())) {
            throw new RuntimeException("Os estabelecimentos não possuem o mesmo tipo");
        }

        LocalDate prazoMaximo = emprestimoRequest.getDataEmprestimo().plusDays(entityEstabelecimentoAtendente.getTempoMaximoEmprestimo());

        if(emprestimoRequest.getDataDevolucao().isAfter(prazoMaximo)) {
            throw new RuntimeException("Tempo excede o prazo");
        }

        emprestimoRequest.getUuidListPatrimonio().forEach(id -> {
            Optional<EntityPatrimonio> exist = repositoryPatrimonio.findById(id);
            if(exist.isPresent()) {
                EntityPatrimonio entityPatrimonio = exist.get();
                if(entityPatrimonio.getBaixa().equals(true)) {
                    throw new RuntimeException("Patrimônio " + entityPatrimonio.getId() + " está inativo");
                }
            }
        });

        EntityEmprestimo entityEmprestimo = new EntityEmprestimo(entityEstabelecimentoRequerente,
                entityEstabelecimentoAtendente,
                emprestimoRequest.getDataEmprestimo(),
                emprestimoRequest.getDataDevolucao());

        repositoryEmprestimo.save(entityEmprestimo);
    }
}
