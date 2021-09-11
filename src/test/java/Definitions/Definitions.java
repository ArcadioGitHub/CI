package Definitions;

import Models.User;
import PageObjects.AppPage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class Definitions {
    @Steps
    AppPage appPage;
    SignUpPage signUpPage;
    LoginPage loginPage;

    @Before
    public void setup() {
        appPage.getEnvAndUserData();
        User.setUser();
        appPage.goToHome();
    }

    @Given("^the user goes to the page and gets registered$")
    public void theUserGoesToThePageAndGetsRegistered() {
        signUpPage.singUp();
    }

    @Then("^the user should see a successful signup message$")
    public void theUserShouldSeeASuccessfulSignupMessage() {
        signUpPage.checkWelcomeMessage();
    }

    @Given("^the user goes to the page and types his credentials$")
    public void theUserGoesToThePageAndTypesHisCredentials() {
        loginPage.signIn();
    }
}