package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.CreateVacancyPage;
import pageClasses.RecruitmentPage;
import pageClasses.VacanciesPage;
import utilities.DataProviderClass;
import common.BaseTest;

public class RecruitmentPageTest extends BaseTest
{	
	@Test(priority = 1) 
	public void openVacancies() {
		RecruitmentPage rp = new RecruitmentPage(driver);
		rp.clickOnRecruitmentLink();
		rp.clickOnVacancyLink();
		
		VacanciesPage vp = new VacanciesPage(driver);
		Assert.assertTrue(vp.verifyVacancyTab());
		//System.out.println(vp.printVacancyHeader());
		vp.clickOnAddVacancy(); 
	}
	
	@Test(dataProvider = "Vacancy Info", dataProviderClass = DataProviderClass.class,  priority = 2)
	public void addNewVacancy(String vacancyName, String hiringManager, String numOfPositions, String description) throws InterruptedException { 
		CreateVacancyPage cvp = new CreateVacancyPage(driver); 
		cvp.addJobTitle();
		Assert.assertEquals(cvp.verifySelectedJobTitle(), "CEO"); 
		
		cvp.enterVacancyName(vacancyName);
		Assert.assertEquals(cvp.verifyEnteredVacName(), "Assistant CEO");
		
		cvp.enterHiringManager(hiringManager);
		Assert.assertEquals(cvp.verifyEnteredHiringMgr(), "Linda Anderson");
		
		cvp.enterNumOfPositions(numOfPositions);
		Assert.assertEquals(cvp.verifyNumOfPositions(), "10");
		
		cvp.enterDescription(description);
		Assert.assertEquals(cvp.verifyEnteredDescription(), "Description added");
		
		cvp.uncheckRssCheckbox();
		
		cvp.saveVacancyDetails();
		Assert.assertTrue(cvp.verifyEditBtn());
		
		Thread.sleep(4000);
		cvp.goBackToVacancyList();
	}
	
	@Test(priority = 3)
	public void newVacancyData() throws InterruptedException{
		VacanciesPage vp = new VacanciesPage(driver);
		Thread.sleep(1000);
		Assert.assertEquals(vp.verifyCreatedVacancy(), "Assistant CEO");
	}
}
