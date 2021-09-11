package PageObjects;

import Models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AppPage {

    @FindBy(css = "a[class='nav-item nav-link active']")
    WebElementFacade bthHome;

    @FindBy(xpath = "//a[@class='nav-item nav-link']")
    WebElementFacade btnSignIn;

    @FindBy(id="session_email")
    WebElementFacade userSignInBox;

    @FindBy(id="session_password")
    WebElementFacade passSignInBox;

    @FindBy(css = "input[class='btn btn-primary']")
    WebElementFacade btnLogin;

    @FindBy(xpath = "//a[text()='Sign up']")
    WebElementFacade btnSignUp;

    public void signIn(){
        btnSignIn.click();
        userSignInBox.type(User.getEmail());
        passSignInBox.type(User.getPass());
        btnLogin.click();
    }



}
