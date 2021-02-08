package tests;

//import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Main1Page;
import pageobjects.MainPageBeforeSignIn;
import pageobjects.ResetPasswordPage;
import pageobjects.SelectLanguagePage;
import pageobjects.SignInPage;

public class MainPageSignInTest extends BaseTest{
	@Test(description = "SignInWithGoogle+return to main page+check validation")
	public void tc01_SignInWithGoogleTest() throws InterruptedException {
		driver.get("https://il.iherb.com/");		
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();
		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		
		
		
		
		mp.openSignInPage();		
		SignInPage sip=new SignInPage(driver);	
		sip.signInWithGoogle("srozen487@gmail.com","shro2020");	
		//check validation test	
		Main1Page m1p=new Main1Page(driver);
		//String actualLabelTextMyAccountName=m0p.titleBtnAccount();
		String actualLabelTextMyAccountName=m1p.titleBtnSignInSignOutWelcome1();
		String expectedLabelTextMyAccountName="srozen487@gmail.com";	
		Assert.assertEquals(actualLabelTextMyAccountName,expectedLabelTextMyAccountName);
	}
	@Test(description = "SignInWithGoogle+SignOut++check validation")
	public void tc02_SignOutTest() throws InterruptedException {
		Main1Page m1p=new Main1Page(driver);
		m1p.openAccountListsClickSignOutBtn();
		m1p=new Main1Page(driver);
		//check validation test:update label to sign in
		String actualLabelTextBtn=m1p.titleBtnSignInSignIn();
		String expectedLabelTextMyAccountName="Sign In";		
		Assert.assertEquals(actualLabelTextBtn,expectedLabelTextMyAccountName);		
	}
	@Test(description = "forgot password link+ validation")
	public void tc03_ForgotPasswordTest() throws InterruptedException {
		driver.close();
		setup();
		driver.get("https://il.iherb.com/");	
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();
		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSignInPage();		
		SignInPage sip=new SignInPage(driver);			
		sip.forgotPassword();
		ResetPasswordPage rpp=new ResetPasswordPage(driver);				
		//check validation
		String actualTextMessage=rpp.titleResetPassword();
		String expectedTextMessage="Reset Password";	
		Assert.assertEquals(actualTextMessage, expectedTextMessage);
		rpp.backToSignInPage();
		sip=new SignInPage(driver);	
		
		//driver.close();
	}
	
	@Test(dataProvider="getData",description = "logInWithGoogle+check validation")
		public void tc04_SignInWithGoogleDD(String user,String password) throws InterruptedException {
		driver.close();
		setup();
		driver.get("https://il.iherb.com/");	
		MainPageBeforeSignIn mp=new MainPageBeforeSignIn(driver);
		mp.openSelectLanguage();
		
		SelectLanguagePage slp=new SelectLanguagePage(driver);
		slp.selectLanguageCurrencyCountry("English","USD","Israel");
		mp=new MainPageBeforeSignIn(driver);
		mp.openSignInPage();		
		SignInPage sip=new SignInPage(driver);	
		
		sip.signInWithGoogle(user,password);	
		//check validation test	
		Main1Page m1p=new Main1Page(driver);
		//String actualLabelTextMyAccountName=m0p.titleBtnAccount();
		String actualLabelTextMyAccountName=m1p.titleBtnSignInSignOutWelcome1();
		String expectedLabelTextMyAccountName="srozen487@gmail.com";	
		Assert.assertEquals(actualLabelTextMyAccountName,expectedLabelTextMyAccountName);
		driver.close();
		}
		
		@DataProvider
		public Object[][] getData(){
			Object[][] data1= {
					{"srozen487@gmail.com",""},
					{"srozen487@gmail.com","shro2022"},
					{"srozen487@gmail.com","shro2020"},
			};return data1;
		}
		
}
