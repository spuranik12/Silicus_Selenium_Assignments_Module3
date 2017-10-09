package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePage;
import pageClasses.LoginPage;
import utilities.DataProviderClass;
import common.BaseTest;

public class LoginPageTest extends BaseTest
{ 
	
	@Test(dataProvider = "Login Authentication", dataProviderClass = DataProviderClass.class)
	public void loginWithValidCredentials(String uname, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginIntoApplication(uname, pwd);
		
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getLoggedInUsername());
	}
}
