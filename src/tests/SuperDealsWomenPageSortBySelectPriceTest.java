package tests;

//import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainPageBeforeSignIn;
import pageobjects.SelectLanguagePage;
import pageobjects.SuperDealsPage;
import pageobjects.SuperDealsWomenProductsPage;
import pageobjects.SuperDealsWomenSortedBySelectPricePage;
import org.openqa.selenium.NoSuchElementException;
public class SuperDealsWomenPageSortBySelectPriceTest extends BaseTest{
	@Test(description = "sort by SelectPrice +check validation:")
	public void tc01_SortBySelectPriceTest() throws InterruptedException {		
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
		
		sdwpsp.openWomenProductsAfterSortBySelectPrice("Price: Low to High");
		//check validation
		
		SuperDealsWomenSortedBySelectPricePage sdwsp=new SuperDealsWomenSortedBySelectPricePage(driver);
		boolean actual=sdwsp.isCheckSortedPriceAfterSortByPriceLowToHigh1();
		try {
		Assert.assertTrue(actual);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Error ");
		}	
		driver.close();
	}

}
