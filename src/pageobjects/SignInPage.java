package pageobjects;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

	@FindBy(css = " div:nth-child(3) > a > span.title")
	private WebElement signInWithGoogleBtn;
	
	@FindBy(css = "[type='email']")
	private WebElement emailField;	
	@FindBy(css = "#identifierNext")
	private WebElement nextNameBtn;
	
	@FindBy(css = "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
	private WebElement passwordlField;
	@FindBy(css = "#passwordNext")
	private WebElement nextPasswordBtn;
	
	@FindBy(css = ".Lth2jb > div > div:nth-child(2)")
	private WebElement titleFromGooglePageAfterErrPass;//element with google title: errPasswPage
	
	@FindBy(css = "[data-ga-event-label='Forgot Password']")
	private WebElement forgotPasswordBtn;
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * Sign In with google- OK
	 */
	public void signInWithGoogle(String email,String pass) {		
		sleep1(5000);
		//main page- iherb page
		//click button google sign in
		click(signInWithGoogleBtn);
		//save main:iherb 
		String main=getDriver().getWindowHandle();//main has a last open window
		//move to google window1
		Set<String> list=getDriver().getWindowHandles();//list of all open windows name
		for (String win:list) {
			getDriver().switchTo().window(win);//return name of last open window			
		}
		//do in google window1
		getDriver();
		fillText(emailField, email);
		click(nextNameBtn);
		
		//move to google window2
		Set<String> list1=getDriver().getWindowHandles();//list of all open windows name
		for (String win:list1) {
			getDriver().switchTo().window(win);//return name of last open window			
		}
		//do in google window2
		getDriver();
		fillText(passwordlField, pass);
		click(nextPasswordBtn);
		
		sleep1(2000);	
		//close google page-was closed automatically
		//getDriver().close();
		getDriver().switchTo().window(main);
	}
	
	/*
	 * Sign In with google- Error
	 */
	public String signInWithGoogleError(String email,String pass) {		
		sleep1(2000);
		//main page- iherb page
		//click button google sign in
		click(signInWithGoogleBtn);
		//save main:iherb 
		String main=getDriver().getWindowHandle();//main has a last open window
		//move to google window1
		Set<String> list=getDriver().getWindowHandles();//list of all open windows name
		for (String win:list) {
			getDriver().switchTo().window(win);//return name of last open window			
		}
		//do in google window1
		getDriver();
		fillText(emailField, email);
		click(nextNameBtn);
		
		//move to google window2
		Set<String> list1=getDriver().getWindowHandles();//list of all open windows name
		for (String win:list1) {
			getDriver().switchTo().window(win);//return name of last open window			
		}
		//do in google window2
		getDriver();
		fillText(passwordlField, pass);
		click(nextPasswordBtn);
		
		sleep1(2000);
		String errTitle=getText(titleFromGooglePageAfterErrPass);			
		//close google page-was closed automatically
		//getDriver().close();
		getDriver().switchTo().window(main);
		return errTitle;
	}
	
	public void forgotPassword() {		
		click(forgotPasswordBtn);
	}
}