package Entrevista_JAVA.demo;

public enum EnumTipo {
    PROPRIO("Próprio"),ALUGADO("Alugado"),EMPRESTADO("Emprestado");

    private String nome;

    EnumTipo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
