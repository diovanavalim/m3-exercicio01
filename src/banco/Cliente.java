package banco;

import java.util.ArrayList;

public class Cliente {
    String nome;
    String endereco;
    String cpf;
    String tipo;
    ArrayList<Transacao> transacoes;

    public Cliente(String nome, String endereco, String cpf, String tipo) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.tipo = tipo;
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

    public String getTipo() {
        return this.tipo;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTransacoes(Transacao transacao) {
        this.transacoes.add(transacao);
    }

}
