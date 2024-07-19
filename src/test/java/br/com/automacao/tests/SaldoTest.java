package br.com.automacao.tests;

import br.com.automacao.core.BaseTest;
import br.com.automacao.core.Propriedades;
import br.com.automacao.pages.HomePage;
import br.com.automacao.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {
    HomePage page = new HomePage();
    MenuPage menu = new MenuPage();

    @Test
    public void testSaldoConta(){
        menu.acessarTelaPrincipal();
       // Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
        Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
    }
}
