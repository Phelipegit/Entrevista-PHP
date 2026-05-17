package Entrevista_JAVA.demo.model;

import Entrevista_JAVA.demo.EnumTipoESTABELECIMENTO;

import lombok.Getter;

@Getter
public class CadastrarEstabelecimentoRequest {

    private String nome;

    private String cnpj;

    private EnumTipoESTABELECIMENTO tipoEstabelecimento;

    private Integer tempoMaximoEmprestimo;


    public CadastrarEstabelecimentoRequest(String nome, String cnpj, EnumTipoESTABELECIMENTO tipoEstabelecimento, Integer tempoMaximoEmprestimo) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.tipoEstabelecimento = tipoEstabelecimento;
        this.tempoMaximoEmprestimo = tempoMaximoEmprestimo;
    }

    public CadastrarEstabelecimentoRequest() {

    }
}
