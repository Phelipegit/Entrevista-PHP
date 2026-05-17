package Entrevista_JAVA.demo.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class AdicionarEmprestimoRequest {

    String cnpjRequerente;

    String cnpjAtendente;

    List<UUID> uuidListPatrimonio;

    LocalDate dataEmprestimo;

    LocalDate dataDevolucao;

    public AdicionarEmprestimoRequest(String cnpjRequerente,
                                      String cnpjAtendente,
                                      LocalDate dataEmprestimo,
                                      LocalDate dataDevolucao) {
        this.cnpjRequerente = cnpjRequerente;
        this.cnpjAtendente = cnpjAtendente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        uuidListPatrimonio = new ArrayList<>();
    }
}
