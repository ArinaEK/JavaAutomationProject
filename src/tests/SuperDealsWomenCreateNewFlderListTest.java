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

public class SuperDealsWomenCreateNewFlderListTest extends BaseTest{
//	private final String listName="MyList";
	private final String listName1="My List10";
//	private final String productName="Fairhaven Health, Nursing Time Tea, Lemon Flavor, 4 oz";	
	//private final String productName2="Schick, Intuition F.A.B., 3 Refills";
	private final String productName1="Natural Factors, WomenSense, RxOmega-3, 120 Enteripure Softgels";
	
	
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
		//add 1 product and add to created list
	    m1p.openSuperDealsPage();			
		SuperDealsPage sdp=new SuperDealsPage(driver);	
		sdp.openSuperDealsWomenProductsPage();	
		SuperDealsWomenProductsPage sdwpsp=new SuperDealsWomenProductsPage(driver);	
		sdwpsp.addToCartByChoosingProduct(productName1);//open product page
		SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);
		
		sdwpp.addToListSelect(listName1);
		
		sdwpp.openAccountListsClickListBtn();		
		SuperDealsListPage sdlp =new SuperDealsListPage(driver);
		sdlp.openListsWithProduct();//refresh
		sdlp.chooseFromSelectMyNewFolder(listName1);//My List4
		//check validatin added new list is OK
		String actual=sdlp.titleFromFolderList();
		String expected="My List5";
		Assert.assertEquals(actual,expected);
	}
	@Test(description = "add product+CreateNewFlderFromProductPage-check validation: product exists in new folder ")
		public void tc02_SuperDealsWomenCreateNewFlderFromProductPage() throws InterruptedException {	
			SuperDealsListPage sdlp =new SuperDealsListPage(driver);

			boolean actual=sdlp.IsProductExistInList(productName1);
			Assert.assertTrue(actual);
			
		}
		@Test(description = "add product+CreateNewFlderFromProductPage+add to cart-check validation: product exists in cart ")
		public void tc03_SuperDealsWomenCreateNewFlderFromProductPageAddToCart() throws InterruptedException {	
			SuperDealsListPage sdlp =new SuperDealsListPage(driver);
			sdlp.addProductFromListToCart(productName1);
			sdlp.openCart();
			SuperDealsCartPage sdcp=new SuperDealsCartPage(driver);
			//check validation	product added to cart	
			boolean actual=sdcp.IsProductExistInCart(productName1);
		    Assert.assertTrue(actual);	
		    
		}
		
	/*	@Test(description = "addToCatrBychoosing+add to list-check validation: product is in list;")
			public void tc04_addToListByChoosingProduct() throws InterruptedException {		
			driver.close();
			setup();
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
			//add 1 product to list
			Main1Page m1p=new Main1Page(driver);
			m1p.openSuperDealsPage();			
			SuperDealsPage sdp=new SuperDealsPage(driver);	
			sdp.openSuperDealsWomenProductsPage();	
			SuperDealsWomenProductsPage sdwpsp=new SuperDealsWomenProductsPage(driver);	
			sdwpsp.addToCartByChoosingProduct(productName);//open product page
			SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);	
			sdwpp.addProductToList(listName);
			//check product 1 in list page
			sdwpp.openAccountListsClickListBtn();		
			SuperDealsListPage sdlp =new SuperDealsListPage(driver);
			sdlp.openListsWithProduct();
			//check validation		
			boolean actual=sdlp.IsProductExistInList(productName);
			Assert.assertTrue(actual);
			
		}

			@Test(description = "addToCatrBychoosing+add to list+move to cart-check validation: product is in cart")
			public void tc05_addToListByChoosingProduct_moveTocART() throws InterruptedException {	
				driver.close();
				setup();
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
				//add 1 product to list
				Main1Page m1p=new Main1Page(driver);
				m1p.openSuperDealsPage();			
				SuperDealsPage sdp=new SuperDealsPage(driver);	
				sdp.openSuperDealsWomenProductsPage();	
				SuperDealsWomenProductsPage sdwpsp=new SuperDealsWomenProductsPage(driver);	
				sdwpsp.addToCartByChoosingProduct(productName1);//open product page
				SuperDealsWomenProductPage sdwpp=new SuperDealsWomenProductPage(driver);	
				sdwpp.addProductToList(listName);
				//check product 1 in list page
				sdwpp.openAccountListsClickListBtn();		
				SuperDealsListPage sdlp =new SuperDealsListPage(driver);
				sdlp.openListsWithProduct();
				//add product to cart
				sdlp.addProductFromListToCart(productName1);
				sdlp.openCart();
				SuperDealsCartPage sdcp=new SuperDealsCartPage(driver);
				//check validation	product added to cart	
				boolean actual=sdcp.IsProductExistInCart(productName1);
			    Assert.assertTrue(actual);		
			   //driver.close();
			}*/
}
			


