package Entrevista_JAVA.demo;

import lombok.Getter;

@Getter
public enum EnumTipo {
    PROPRIO("Próprio"),ALUGADO("Alugado"),EMPRESTADO("Emprestado");

    private String nome;

    EnumTipo(String nome) {
        this.nome = nome;
    }
}
