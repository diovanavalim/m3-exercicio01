package banco;

import excecoes.ContaNaoAutorizada;
import excecoes.SaldoInsuficienteException;

public class PagamentoServico implements Transacao {
    Conta contaOrigem;
    Conta contaDestino;
    String servico;
    double valor;

    public PagamentoServico(Conta contaOrigem, Conta contaDestino, String servico, double valor) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.servico = servico;
        this.valor = valor;
    }

    public Conta getContaOrigem() {
        return this.contaOrigem;
    }

    public Conta getContaDestino() {
        return this.contaDestino;
    }

    public String getServico() {
        return this.servico;
    }

    public double getValor() {
        return this.valor;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void transacaoOk(String mensagem) {
        System.out.println(mensagem);
    }

    @Override
    public void transacaoNaoOk(String mensagem) {
        System.out.println(mensagem);
    }

    public void pagarServico() {
        try {
            if (!(this.contaOrigem.getCliente() instanceof Basico)) {
                throw new ContaNaoAutorizada();
            }

            if (this.contaOrigem.getSaldo() < this.getValor()) {
                throw new SaldoInsuficienteException();
            } else {
                this.contaOrigem.setSaldo(this.contaOrigem.getSaldo() - valor);
                this.contaDestino.setSaldo(this.contaDestino.getSaldo() + valor);

                this.transacaoOk(String.format("Pagamento de %f reais ao serviço %s realizada com sucesso", valor, this.getServico()));
            }
        } catch (Exception e) {
            this.transacaoNaoOk(e.getMessage());
        }
    }
}
