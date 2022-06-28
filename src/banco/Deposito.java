package banco;

import excecoes.ContaNaoAutorizada;

public class Deposito implements Transacao {
    Conta contaOrigem;
    double valor;

    public Deposito(Conta contaOrigem, double valor) {
        this.contaOrigem = contaOrigem;
        this.valor = valor;
    }

    public Conta getContaOrigem() {
        return this.contaOrigem;
    }

    public double getValor() {
        return this.valor;
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

    public void depositaValor() {
        try {
            if (!(this.contaOrigem.getCliente() instanceof Executivo)) {
                throw new ContaNaoAutorizada();
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
