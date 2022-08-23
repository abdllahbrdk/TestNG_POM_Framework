package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_AddressBookFunctionTest extends BaseDriver {
    String expectedMessageAddNewAddress ="Your address has been successfully added";
    String expectedMessageEditTest ="Your address has been successfully updated";
    String expectedMessageDeleteTest ="Your address has been successfully deleted";

    MyAccountPageElements myAccountPageElements;
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;

    @Test(priority = 1)
    public void addNewAddressTest(){
        myAccountPageElements = new MyAccountPageElements(driver);
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

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

        myAccountPageElements.firstNameInput.sendKeys("apo");
        myAccountPageElements.lastNameInput.sendKeys("ka");
        myAccountPageElements.address1Input.sendKeys("hackensack");
        myAccountPageElements.cityInput.sendKeys("hackensack");
        myAccountPageElements.postalCodeInput.sendKeys("07601");

        Select select = new Select(myAccountPageElements.countryDropDown);
        select.selectByVisibleText("United States");

        Select select1 = new Select(myAccountPageElements.stateDropDown);
        select1.selectByVisibleText("New Jersey");

        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(),expectedMessageAddNewAddress);
    }
    @Test(dependsOnMethods = "addNewAddressTest")
    public void editAddressTest(){
        myAccountPageElements = new MyAccountPageElements(driver);
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

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

        int editButtonListSize = myAccountPageElements.editButtonList.size();
        myAccountPageElements.editButtonList.get(editButtonListSize-1).click();

        myAccountPageElements.address1Input.clear();
        myAccountPageElements.address1Input.sendKeys("450 Winterfell Road");

        myAccountPageElements.continueButton.click();
        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(),expectedMessageEditTest);

    }
    @Test(dependsOnMethods = "editAddressTest")
    public void deleteAddressTest(){
        myAccountPageElements = new MyAccountPageElements(driver);
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("ka@gmail.com");
        loginPageElements.passwordInput.sendKeys("123456");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText, "My Account");

        myAccountPageElements.addressBookButton.click();

        int deleteButtonListSize = myAccountPageElements.deleteButtonsList.size();
        myAccountPageElements.deleteButtonsList.get(deleteButtonListSize - 1).click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessageDeleteTest);

    }

}
