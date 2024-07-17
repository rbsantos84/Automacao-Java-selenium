package br.com.automacao.tests;

import br.com.automacao.core.BaseTest;
import br.com.automacao.core.Propriedades;
import br.com.automacao.pages.ContasPage;
import br.com.automacao.pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testExcluirContaComMovimentacao(){
        menuPage.acessarTelaListarConta();

        contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);

        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
