package gof;

import gof.Facade.Facade;
import gof.Singleton.SingletonEager;
import gof.Singleton.SingletonLazy;
import gof.Singleton.SingletonLazyHolder;
import gof.Strategy.Comportamento;
import gof.Strategy.ComportamentoAgressivo;
import gof.Strategy.ComportamentoDefensivo;
import gof.Strategy.ComportamentoNormal;
import gof.Strategy.Robo;

public class Test {
    public static void main(String[] args) {
        // TESTE SINGLETON
        /* 
        * A função do Padrão Criacional Singleton é 
        * permitir a criação de uma unica instancia
        * de uma classe e fornecer um modo para re-
        * cupera-la. 
        */

        System.out.println(" ");
        System.out.println("   TESTE SINGLETON   ");
        System.out.println(" ");
        System.out.println("--- SingletonLazy ---");
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        System.out.println(" ");
        System.out.println("--- SingletonLazyHolder ---");
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyHolder);

        System.out.println(" ");
        System.out.println("--- SingletonEager ---");
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);


        // TESTE STRATEGY
        /*
        * A função do Padrão Comportamental Strategy é
        * Simplificar a resolução de um mesmo problema
        */

        System.out.println(" ");
        System.out.println("   TESTE STRATEGY   ");
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);

        robo.mover();
        robo.mover();

        robo.setComportamento(defensivo);

        robo.mover();
        robo.mover();

        robo.setComportamento(agressivo);

        robo.mover();
        robo.mover();


        // TESTE FACADE
        /*
        * O Padrão Estrutural Facade é responsável por
        * Prover uma interface que reduza a complexid-
        * ade nas integrações com subsistemas
        */
        
        System.out.println(" ");
        System.out.println("   TESTE FACADE   ");
        Facade facade = new Facade();
        String nome = "Ricardo";
        String cep = "1234567890";
        facade.migrarCliente(nome, cep);
    }
}
