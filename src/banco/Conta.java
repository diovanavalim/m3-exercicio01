package banco;

public class Conta {
    int numeroConta;
    int agencia;
    double saldo;
    Cliente cliente;

    public Conta(int numeroConta, int agencia, double saldo, Cliente cliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
