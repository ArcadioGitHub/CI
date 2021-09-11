package PageObjects;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class AppPage extends PageObject {

    EnvironmentVariables environmentVariables;
    public static DocumentContext user;
    String envBaseUrl;
    Object envsData;

    public void getEnvAndUserData() {
        envBaseUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
        String env = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("env");
        JSONParser parser = new JSONParser();
        try {
            JSONObject data = (JSONObject) parser.parse(new FileReader("src/test/resources/dataDriven/userData.json"));
            envsData = data.get(env);
            user = JsonPath.parse(envsData);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void goToHome() {
        getDriver().get(envBaseUrl);
    }

}

