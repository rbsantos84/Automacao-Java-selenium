package br.com.automacao.tests;

import br.com.automacao.core.BaseTest;
import br.com.automacao.core.Propriedades;
import br.com.automacao.pages.ContasPage;
import br.com.automacao.pages.LoginPage;
import br.com.automacao.pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Questão de boas praticas no PageObject as classes tests não deve referenciar
 * nenhum item de tela (nem html, nem css) nada que referencia a tela
 * a classe de teste tem que ser focada no negocio aqui podemos observar nessa classe
 * principalmente nos imports que não tem nada de selenium, driver, dsl, todo acesso é feito
 * pelas pages
 * as classes page que estão com os ids, xpath, classes do css e também não está fazendo
 * nenhuma assertiva
 */


//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();


    @Test
    public void test1_InserirConta() {
        menuPage.acessarTelaInserirConta();

        contasPage.setNome("Conta do Teste");
        contasPage.salvar();

        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test2_AlterarConta() {
        menuPage.acessarTelaListarConta();

        contasPage.clicarAlterarConta("Conta para alterar");

        contasPage.setNome("Conta Alterada");
        contasPage.salvar();

        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_InserirContaMesmoNome() {
        menuPage.acessarTelaInserirConta();

        //contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
        contasPage.setNome("Conta mesmo nome");
        contasPage.salvar();

        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }

    /** @Test public void testExcluirContaComMovimentacao(){
    menuPage.acessarTelaListarConta();

    contasPage.clicarExcluirConta("Conta do Teste alterada");

    Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }*/

}
