package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass 
{
	@DataProvider(name = "Login Authentication")
	public static Object[][] credentials(){
		return new Object[][] {{"Admin", "admin"}}; 
	}
	
	@DataProvider(name = "Vacancy Info")
	public static Object[][] VacancyInformation(){ 
		return new Object[][] {{"Assistant CEO", "Linda Anderson", "10", "Description added"}};  
	}
}
