package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.MainPageBeforeSignIn;
import pageobjects.SelectLanguagePage;
import pageobjects.SuperDealsPage;
import pageobjects.SuperDealsWomenFilterPriceInputRangePage;
import pageobjects.SuperDealsWomenFilterPriceRange3Page;
import pageobjects.SuperDealsWomenProductsPage;

public class SuperDealsWomenFiltersTest extends BaseTest{
	@Test(description = "open SuperDealsWomenFilterInputPrice+check validation:")
	public void tc01_FilterInputPriceFromToTest() throws InterruptedException {
		driver.get("https://il.iherb.com");		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSuperDealsPage();		
		SuperDealsPage sdp=new SuperDealsPage(driver);		
		sdp.closeAdvertisement();
		sdp.openSuperDealsWomenProductsPage();	//open women
		SuperDealsWomenProductsPage sdwpsp=new SuperDealsWomenProductsPage(driver);
		
		sdwpsp.openfiltersOfPrice1();
		sdwpsp.openSuperDealsWomenProductsAfterFilterInputPriceRangePage(10, 15);
		
		SuperDealsWomenFilterPriceInputRangePage sdwPriceInputRangP=new SuperDealsWomenFilterPriceInputRangePage(driver);
		sdwPriceInputRangP.openSuperDealsPage();
		//check validation		
		boolean actual=sdwPriceInputRangP.IsPriceInRange(10, 15);
		Assert.assertTrue(actual);
		driver.close();

	}
	@Test(description = "open SuperDealsWomenFiltersPriceRange3+check validation:")
	public void tc02_FilterPriceRange3Test() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com/");
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSuperDealsPage();		
		SuperDealsPage sdp=new SuperDealsPage(driver);
		sdp.closeAdvertisement();
		sdp.openSuperDealsWomenProductsPage();	//0pen women
		SuperDealsWomenProductsPage sdwpsp=new SuperDealsWomenProductsPage(driver);
		
		sdwpsp.openfiltersOfPrice1();
		
		sdwpsp.openSuperDealsWomenFilterPriceRange3();///10-20
		
		//check validation
		SuperDealsWomenFilterPriceRange3Page sdwPriceRange3=new SuperDealsWomenFilterPriceRange3Page(driver);
		boolean actual=sdwPriceRange3.IsPriceInRange();
		Assert.assertTrue(actual);	
		driver.close();
	}
	@Test(description = "open SuperDealsWomenFiltersPriceRange3+delete filter Range3")
	public void tc03_DeleteFilterPriceRange3Test() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com/");
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSuperDealsPage();		
		SuperDealsPage sdp=new SuperDealsPage(driver);
		sdp.closeAdvertisement();
		sdp.openSuperDealsWomenProductsPage();	
		SuperDealsWomenProductsPage sdwp=new SuperDealsWomenProductsPage(driver);
		
		sdwp.openfiltersOfPrice1();
		
		sdwp.openSuperDealsWomenFilterPriceRange3();///10-20
		SuperDealsWomenFilterPriceRange3Page sdwPriceRange3=new SuperDealsWomenFilterPriceRange3Page(driver);
		//delete
		sdwPriceRange3.DeleteFilterPriceRange3("$10 - $20");
		sdwp=new SuperDealsWomenProductsPage(driver);
		//check validation-after deleting filter(expectedTitle) - return title current page(Women)
		String actualTitle=sdwp.superDealsWomenLabel();
		System.out.println(actualTitle);
		String expectedTitle="Women";
		System.out.println(expectedTitle);
		Assert.assertEquals(actualTitle,expectedTitle);
		driver.close();
	}
	@Test(description = "open SuperDealsWomenFiltersPriceRange3+clear all filters")
	public void tc04_DeleteFilterPriceRange3ClearAllFiltersTest() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com/");
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSuperDealsPage();		
		SuperDealsPage sdp=new SuperDealsPage(driver);	
		
		sdp.closeAdvertisement();
		sdp.openSuperDealsWomenProductsPage();	
		SuperDealsWomenProductsPage sdwpsp=new SuperDealsWomenProductsPage(driver);
		
		sdwpsp.openfiltersOfPrice1();
		
		sdwpsp.openSuperDealsWomenFilterPriceRange3();///10-20
		SuperDealsWomenFilterPriceRange3Page sdwPriceRange3=new SuperDealsWomenFilterPriceRange3Page(driver);
		//delete
		sdwPriceRange3.ClearAllFilters();
		sdwpsp=new SuperDealsWomenProductsPage(driver);
		driver.close();
	}
}
