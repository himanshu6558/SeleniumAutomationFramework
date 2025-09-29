package org.example.tests.vwo.pageObjectModel;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.base.BaseTest;
import org.example.driver.DriverManager;
import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin.class);


    @Owner("PRAMOD")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {

        logger.info("Starting the Testcases Page Object Model");


        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Assertions - 3 - V

        logger.info("Asserting the invalid credentials");

        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));



    }

    @Owner("PRAMOD")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        logger.info("Starting the Testcases Page Object Model");


        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage dashBoardPage  = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashBoardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        logger.info("Done the Test cases");
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));



    }
}
