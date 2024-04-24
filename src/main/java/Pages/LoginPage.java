package Pages;

import Constans.WebConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementUtil;

public class LoginPage {
    WebDriver driver;
    ElementUtil elementUtil;

    //Constructor to receive the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementUtil = new ElementUtil(driver);
        

    }

    //Page Locators
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()=' Login ']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[text()='Forgot your password? ']")
    private WebElement forgotPasswordLink;

    public String getLoginPageTitle() {
        return elementUtil.waitForTitleIsAndFetch(WebConstans.DEFAULT_SHORT_TIME_OUT, WebConstans.PAGE_TITLE_VALUE);
    }

    public String getLoginPageUrl() {
        return elementUtil.waitForURLContainsAndFetch(WebConstans.DEFAULT_SHORT_TIME_OUT, WebConstans.LOGIN_PAGE_URL_FRACTION_VALUE);
    }

    public boolean isForgotPasswordLinkExist() {
        return elementUtil.waitForElementVisible(forgotPasswordLink, WebConstans.DEFAULT_SHORT_TIME_OUT).isDisplayed();
    }


    public DashboardPage doLogin(String usr, String pass) {
        elementUtil.waitForElementVisible(userNameField, WebConstans.DEFAULT_SHORT_TIME_OUT).sendKeys(usr);
        elementUtil.doSendKeys(passwordField, pass);
        elementUtil.doClick(loginButton);
        return new DashboardPage(driver);
    }


}