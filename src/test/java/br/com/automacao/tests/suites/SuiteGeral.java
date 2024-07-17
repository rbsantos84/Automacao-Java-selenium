package br.com.automacao.tests.suites;

import br.com.automacao.core.DriverFactory;
import br.com.automacao.pages.LoginPage;
import br.com.automacao.tests.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class

})

public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void inicializa(){
        page.acessarTelaInicial();

        page.setEmail("renato@teste.com.br");
        page.setSenha("teste123");
        page.entrar();
    }

    @AfterClass
    public static void finaliza(){
        DriverFactory.killDriver();
    }
}