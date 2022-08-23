package OrnekAddressFunctionTest;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddAddressTest extends BaseDriver {
    String expectedSuccessMessage = "Your address has been successfully added";
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;
    @Test
    public void AddressFunctionTest(){
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

        myAccountPageElements.addressBookButton.click();
        myAccountPageElements.newAddressButton.click();
        myAccountPageElements.firstNameInput.sendKeys("Aka");
        myAccountPageElements.lastNameInput.sendKeys("kkk");
        myAccountPageElements.address1Input.sendKeys("jersey");
        myAccountPageElements.cityInput.sendKeys("hackensack");
        myAccountPageElements.postalCodeInput.sendKeys("00000");
        Select select = new Select(myAccountPageElements.countryDropDown);
        select.selectByVisibleText("United States");
        Select select1 = new Select(myAccountPageElements.stateDropDown);
        select1.selectByVisibleText("New Jersey");
        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(),expectedSuccessMessage);
    }

}
