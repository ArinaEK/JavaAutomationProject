package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class Main1Page extends MenuPage{
//import org.openqa.selenium.interactions.Actions;

	@FindBy(css = ".iherb-header-account-sign-in span button") //title=signin
	private WebElement titleSignInBtn;	
	
	@FindBy(css = ".welcome-name")
	private WebElement welcomeName;	
	public Main1Page(WebDriver driver) {
		super(driver);		
	}	

	/*
	 * validation method: return texLabelWelcome
	 */

	public String titleBtnSignInSignOutWelcome1() {
	 	sleep1(2000);
		String titleBtnSignSignOut=getText(welcomeName);
		return titleBtnSignSignOut;//title=welcomeName
	}
	/*
	 * validation method: return texLabelAfterSignOut
	 */

	public String titleBtnSignInSignIn() {
	 	sleep1(3000);
		String titleBtnSignSignOut=getText(titleSignInBtn);
		return titleBtnSignSignOut;//title=SignIn
	}
}

