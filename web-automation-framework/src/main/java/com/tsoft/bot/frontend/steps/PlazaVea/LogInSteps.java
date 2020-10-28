package com.tsoft.bot.frontend.steps.PlazaVea;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.pages.LogInPages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class LogInSteps {

    public WebDriver driver;
    LogInPages logInPages = new LogInPages();

    public LogInSteps() {
        this.driver = Hook.getDriver();
    }

    @Given("^Usuario ingresa a la URL Plaza Vea \"([^\"]*)\"$")
    public void usuarioIngresaALaURLPlazaVea(String casoPrueba) throws Throwable {

        logInPages.enterWeb(casoPrueba);
    }

    @When("^Ingreso a perfil e Inicia sesión como usuario recurrente \"([^\"]*)\"$")
    public void ingresoAPerfilEIniciaSesiónComoUsuarioRecurrente(String casoPrueba) throws Throwable {
        logInPages.logIn(casoPrueba);
    }

    @Then("^Valido el inicio de sesión$")
    public void validoElInicioDeSesión() throws Throwable {
        logInPages.validateLogIn();
    }
}
