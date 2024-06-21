
public class Main {
    public static void main(String[] args) throws Exception {
         Cliente ricardo = new Cliente();
         ricardo.setNome("RicardoUbi");

         Conta corrente = new ContaCorrente(ricardo);
         Conta poupanca = new ContaPoupanca(ricardo);
        
         corrente.depositar(100);
         corrente.transferir(100, poupanca);

         corrente.imprimirExtrato();
         poupanca.imprimirExtrato();
    }
}
