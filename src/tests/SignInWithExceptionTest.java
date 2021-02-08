package tests;

//import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.Main1Page;
import pageobjects.MainPageBeforeSignIn;
import pageobjects.SelectLanguagePage;
import pageobjects.SignInPage;

public class SignInWithExceptionTest  extends BaseTest{
	
	@Test()
	  public void tc01_SignInTest() throws InterruptedException{
		//setup();
		driver.get("https://il.iherb.com/");		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage()	;
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSignInPage();		
		SignInPage sip=new SignInPage(driver);	
		sip.signInWithGoogle("srozen487@gmail.com","shro2020");
		//check validation test	
				
		try {
			
			Main1Page m1p=new Main1Page(driver);//enter user+password OK			
			String expected="srozen487@gmail.com";
			String actual=m1p.titleBtnSignInSignOutWelcome1();
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
		}
			
	}	
	///////////////////////////////////////////////	

	
}
