package banco;

public interface Transacao {
    public void transacaoOk(String message);

    public void transacaoNaoOk(String message);
}
