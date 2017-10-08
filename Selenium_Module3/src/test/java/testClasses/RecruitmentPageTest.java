package testClasses;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageClasses.CreateVacancyPage;
import pageClasses.RecruitmentPage;
import pageClasses.VacanciesPage;
import common.BaseTest;

public class RecruitmentPageTest extends BaseTest
{
	@DataProvider(name = "Vacancy Info")
	public static Object[][] credentials(){
		return new Object[][] {{"Assistant CEO", "Linda Anderson", "10"}};  
	}
	
	@Test(priority = 1) 
	public void openVacancies() {
		RecruitmentPage rp = new RecruitmentPage(driver);
		rp.clickOnRecruitmentLink();
		rp.clickOnVacancyLink();
		
		VacanciesPage vp = new VacanciesPage(driver);
		Assert.assertTrue(vp.verifyVacancyTab());
		System.out.println(vp.printVacancyHeader());
		vp.clickOnAddVacancy(); 
	}
	
	@Test(dataProvider = "Vacancy Info", priority = 2)
	public void addNewVacancy(String vacancyName, String hiringManager, String numOfPositions) { 
		CreateVacancyPage cvp = new CreateVacancyPage(driver); 
		cvp.addJobTitle();
		Assert.assertEquals(cvp.verifySelectedJobTitle(), "CEO"); 
		
		cvp.enterVacancyName(vacancyName);
		Assert.assertEquals(cvp.verifyEnteredVacName(), "Assistant CEO");
		
		cvp.enterHiringManager(hiringManager);
		Assert.assertEquals(cvp.verifyEnteredHiringMgr(), "Linda Anderson");
		
		cvp.enterHiringManager(numOfPositions);
		Assert.assertEquals(cvp.verifyNumOfPositions(), "10");
	}
}
