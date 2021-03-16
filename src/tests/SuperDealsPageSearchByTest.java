package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.MainPageBeforeSignIn;
import pageobjects.SelectLanguagePage;
import pageobjects.SuperDealsPage;

public class SuperDealsPageSearchByTest extends BaseTest{
	@Test(description = "after search open only   Revlon brend +check validation:")
	public void tc01_SearhBranchNameTest() throws InterruptedException {
		driver.get("https://il.iherb.com");		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSuperDealsPage();		
		SuperDealsPage sdp=new SuperDealsPage(driver);		
		//search
		sdp.searchBrandsName("Revlon");
		//check validation
		sdp=new SuperDealsPage(driver);	
		boolean actual=sdp.isBrandsExist("Revlon");
		Assert.assertTrue(actual);
		driver.close();

	}
	@Test(description = "open list all name of category that contains Baby+check validation:")
	public void tc02_SearhCategoryNameTest() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com/");
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSuperDealsPage();		
		SuperDealsPage sdp=new SuperDealsPage(driver);
		//search
		sdp.searchCategoryName("Vitamins");
		sdp=new SuperDealsPage(driver);
		
		//check validation		
		boolean actual=sdp.isCategoryExist("Vitamins");
		Assert.assertTrue(actual);	
		driver.close();
	}

}
