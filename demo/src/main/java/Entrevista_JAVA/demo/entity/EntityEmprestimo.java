package Entrevista_JAVA.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/*
Entidade empréstimo
 */
@Entity
public class EntityEmprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_requerente")
    private EntityEstabelecimento estabelecimentoRequerente;
    @ManyToOne
    @JoinColumn(name = "id_atendente")
    private EntityEstabelecimento estabelecimentoAtendente;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    @ManyToMany
    @JoinTable(
            name = "emprestimo_patrimonio",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_patrimonio")
    )
    private List<EntityPatrimonio> entityPatrimonioList;

    public EntityEmprestimo() {

    }
}
