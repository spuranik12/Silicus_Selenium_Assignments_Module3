package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;

public class CreateVacancyPage extends BasePage {
	
	WebElement element;
	
	@FindBy(css = "#addJobVacancy_jobTitle")
	private WebElement jobTitleField;
	
	@FindBy(css = "#addJobVacancy_name")
	private WebElement vacancyNameField;
	
	@FindBy(css = "#addJobVacancy_hiringManager")
	private WebElement hiringMgrField;
	
	@FindBy(css = "#addJobVacancy_noOfPositions")
	private WebElement numOfPositionsField;
	
	@FindBy(css = "#addJobVacancy_description")
	private WebElement descriptionField;
	
	@FindBy(css = "#addJobVacancy_publishedInFeed")
	private WebElement rssCheckBox;
	
	public CreateVacancyPage(WebDriver driver) {
		super(driver);
	}
	
	public void addJobTitle() {
		actions.applyImplicitWait(10);
		element = jobTitleField;
		Select selByVal = new Select(element);
		selByVal.selectByValue("9");
		
	}
	
	public String verifySelectedJobTitle() {
		element = jobTitleField;
		Select selByVal = new Select(element);
		System.out.println("Job Title is: " + selByVal.getFirstSelectedOption().getText());
		return selByVal.getFirstSelectedOption().getText(); 
	}
	
	public void enterVacancyName(String vacName) {
		actions.applyDefaultImplicitWait();
		vacancyNameField.sendKeys(vacName);
	}
	
	public String verifyEnteredVacName() {
		System.out.println("Entered vacancy name: " + vacancyNameField.getAttribute("value")); 
		return vacancyNameField.getAttribute("value"); 
	}
	
	public void enterHiringManager(String hiringMgr) {
		actions.applyDefaultImplicitWait();
		hiringMgrField.sendKeys(hiringMgr);
	}
	
	public String verifyEnteredHiringMgr() {
		System.out.println("Entered hiring manager is: " + hiringMgrField.getAttribute("value"));
		return hiringMgrField.getAttribute("value"); 
	}
	
	public void enterNumOfPositions(String positions) {
		actions.applyDefaultImplicitWait();
		numOfPositionsField.sendKeys(positions);
	}
	
	public String verifyNumOfPositions() {
		System.out.println("Entered number of positions: " + numOfPositionsField.getText());
		return numOfPositionsField.getText(); 
	}
}