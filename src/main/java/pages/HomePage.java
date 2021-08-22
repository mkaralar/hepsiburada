package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

   // @FindBy(xpath = "//span[text()='Giriş Yap']")
    @FindBy(css = "span.sf-OldMyAccount-PhY-T")
    private WebElement loginButton;

    @FindBy(id = "login")
   // @FindBy(xpath = "//a[@id='login']")
    private WebElement loginButtonInside;

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLoginButtonInside() {
        return loginButtonInside;
    }

}
