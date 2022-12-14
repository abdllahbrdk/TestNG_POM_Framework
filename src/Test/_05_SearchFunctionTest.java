package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _05_SearchFunctionTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    @Parameters({"searchItem"})
    public void searchFunction(String searchItem){
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

        homePageElements.yourStoreButton.click();

        homePageElements.searchInput.sendKeys(searchItem);
        homePageElements.searchbutton.click();

        for (int i = 0; i < homePageElements.searchResultItems.size(); i++) {
            String elementText = homePageElements.searchResultItems.get(i).getText().toLowerCase();
            Assert.assertTrue(elementText.contains(searchItem.toLowerCase()));
        }
    }
}
