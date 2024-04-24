package Tests;

import Base.TestBase;
import Constans.WebConstans;
import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest extends TestBase {

    @BeforeClass
    public void DashboardSetUp()   {

        dashboardPage = loginPage.doLogin("Admin", "admin123");
    }

    @Test
    public void verifyLogout() {
        dashboardPage.doLogout();
        String actualUrl = loginPage.getLoginPageUrl();
        Assert.assertTrue(actualUrl.contains(WebConstans.LOGIN_PAGE_URL_FRACTION_VALUE));
    }


    @Test
    public void printLandingPageHeaders() {
        ArrayList<String> headerValues = dashboardPage.getLandingPageHeadersList();
        for (String e : headerValues) {
            System.out.println(e);
        }

    }

}
