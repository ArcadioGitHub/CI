package PageObjects;

import Models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class SignUpPage extends AppPage{

    @FindBy(css = "a[class='nav-item nav-link active']")
    WebElementFacade bthHome;

    @FindBy(xpath = "//a[@class='nav-item nav-link']")
    WebElementFacade btnSignIn;

    @FindBy(id="user_email")
    WebElementFacade userBox;

    @FindBy(id="user_password")
    WebElementFacade passBox;

    @FindBy(css = "input[class='btn btn-primary']")
    WebElementFacade btnLogin;

    @FindBy(xpath = "//a[text()='Sign up']")
    WebElementFacade btnSignUp;

    @FindBy(xpath = "//h1[text()='Welcome to Address Book']")
    WebElementFacade welcomeMessage;


    public void singUp(){
        Random rn = new Random();
        int result = rn.nextInt(100 - 1 + 1) + 1;
        System.out.println(result);
        btnSignIn.click();
        btnSignUp.click();
        userBox.type(String.valueOf(result).concat(User.getEmail()));
        passBox.type(User.getPass());
        btnLogin.click();
    }

    public void checkWelcomeMessage(){
        if (welcomeMessage.isDisplayed()){
            System.out.println("TESS PASSED");
        } else {
            Assert.fail("THE WELCOME MESSAGE IS NOT PRESENT");
        }
    }

}
