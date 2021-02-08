package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.MainPageBeforeSignIn;
import pageobjects.SelectLanguagePage;
import pageobjects.SuperDealsCartPage;
import pageobjects.SuperDealsPage;
import pageobjects.SuperDealsWomenProductPage;
import pageobjects.SuperDealsWomenProductsPage;

public class SuperDealsWomenAddToCartTEST extends BaseTest{
	private final String productName="Schick, Intuition F.A.B., 3 Refills";
//	private final String productName1="Now Foods, Libido Fem, 60 Veggie Caps";
	private final String productName2="Fairhaven Health, Nursing Time Tea, Lemon Flavor, 4 oz";	
	@Test(description = "addToCatrByButtonn-check validation: count in Btn=1;")
	public void tc01_addToCatrByButton() throws InterruptedException {		
		driver.get("https://il.iherb.com");		
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
	
		//double beforeCount=sdwpsp.productCountLabel();//7.12
		double beforeCount=0;//7.12
		System.out.println(beforeCount);
		//check validation
		sdwpsp.addToCartByBtn(productName);
		double afterCount=sdwpsp.productCountLabel();
		System.out.println(afterCount);
		Assert.assertEquals(afterCount, beforeCount+1);
		driver.close();

	}

	@Test(description = "addToCatrByChoosingProduct-check validation: count in Btn=+q")
	public void tc02_addToCatrByChoosingProduct() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com");	
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
		//double beforeCount=sdwpsp.productCountLabel();     //from menupage
		double beforeCount=0;//7.12
				
		sdwpsp.addToCartByChoosingProduct(productName);
		SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName,5);
		//check validation
		double afterCount=sdwpp.productCountLabel();   //from menupage
		Assert.assertEquals(afterCount, beforeCount+5);	
		driver.close();
	}
	@Test(description = "addToCart 2 products ByChoosing-check validation: productName is exists in cart")
	public void tc03_add2ProductsToCartByChoosingProduct() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com");	
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
		//add1
		sdwpsp.addToCartByChoosingProduct(productName);
		SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName,5);
		driver.navigate().back();//return to sdwpsp
		//add2
		sdwpsp.addToCartByChoosingProduct(productName2);
		sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName2,2);
		driver.navigate().back();//return to sdwpsp
		
		//check validation
		sdwpsp=new SuperDealsWomenProductsPage(driver);
		sdwpsp.openCart();
		SuperDealsCartPage sdcp=new SuperDealsCartPage(driver);
		 //check validation
		boolean actual=sdcp.IsProductExistInCart(productName2);	
		//sdcp.IsProductExistInCart(productName);
		Assert.assertTrue(actual);
		driver.close();
		
	}
	@Test(description = "update quantity in exist product after added-check validation: product count changed")
	public void tc04_updateQuantityAfterAddToCatrByChoosingProduct() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com");	
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
		//add productName1
		sdwpsp.addToCartByChoosingProduct(productName);
		SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName,5);
		driver.navigate().back();//return to sdwpsp
		//add productName2
		sdwpsp.addToCartByChoosingProduct(productName2);
		sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName2,2);
		driver.navigate().back();//return to sdwpsp

		//update productName1: 2+4
		
		sdwpsp=new SuperDealsWomenProductsPage(driver);
	    double beforeCount=sdwpsp.productCountLabel();
		sdwpsp.openCart();
		SuperDealsCartPage sdcp=new SuperDealsCartPage(driver);
		sdcp.ChooseProductToUpdate(productName2);//choose product to update
		
		sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName2,4);//update quantity in chosen product
		//and return to women product page
		
		//check validation		
		sdwpp=new SuperDealsWomenProductPage(driver);
		double afterCount=sdwpp.productCountLabel();
		Assert.assertEquals(afterCount, beforeCount+4);	
		driver.close();
	}
	
	@Test(description = "remove exist product after added-check validation: product removed")
	public void tc05_removeAfterAddToCatrByChoosingProduct() throws InterruptedException {
		setup();
		driver.get("https://il.iherb.com");	
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
		//add productName
		sdwpsp.addToCartByChoosingProduct(productName);
		SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName,5);
		driver.navigate().back();//return to sdwpsp
		//add productName2
		sdwpsp.addToCartByChoosingProduct(productName2);
		sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName2,2);
		driver.navigate().back();//return to sdwpsp

		//remove productName: 		
		sdwpsp=new SuperDealsWomenProductsPage(driver);
		sdwpsp.openCart();
		SuperDealsCartPage sdcp=new SuperDealsCartPage(driver);
		sdcp.removeFromCart(productName);//return to women products page
		//check validation
		sdwpsp=new SuperDealsWomenProductsPage(driver);
		sdcp=new SuperDealsCartPage(driver);
		boolean actualExist=sdcp.IsProductExistInCart(productName);
		Assert.assertFalse(actualExist);
		driver.close();
	}

	@Test(description = "remove exist product after added-check validation: quantity was changed")
	public void tc06_removeAfterAddToCatrByChoosingProduct() throws InterruptedException {
		
		setup();
		driver.get("https://il.iherb.com");	
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
		//add productName
		sdwpsp.addToCartByChoosingProduct(productName);
		SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName,5);
		driver.navigate().back();//return to sdwpsp
		//add productName1
		sdwpsp.addToCartByChoosingProduct(productName2);
		sdwpp=new SuperDealsWomenProductPage(driver);
		sdwpp.addProductToCart(productName2,2);
		driver.navigate().back();//return to sdwpsp

		//remove productName1: 		
		sdwpsp=new SuperDealsWomenProductsPage(driver);
		sdwpsp.openCart();
		SuperDealsCartPage sdcp=new SuperDealsCartPage(driver);
		double beforeCount=sdcp.productCountLabel();
		sdcp.removeFromCart(productName);//return to women products page
		//check validation
		double afterCount=sdcp.productCountLabel();
		Assert.assertEquals(afterCount, beforeCount-5);
		driver.close();
	}	
}
