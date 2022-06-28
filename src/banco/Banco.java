package banco;

import java.util.ArrayList;

public class Banco {
    String endereco;
    String nome;
    int identificador;
    ArrayList<Cliente> clientes;
    ArrayList<Conta> contas;

    public Banco(String endereco, String nome, int identificador, ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
        this.endereco = endereco;
        this.nome = nome;
        this.identificador = identificador;
        this.clientes = clientes;
        this.contas = contas;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public ArrayList<Conta> getContas() {
        return this.contas;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void setContas(Conta conta) {
        this.contas.add(conta);
    }
}
