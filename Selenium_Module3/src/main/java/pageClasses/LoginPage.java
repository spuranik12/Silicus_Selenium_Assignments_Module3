package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class LoginPage extends BasePage{
	@FindBy(css = "#txtUsername")
	private WebElement usernameField;
	
	@FindBy(css = "#txtPassword")
	private WebElement passwordField; 
	
	@FindBy(css = "#btnLogin")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	public void loginIntoApplication(String username, String password){
		actions.applyDefaultImplicitWait();
		usernameField.sendKeys(username);
		actions.applyDefaultImplicitWait();
		passwordField.sendKeys(password); 
		actions.waitElementToBeClickable(loginBtn, 5);
		loginBtn.click();
	}
}
