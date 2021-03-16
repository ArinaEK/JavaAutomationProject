package tests;

import org.testng.annotations.Test;
//import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pageobjects.MainPageBeforeSignIn;
import pageobjects.SelectLanguagePage;
public class MainPageChangeLanguageCurrencyShippingTest  extends BaseTest{
	//open chrom
	@Test(description="MainPageChangeLanguageTest to English")
	public void tc01_MainPageChangeLanguageTest() throws InterruptedException{
		
		driver.get("https://il.iherb.com/");
		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();	
		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");		
		//try {
		//check validation test		: LANGUAGE WAS CHENGED	
//		try {
			mp=new MainPageBeforeSignIn(driver);
			String actualTextLangBtn=mp.titleBtnlSelectLanguage();					
			String expectedTextLangBtn="EN";
			Assert.assertEquals(actualTextLangBtn, expectedTextLangBtn);
//		} catch (AssertionError  e) {
//			// TODO Auto-generated catch block
//			System.out.println("Error password");
//		}
			
	}
	@Test(description="MainPageChangeCurrencyTest to USD")
	public void tc02_MainPageChangeCurrencyTest() throws InterruptedException{
		
		driver.get("https://il.iherb.com/");	
		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		String actualTextLangBtn=mp.titleBtnlSelectCurrency();
		String expectedTextLangBtn="USD";
		Assert.assertEquals(actualTextLangBtn, expectedTextLangBtn);	
	}
	@Test(description="MainPageChangeShippingCountryTest to IL")
	public void tc03_MainPageChangeShippinkCountryTest() throws InterruptedException{
		
		driver.get("https://il.iherb.com/");		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		//check validation test		: ShippingCountry WAS CHENGED
		String actualTextLangBtn=mp.titleBtnlSelectShippingCountry();
		String expectedTextLangBtn="IL";
		Assert.assertEquals(actualTextLangBtn, expectedTextLangBtn);	
	}
		
}