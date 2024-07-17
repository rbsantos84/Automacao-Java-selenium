package br.com.automacao.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    /**
     * possuir uma instancia do webdriver porque ele que vai gerenciar
     * essa instancia deve ser static
     * deve ter um construtor private porque dessa forma ninguém vai conseguir instanciar essa classe
     * toda vez que alguem querer acessa essa classe, deve acessar através de um metodo public static
     */

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            switch (Propriedades.browser) {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    driver = new ChromeDriver();
                    break;
            }
            //driver.manage().window().setSize(new Dimension(1200, 765));
              driver.manage().window().maximize();
        }
        return driver;
    }

    //mata a instancia do driver
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
