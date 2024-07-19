package br.com.automacao.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverFactory {
    /**
     * possuir uma instancia do webdriver porque ele que vai gerenciar
     * essa instancia deve ser static
     * deve ter um construtor private porque dessa forma ninguém vai conseguir instanciar essa classe
     * toda vez que alguem querer acessa essa classe, deve acessar através de um metodo public static
     */

    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected synchronized WebDriver initialValue() {
            try {
                return initDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
    };


    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() throws MalformedURLException {
        WebDriver driver = null;
        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.LOCAL) {
            switch (Propriedades.BROWSER) {
                case FIREFOX:
                    driver = new FirefoxDriver();
                    break;
                case CHROME:
                    driver = new ChromeDriver();
                    break;
            }
        }

        if (Propriedades.TIPO_EXECUCAO == Propriedades.TipoExecucao.GRID) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (Propriedades.BROWSER) {
                case FIREFOX:
                    capabilities.setBrowserName("firefox");
                    break;
                case CHROME:
                    capabilities.setBrowserName("chrome");
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL("http://192.168.0.235:4444"), capabilities);
            } catch (MalformedURLException e) {
                System.err.println("Falha na conexão com o GRID");
                e.printStackTrace();
            }
        }


        assert driver != null;
        driver.manage().window().setSize(new Dimension(1200, 765));
        //driver.manage().window().maximize();
        return driver;
    }


    public static void killDriver() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (threadDriver != null) {
            threadDriver.remove();
        }
    }
}