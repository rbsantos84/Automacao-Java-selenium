package br.com.automacao.pages;

import br.com.automacao.core.BasePage;

public class HomePage extends BasePage {

    public String obterSaldoConta(String nome) {
        return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();
    }
}
