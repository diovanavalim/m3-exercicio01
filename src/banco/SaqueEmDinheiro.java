package banco;

import excecoes.ContaNaoAutorizada;
import excecoes.SaldoInsuficienteException;

public class SaqueEmDinheiro extends Transacao {
    public SaqueEmDinheiro(Conta contaOrigem, double valor) {
        super(contaOrigem, valor);
    }

    @Override
    public void transacaoOk(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public void transacaoNaoOk(String mensagem) {
        System.out.println(mensagem);
    }

    public void sacarValor() {
        try {
            if (this.contaOrigem.getCliente() instanceof Executivo) {
                throw new ContaNaoAutorizada();
            }

            if (this.contaOrigem.getSaldo() < this.getValor()) {
                throw new SaldoInsuficienteException();
            } else {
                this.contaOrigem.setSaldo(this.contaOrigem.getSaldo() - this.getValor());
                this.transacaoOk(String.format("Valor %f sacado com sucesso da conta %d", this.valor, this.contaOrigem.getNumeroConta()));
            }
        } catch (Exception e) {
            this.transacaoNaoOk(e.getMessage());
        }
    }
}
