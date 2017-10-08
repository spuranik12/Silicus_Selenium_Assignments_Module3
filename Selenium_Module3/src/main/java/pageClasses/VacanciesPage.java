package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class VacanciesPage extends BasePage{
	
	@FindBy(xpath = "//h1[.='Vacancies']")
	private WebElement vacancyHeader; 
	
	@FindBy(xpath = "//input[@id='btnAdd']")
	private WebElement addVacancyBtn;
	
	public VacanciesPage(WebDriver driver) {
		super(driver);
	}

	public boolean verifyVacancyTab() {
		actions.applyImplicitWait(10);
		return vacancyHeader.isDisplayed(); 
	}
	
	public String printVacancyHeader() { 
		return vacancyHeader.getText();  
	}
	
	public void clickOnAddVacancy() {
		actions.applyImplicitWait(10);
		addVacancyBtn.click();
	}
}
