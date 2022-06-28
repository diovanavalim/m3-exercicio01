package banco;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco("Rua Luiz Oscar de Carvalho, nº 75", "Mercado Pago", 9823, new ArrayList<Cliente>(), new ArrayList<Conta>());

        // cliente como classe abstrata derivando executivo, basico e cobrador
        Cliente maria = new Cliente("Maria Silva", "Rua Desembargador Vitor Lima, nº 33", "113.890.719-79", "Executivo");
        Cliente joao = new Cliente("João Olavo", "Rua Desembargador Vitor Lima, nº 33", "113.879.293-29", "Básico");
        Cliente luisa = new Cliente("Luisa Souza", "Rua Desembargador Vitor Lima, nº 33", "838.333.432-90", "Cobrador");

        Conta contaMaria = new Conta(1902, 10929, 800, maria);
        Conta contaJoao = new Conta(9020, 392102, 8000, joao);
        Conta contaLuisa = new Conta(1234, 23455, 1800, luisa);

        banco.setClientes(maria);
        banco.setClientes(joao);
        banco.setClientes(luisa);

        banco.setContas(contaMaria);
        banco.setContas(contaJoao);
        banco.setContas(contaLuisa);

        System.out.println("Banco");
        System.out.println(String.format("Nome: %s", banco.getNome()));
        System.out.println(String.format("Endereço: %s", banco.getEndereco()));
        System.out.println(String.format("Nome: %s", banco.getNome()));
        System.out.println(String.format("Identificador: %d", banco.getIdentificador()));

        System.out.println("Clientes:");
        for (int i = 0; i < banco.getClientes().size(); i++) {
            String cliente = banco.getClientes().get(i).getNome();
            System.out.println(cliente);
        }

        // transformar transacoes em interfaces
        SaqueEmDinheiro t1 = new SaqueEmDinheiro(contaJoao, 900);
        Transferencia t2 = new Transferencia(contaMaria, contaJoao, 89);
        Deposito t3 = new Deposito(contaLuisa, 800);

        System.out.println("Transações Válidas:");
        System.out.println("Saque em dinheiro, João");
        System.out.println("Transferência, Maria");
        System.out.println("Depósito, João");

        t1.sacarValor();
        t2.transfereValor();
        t3.depositaValor();

        System.out.println(String.format("Saldo João: %f", contaJoao.getSaldo()));
        System.out.println(String.format("Saldo Maria: %f", contaMaria.getSaldo()));
        System.out.println(String.format("Saldo Luisa: %f", contaLuisa.getSaldo()));

        System.out.println("Transações Inválidas:");
        System.out.println("Consulta de Saldo, Maria");
        System.out.println("Transferência, João");
        System.out.println("Pagamento de Serviço, Luisa");

        ConsultaDeSaldo t4 = new ConsultaDeSaldo(contaMaria, 890);
        Transferencia t5 = new Transferencia(contaJoao, contaLuisa, 890);
        PagamentoServico t6 = new PagamentoServico(contaLuisa, contaJoao, "Manutenção de celular", 100);

        t4.consultaSaldo();
        t5.transfereValor();
        t6.pagarServico();
    }
}
