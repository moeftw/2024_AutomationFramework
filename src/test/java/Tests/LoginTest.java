package Tests;

import Base.TestBase;
import Constans.WebConstans;
import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {



    @Test(priority = 1)
    public void loginPageTitleTest() {
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, WebConstans.PAGE_TITLE_VALUE);
    }


    @Test(priority = 2)
    public void loginTest() {

        dashboardPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertTrue(dashboardPage.doesLogOutLinkExist());

    }

}
