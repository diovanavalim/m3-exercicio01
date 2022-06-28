package excecoes;

public class ContaNaoAutorizada extends Exception {
    public ContaNaoAutorizada() {
        super("Conta não autorizada para realizar a operação!");
    }
}
