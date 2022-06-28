package banco;

import java.util.ConcurrentModificationException;

public class Deposito extends Transacao {
    public Deposito(Conta contaOrigem, double valor) {
        super(contaOrigem, valor);
    }

    @Override
    public void transacaoOk(String message) {
        System.out.println(message);
    }

    @Override
    public void transacaoNaoOk(String message) {
        System.out.println(message);
    }

    public void depositaValor() {
        try {
            if (!this.contaOrigem.getCliente().getTipo().equals("Executivo")) {
                throw new ConcurrentModificationException();
            } else {
                double saldoFinal = this.contaOrigem.getSaldo() + this.valor;
                this.contaOrigem.setSaldo(saldoFinal);

                this.transacaoOk("Valor depositado com sucesso!");
            }
        } catch (Exception e) {
            this.transacaoNaoOk(e.getMessage());
        }
    }
}
