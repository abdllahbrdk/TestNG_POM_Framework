package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _06_ContactUsFunctionTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;
    @Test
    @Parameters("enquiry")
    public void contactUsTest(String enquiry){
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("ka@gmail.com");
        loginPageElements.passwordInput.sendKeys("123456");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();
        Assert.assertEquals(myAccountHeaderText,"My Account");

        homePageElements.contactUsButton.click();
        homePageElements.enquiryInput.sendKeys(enquiry);
        homePageElements.submitButton.click();

        String currentURl = driver.getCurrentUrl();
        Assert.assertTrue(currentURl.contains("success"));

    }
}
