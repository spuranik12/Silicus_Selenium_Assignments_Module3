package testClasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageClasses.HomePage;
import pageClasses.LoginPage;

import common.BaseTest;

public class LoginPageTest extends BaseTest
{ 
	
	@DataProvider(name = "Login Authentication")
	public static Object[][] credentials(){
		return new Object[][] {{"Admin", "admin"}}; 
	}
	
	@Test(dataProvider = "Login Authentication")
	public void loginWithValidCredentials(String uname, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginIntoApplication(uname, pwd);
		
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getLoggedInUsername());
	}
}
