package tests;

import helper.Util;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class TestCases {

    private WebDriver driver;

    private BoutiquePage boutiquePage;
    private HomePage homePage;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ProductPage productPage;
    private PaymentPage paymentPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {

        if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

            System.out.println("Open Firefox Driver");

        } else if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

            System.out.println("Open Chrome Driver");

        }

        driver.get("https://www.hepsiburada.com/");

        boutiquePage = new BoutiquePage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productPage = new ProductPage(driver);
        paymentPage = new PaymentPage(driver);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanUp(ITestResult testResult) throws IOException {

        if (testResult.getStatus() == ITestResult.FAILURE) {

            Util.takeScreenshot(testResult.getMethod().getMethodName(), driver);
        }
        // driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        System.out.println("############# TEST STARTED #############");
        Thread.sleep(3000);

        Util.waitHelper(driver, homePage.getLoginButton()); //Checks if the new page opens successfully or not

        Thread.sleep(4000);
        homePage.getLoginButton().click();
        Thread.sleep(1000);
        homePage.getLoginButtonInside().click();

        System.out.println("Logging in");
        Util.waitHelper(driver, loginPage.getEmailField());

        loginPage.getEmailField().sendKeys("meldakaralar7@gmail.com");
        loginPage.getPasswordField().sendKeys("Test123!");
        loginPage.getSubmitButton().click();

        Util.waitHelper(driver, boutiquePage.getSearchBox());

        System.out.println("Logged in successfully");

        boutiquePage.getSearchBox().sendKeys("kitap");
        boutiquePage.getSearchButton().click();

        Util.waitHelper(driver, productsPage.getFirstProduct());

        productsPage.getFirstProduct().click();
        Util.waitHelper(driver, productPage.getAddButton());

        productPage.getAddButton().click();

        Util.waitHelper(driver, productPage.getGoToBoxButton());

        System.out.println("Product has been added to basket successfully");

        productPage.getGoToBoxButton().click();

        Util.waitHelper(driver, paymentPage.getContinueButton());

        paymentPage.getContinueButton().click();

        Util.waitHelper(driver, paymentPage.getContinueButton());

        paymentPage.getContinueButton().click();

        Util.waitHelper(driver, paymentPage.getInstantRemittanceButton());

        paymentPage.getInstantRemittanceButton().click();

        Util.waitHelper(driver, paymentPage.getIsBankasi());

        paymentPage.getIsBankasi().click();

        System.out.println("############# TEST FINISHED #############");

    }
}
