package banco;

import excecoes.ContaNaoAutorizada;

public class ConsultaDeSaldo extends Transacao {
    public ConsultaDeSaldo(Conta contaOrigem, int valor) {
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

    public void consultaSaldo() {
        try {
            if (this.contaOrigem.getCliente().getTipo().equals("Executivo")) {
                throw new ContaNaoAutorizada();
            }

            double saldo = this.contaOrigem.getSaldo();
            this.transacaoOk(String.format("O saldo da conta %d é %f", this.contaOrigem.getNumeroConta(), saldo));
        } catch (Exception e) {
            this.transacaoNaoOk(e.getMessage());
        }
    }
}
