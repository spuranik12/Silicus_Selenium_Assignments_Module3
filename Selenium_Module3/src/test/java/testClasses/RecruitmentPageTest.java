package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.RecruitmentPage;
import common.BaseTest;

public class RecruitmentPageTest extends BaseTest
{
	@Test 
	public void openVacancies()
	{
		RecruitmentPage rp = new RecruitmentPage(driver); 
		rp.clickOnRecruitmentLink();
		rp.clickOnVacancyLink();
		Assert.assertTrue(rp.verifyVacancyTab());
	}
}
