package banco;

public abstract class Transacao {
    Conta contaOrigem;
    double valor;

    public Transacao(Conta contaOrigem, double valor) {
        this.contaOrigem = contaOrigem;
        this.valor = valor;
    }

    public Conta getContaOrigem() {
        return this.contaOrigem;
    }

    public double getValor() {
        return this.valor;
    }

    public abstract void transacaoOk(String message);

    public abstract void transacaoNaoOk(String message);
}
