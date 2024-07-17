package br.com.automacao.pages;

import br.com.automacao.core.BasePage;
import org.openqa.selenium.By;

public class ContasPage extends BasePage {

    public void setNome(String nome) {
        escrever("nome", nome);
    }

    /**
     * xpath //button[.='Salvar'] -> encontrar button que contenha o texto Salvar
     */
    public void salvar() {
        clicarBotaoPorTexto("Salvar");
       // clicarBotao(By.xpath("//button[.='Salvar']"));

    }

    /**
     * //div[@class='alert alert-success']" -> procura pela div que contém a classe 'alert alert-success'
     */
    public String obterMensagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    /**
     * //div[@class='alert alert-danger'] -> procura dentro da div a classe alert alert-danger
     */
    public String obterMensagemErro() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    /**
     * .//span[@class='glyphicon glyphicon-edit'] -> referencia dentro no span onde contém a classe glyphicon glyphicon-edit
     * obterCelula -> procura pela coluna Conta, onde tem o botão Ações e o id da tabela seja tabelaContas
     */
    public void clicarAlterarConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
    }

    /**
     * .//span[@class='glyphicon glyphicon-remove-circle'] -> procura pela tag span que
     * contem a classe glyphicon glyphicon-remove-circle
     */
    public void clicarExcluirConta(String string) {
        obterCelula("Conta", string, "Ações", "tabelaContas")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }


}
