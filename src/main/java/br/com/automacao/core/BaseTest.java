package br.com.automacao.core;


import br.com.automacao.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static br.com.automacao.core.DriverFactory.getDriver;
import static br.com.automacao.core.DriverFactory.killDriver;

public class BaseTest {
    @Rule
    public TestName testName = new TestName();

    private static LoginPage page = new LoginPage();

    @Before
    public void inicializa() {
        page.acessarTelaInicial();

        page.setEmail("renato@teste.com.br");
        page.setSenha("teste123");
        page.entrar();
    }

    @After
    public void finaliza() throws IOException {
        TakesScreenshot ss = (TakesScreenshot) getDriver();
        File arquivo = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" +
                File.separator + testName.getMethodName() + ".jpg"));

        if (Propriedades.FECHAR_BROWSER) {
            killDriver();
        }
    }
}
