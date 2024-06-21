import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private List<Map<String, Object>> transacoes = new ArrayList<>();

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        String tipo = "Sacar";
        saldo -= valor;
        registrarTransacao(tipo, valor); 
    }

    @Override
    public void depositar(double valor) {
        String tipo = "Depositar";
        saldo += valor;
        registrarTransacao(tipo, valor); 
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        String tipo = "Transferir";
        this.sacar(valor);
        contaDestino.depositar(valor);
        registrarTransacao(tipo, valor);    
    }
    
    private void registrarTransacao(String tipo, double valor){
        Date dataHoraAtual = new Date();
        Map<String, Object> transacao = new HashMap<>();

        transacao.put("tipo", tipo);
        transacao.put("valor", valor);
        transacao.put("data", dataHoraAtual);

        transacoes.add(transacao);
    }

    public List<Map<String, Object>> gerarRelatorio(String tipoTransacao){
        return transacoes.stream()
            .filter(transacao -> tipoTransacao == null || 
                ((String) transacao.get("tipo")).equalsIgnoreCase(tipoTransacao))
            .collect(Collectors.toList());
    }

    public int getAgencia(){
        return agencia;
    }

    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }


    protected void imprimirInformacoesComuns(){
        System.out.println(String.format("Titular: %s ", this.cliente.getNome()));
        System.out.println(String.format("Agência: %s ", this.agencia));
        System.out.println(String.format("Numero: %s ", this.numero));
        System.out.println(String.format("Saldo: %s ", this.saldo));
    }

    protected void exibirExtrato(){
        StringBuilder  extrato = new StringBuilder();
        boolean existeExtrato = false;
        for (Map<String, Object> transacao : gerarRelatorio(null)) {
              String data = transacao.get("data").toString();
              String tipo = transacao.get("tipo").toString();
              double valor = (double) transacao.get("valor");
              extrato.append("\n")
                    .append(tipo)
                    .append(":")
                    .append("\n")
                    .append("\tR$")
                    .append(String.format("%.2f", valor))
                    .append("\n")
                    .append(data);
              existeExtrato = true;
        }
        if (existeExtrato == false) {
            System.out.println("Não foram realizadas movimentações.");
        }
        System.out.println(extrato);
    }
}