package br.com.automacao.pages;

import br.com.automacao.core.BasePage;
import br.com.automacao.core.DriverFactory;


public class LoginPage extends BasePage {

        public void acessarTelaInicial(){
       //     DriverFactory.getDriver().get("http://srbarriga.herokuapp.com");
              DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");
        }

        public void setEmail(String email) {
            escrever("email", email);
        }

        public void setSenha(String senha) {
            escrever("senha", senha);
        }

        public void entrar(){
          //  clicarBotao(By.xpath("//button[.='Entrar']"));
            clicarBotaoPorTexto("Entrar");
        }


        public void logar(String email, String senha) {
            setEmail(email);
            setSenha(senha);
            entrar();
        }

    }

