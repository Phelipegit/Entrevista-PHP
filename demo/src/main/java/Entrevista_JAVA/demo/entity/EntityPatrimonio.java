package Entrevista_JAVA.demo.entity;

import Entrevista_JAVA.demo.EnumTipo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class EntityPatrimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private Integer codigo;

    @Enumerated(EnumType.STRING)
    private EnumTipo enumTipo;

    private LocalDate dataEntrada;

    @ManyToOne
    @JoinColumn(name = "id_estabelecimento")
    private EntityEstabelecimento estabelecimento;

    public EntityPatrimonio(String nome, Integer codigo, EnumTipo enumTipo, LocalDate dataEntrada) {
        this.nome = nome;
        this.codigo = codigo;
        this.enumTipo = enumTipo;
        this.dataEntrada = dataEntrada;
    }

    public EntityPatrimonio() {

    }
}
