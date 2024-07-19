package br.com.automacao.core;

public class Propriedades {

    //utilizar essa estrategia somente um browser setando para false
    // somente na fase de desenvolvimento
    //o recomendável é que cada teste abre e feche o navegador após finalização do seu teste
    public static boolean FECHAR_BROWSER = true;

    //public static String NOME_CONTA_ALTERADA = "Conta Alterada " + System.nanoTime();

    //definindo a propriedade que por padrão será o browser chrome
    public static Browsers BROWSER = Browsers.CHROME;

    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;

    public enum Browsers {
        CHROME,
        FIREFOX
    }

    public enum TipoExecucao {
        LOCAL,
        GRID


    }

}
