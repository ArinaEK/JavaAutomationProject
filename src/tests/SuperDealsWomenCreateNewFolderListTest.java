package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Main1Page;
import pageobjects.MainPageBeforeSignIn;
import pageobjects.SelectLanguagePage;
import pageobjects.SignInPage;
import pageobjects.SuperDealsCartPage;
import pageobjects.SuperDealsListPage;
import pageobjects.SuperDealsPage;
import pageobjects.SuperDealsWomenProductPage;
import pageobjects.SuperDealsWomenProductsPage;

public class SuperDealsWomenCreateNewFolderListTest extends BaseTest{
	//private final String listName1="My List1";
	private final String listName="My List";

	private final String productName2="Hyperbiotics, PRO-Women, 5 Billion CFU, 30 Time-Release Tablets";
	private final String productName1="Promensil, Menopause, Double Strength, 30 Tablets";
	
	
	@Test(description = "add product+CreateNewFlderFromProductPage-check validation: new folder list is in list;")
	public void tc01_SuperDealsWomenCreateNewFlderFromProductPage() throws InterruptedException {		
		driver.get("https://il.iherb.com");		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		//change language
		mp.openSelectLanguage();		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		//sign in
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSignInPage();		
		SignInPage sip=new SignInPage(driver);	
		sip.signInWithGoogle("srozen487@gmail.com","shro2020");		
		Main1Page m1p=new Main1Page(driver);		
		//add product1 and add to  list "My List"
	    m1p.openSuperDealsPage();			
		SuperDealsPage sdp=new SuperDealsPage(driver);	
		sdp.openSuperDealsWomenProductsPage();	
		SuperDealsWomenProductsPage sdwpsp=new SuperDealsWomenProductsPage(driver);	
		
		sdwpsp.openWomenProductsAfterSortBySelectPrice("Price: Low to High");
		
		sdwpsp.addToCartByChoosingProduct(productName1);//open product page
		SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);
					
		sdwpp.addProductToList(listName);
		sdwpp.openAccountListsClickListBtn();	//refresh1	
		SuperDealsListPage sdlp =new SuperDealsListPage(driver);//wish list page

		//add product2 and add to created list "My List"
		sdlp.openSuperDealsPage();
		sdp=new SuperDealsPage(driver);	
		sdp.openSuperDealsWomenProductsPage();	
		sdwpsp=new SuperDealsWomenProductsPage(driver);	
		
		sdwpsp.openWomenProductsAfterSortBySelectPrice("Price: Low to High");
		
		sdwpsp.addToCartByChoosingProduct(productName2);//open product page
		sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToList(listName);
		sdwpp.openAccountListsClickListBtn();	//refresh1	
		sdlp =new SuperDealsListPage(driver);//wish list page
		
		//add all  products to cart
		sdlp.addProductFromListToCart();
		sdlp.openCart();
		SuperDealsCartPage sdcp=new SuperDealsCartPage(driver);
		//check validation 2	products added to cart	
		double beforeCount=0;
		double afterCount=sdcp.productCountLabel();   //from menupage
		Assert.assertEquals(afterCount, beforeCount+2);	
		//driver.close();
	}

}
			


