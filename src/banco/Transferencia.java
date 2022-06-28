package banco;

import excecoes.ContaNaoAutorizada;
import excecoes.SaldoInsuficienteException;

public class Transferencia extends Transacao {
    Conta contaDestino;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        super(contaOrigem, valor);
        this.contaDestino = contaDestino;
    }

    public Conta getContaDestino() {
        return this.contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
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
