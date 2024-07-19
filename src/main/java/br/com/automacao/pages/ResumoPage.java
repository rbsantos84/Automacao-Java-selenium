package br.com.automacao.pages;

import br.com.automacao.core.BasePage;
import org.openqa.selenium.By;

public class ResumoPage extends BasePage {

    /**
     * //span[@class='glyphicon glyphicon-remove-circle'] -> pesquisa pela tag span
     * que contem a classe glyphicon glyphicon-remove-circle
     */
    public void excluirMovimentacao(){
        clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
    }

    /**
     * //div[@class='alert alert-success'] -> procura pela div que contém a classe alert alert-success
     */
    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public void selecionarAno(String ano) {
        selecionarCombo("ano", ano);
    }

    /**
     * //input[@value='Buscar'] -> procura por input onde valor seja igual 'Buscar'
     */
    public void buscar(){
        clicarBotao(By.xpath("//input[@value='Buscar']"));
    }
}
