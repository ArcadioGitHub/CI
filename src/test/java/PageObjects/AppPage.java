package PageObjects;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;

public class AppPage extends PageObject {

    private EnvironmentVariables environmentVariables;
    DocumentContext user;
    String envBaseUrl;

    public void getEnv() {
        envBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
        String user =  EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("user");
        this.user = JsonPath.parse(user);
    }

    public void goToHome(){
        getDriver().get(envBaseUrl);
    }

}

