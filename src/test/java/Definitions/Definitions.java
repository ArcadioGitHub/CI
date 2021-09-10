package Definitions;

import PageObjects.AppPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class Definitions {
    @Steps
    AppPage appPage;

    @Before
    public void setup() {
        appPage.getEnv();
    }

    @Given("^the user goes to the dev env$")
    public void theUserGoesToTheDevEnv() {
        appPage.goToHome();
    }

}