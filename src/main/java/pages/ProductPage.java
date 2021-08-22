package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addToCart")
    private WebElement addButton;

    @FindBy(xpath = "//button[text()='Sepete git']")
    private WebElement goToBoxButton;

    public WebElement getAddButton() {
        return addButton;
    }

    public WebElement getGoToBoxButton() {
        return goToBoxButton;
    }

}

