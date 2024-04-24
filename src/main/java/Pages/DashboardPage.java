package Pages;

import Constans.WebConstans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    @FindBy(css = "span.oxd-userdropdown-tab > p.oxd-userdropdown-name")
    private WebElement userDropdown;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']//li//a//span")
    private List<WebElement> pageHeaders;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementUtil = new ElementUtil(driver);
    }

    public void doLogout() {
        elementUtil.waitForElementVisible(userDropdown, WebConstans.DEFAULT_MEDIUM_TIME_OUT).click();
        elementUtil.waitForElementVisible(logout, WebConstans.DEFAULT_SHORT_TIME_OUT).click();
    }

    public boolean doesLogOutLinkExist() {
        elementUtil.waitForElementVisible(userDropdown, WebConstans.DEFAULT_MEDIUM_TIME_OUT).click();
        return elementUtil.waitForElementVisible(logout, WebConstans.DEFAULT_SHORT_TIME_OUT).isDisplayed();
    }

    public String getDashBoardPageUrl() {
        return elementUtil.waitForURLContainsAndFetch(WebConstans.DEFAULT_MEDIUM_TIME_OUT, WebConstans.DASHBOARD_PAGE_URL_FRACTION_VALUE);
    }

    public void getDashboardPageTitle() {
        elementUtil.waitForTitleContainsAndFetch(WebConstans.DEFAULT_MEDIUM_TIME_OUT, WebConstans.PAGE_TITLE_VALUE);
    }

    public ArrayList<String> getLandingPageHeadersList() {
        elementUtil.waitForElementsVisible(pageHeaders, 10);
        ArrayList<String> headerValues = new ArrayList<>();
        for (WebElement header : pageHeaders) {
            String text = header.getText();
            headerValues.add(text);

        }
        return headerValues;
    }
}
