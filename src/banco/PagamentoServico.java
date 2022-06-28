package banco;

import excecoes.ContaNaoAutorizada;
import excecoes.SaldoInsuficienteException;

public class PagamentoServico extends Transacao {
    String servico;
    Conta contaDestino;

    public PagamentoServico(Conta contaOrigem, Conta contaDestino, String servico, int valor) {
        super(contaOrigem, valor);
        this.contaDestino = contaDestino;
        this.servico = servico;
    }

    public String getServico() {
        return this.servico;
    }

    public Conta getContaDestino() {
        return this.contaDestino;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public void setContaDestino(Conta conta) {
        this.contaDestino = conta;
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
