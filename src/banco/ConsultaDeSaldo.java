package banco;

import excecoes.ContaNaoAutorizada;

public class ConsultaDeSaldo implements Transacao {
    Conta contaOrigem;

    public ConsultaDeSaldo(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaOrigem() {
        return this.contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
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
            if (this.contaOrigem.getCliente() instanceof Executivo) {
                throw new ContaNaoAutorizada();
            }

            double saldo = this.contaOrigem.getSaldo();
            this.transacaoOk(String.format("O saldo da conta %d é %f", this.contaOrigem.getNumeroConta(), saldo));
        } catch (Exception e) {
            this.transacaoNaoOk(e.getMessage());
        }
    }
}
