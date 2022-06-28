package banco;

import excecoes.ContaNaoAutorizada;
import excecoes.SaldoInsuficienteException;

public class Transferencia implements Transacao {
    Conta contaDestino;
    Conta contaOrigem;
    double valor;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        this.contaDestino = contaDestino;
        this.contaOrigem = contaOrigem;
        this.valor = valor;
    }

    public Conta getContaDestino() {
        return this.contaDestino;
    }

    public Conta getContaOrigem() {
        return this.contaOrigem;
    }

    public double getValor() {
        return this.valor;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void transacaoOk(String message) {
        System.out.println(message);
    }

    @Override
    public void transacaoNaoOk(String message) {
        System.out.println(message);
    }

    public void transfereValor() {
        try {
            if (!(this.contaOrigem.getCliente() instanceof Executivo)) {
                throw new ContaNaoAutorizada();
            }

            double saldoContaOrigem = this.contaOrigem.getSaldo();
            if (saldoContaOrigem < this.valor) {
                throw new SaldoInsuficienteException();
            } else {
                this.contaOrigem.setSaldo(this.contaOrigem.getSaldo() - valor);
                this.contaDestino.setSaldo(this.contaDestino.getSaldo() + valor);

                this.transacaoOk(String.format("Valor %f transferido com sucesso da conta %d para a conta %d", this.valor, this.contaOrigem.getNumeroConta(), this.contaDestino.getNumeroConta()));
            }
        } catch (Exception e) {
            transacaoNaoOk(e.getMessage());
        }
    }
}
