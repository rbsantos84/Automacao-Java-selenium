package br.com.automacao.pages;

import br.com.automacao.core.BasePage;

public class MenuPage extends BasePage {

    //clicar no link Contas,Adicionar
    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarConta(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarTelaInserirMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarTelaResumo(){
        clicarLink("Resumo Mensal");
    }

    public void acessarTelaPrincipal(){
        clicarLink("Home");
    }
}
