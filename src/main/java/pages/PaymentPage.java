package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {


    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "continue_step_btn")
    private WebElement continueButton;

    @FindBy(xpath = "(//div[@class='sardesPaymentPage-Accordion-header_context'])[2]")
    private WebElement instantRemittanceButton;

    @FindBy(xpath = "(//div[@class='sardesPaymentPage-MoneyTransfer-money_transfer_header'])[2]")
    private WebElement isBankasi;

    @FindBy(name = "İş Bankası")
    private WebElement isBankasiInside;

    @FindBy(css = "div.shake_btn_1mlt3")
    private WebElement shakeButton;

    @FindBy(xpath = "//input[@prefix='co-checkbox']")
    private WebElement contractButton;


    public WebElement getIsBankasi() {
        return isBankasi;
    }

    public WebElement getInstantRemittanceButton() {
        return instantRemittanceButton;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getIsBankasiInside() {
        return isBankasiInside;
    }

    public WebElement getShakeButton() {
        return shakeButton;
    }

    public WebElement getContractButton() {
        return contractButton;
    }

}
