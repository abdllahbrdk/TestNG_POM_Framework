package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {
    public HomePageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="a[title='My Account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginButton;

    @FindBy(css = "input[name='search']")
    public WebElement searchButton;

    @FindAll({@FindBy(css = "div[class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']")})
    public List<WebElement> macSearchResults;

    @FindBy(xpath = "//a[text()='Your Store']")
    public WebElement yourStoreButton;

    @FindBy(css = "input[name='search']")
    public WebElement searchInput;

    @FindBy(css = "button[class='btn btn-default btn-lg']")
    public WebElement searchbutton;

   @FindAll({@FindBy(xpath = "//h4")})
    public List<WebElement> searchResultItems;

   @FindBy(xpath = "//a[text()='Contact Us']")
    public WebElement contactUsButton;

   @FindBy(id = "input-enquiry")
    public WebElement enquiryInput;

   @FindBy(css = "input[value='Submit']")
    public WebElement submitButton;

}
