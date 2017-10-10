package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import common.BasePage;

public class CreateVacancyPage extends BasePage {
	
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
	
	@FindBy(css = "#btnSave")
	private WebElement saveBtn;
	
	@FindBy(css = "[value=Edit]")
	private WebElement editBtn;
	
	@FindBy(css = "#btnBack")
	private WebElement backBtn;
	
	public CreateVacancyPage(WebDriver driver) {
		super(driver);
	}
	
	Select selByVal = new Select(jobTitleField);
	
	public void addJobTitle() {
		actions.applyImplicitWait(10);
		selByVal.selectByValue("9");
	}
	
	public String verifySelectedJobTitle() {
		//System.out.println("Job Title is: " + selByVal.getFirstSelectedOption().getText());
		return selByVal.getFirstSelectedOption().getText(); 
	}
	
	public void enterVacancyName(String vacName) {
		actions.applyDefaultImplicitWait();
		vacancyNameField.sendKeys(vacName);
	}
	
	public String verifyEnteredVacName() {
		//System.out.println("Entered vacancy name: " + vacancyNameField.getAttribute("value")); 
		return vacancyNameField.getAttribute("value"); 
	}
	
	public void enterHiringManager(String hiringMgr) {
		actions.applyDefaultImplicitWait();
		hiringMgrField.sendKeys(hiringMgr);
	}
	
	public String verifyEnteredHiringMgr() {
		//System.out.println("Entered hiring manager is: " + hiringMgrField.getAttribute("value"));
		return hiringMgrField.getAttribute("value"); 
	}
	
	public void enterNumOfPositions(String positions) {
		actions.applyDefaultImplicitWait();
		numOfPositionsField.sendKeys(positions);
	}
	
	public String verifyNumOfPositions() {
		//System.out.println("Entered number of positions: " + numOfPositionsField.getAttribute("value"));
		return numOfPositionsField.getAttribute("value"); 
	}
	
	public void enterDescription(String description){
		actions.applyDefaultImplicitWait();
		descriptionField.sendKeys(description);
	}
	
	public String verifyEnteredDescription(){
		//System.out.println("Description entered is: " + descriptionField.getAttribute("value"));
		return descriptionField.getAttribute("value"); 
	}
	
	public void uncheckRssCheckbox(){
		actions.applyDefaultImplicitWait();
		rssCheckBox.click();
	}
	
	public void saveVacancyDetails(){
		actions.applyDefaultImplicitWait();
		saveBtn.click();
	}
	
	public boolean verifyEditBtn(){
		actions.applyImplicitWait(10);
		//System.out.println("Edit button displayed: " + editBtn.isDisplayed());
		return editBtn.isDisplayed();
	}
	
	public void goBackToVacancyList(){
		backBtn.click();
	}
}
