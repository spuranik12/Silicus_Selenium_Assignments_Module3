package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class RecruitmentPage extends BasePage{
	@FindBy(xpath = "//b[.='Recruitment']")
	private WebElement recruitmentLink;
	
	@FindBy(xpath = "//a[.='Vacancies']")
	private WebElement vacancyLink;
	
	public RecruitmentPage(WebDriver driver){
		super(driver);
	}
	
	public void clickOnRecruitmentLink() {
		actions.applyDefaultImplicitWait();
		recruitmentLink.click();
	}
	
	public void clickOnVacancyLink(){
		actions.applyDefaultImplicitWait();
		vacancyLink.click();
	}
}
