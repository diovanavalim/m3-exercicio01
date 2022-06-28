package banco;

import java.util.ArrayList;

public abstract class Cliente {
    String nome;
    String endereco;
    String cpf;
    ArrayList<Transacao> transacoes;

    public Cliente(String nome, String endereco, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCpf() {
        return this.cpf;
    }

    public ArrayList<Transacao> getTransacoes() {
        return this.transacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTransacoes(Transacao transacao) {
        this.transacoes.add(transacao);
    }

}
