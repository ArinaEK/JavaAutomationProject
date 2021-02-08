package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePage {

	@FindBy(css = ".back-to-sign-in a")
	private WebElement backToSignIndBtn;	
	@FindBy(css = "#username_reset_password>#username_input")
	private WebElement emailField;	
	@FindBy(css = "#password_reset_form > div:nth-child(1) > h2")
	private WebElement titlePage;	

	//2	
	public ResetPasswordPage(WebDriver driver) {
		super(driver);
	}

	public String titleResetPassword() {
	 	sleep1(2000);
	 	String texMessageResetPassword=getText(titlePage);
		System.out.println(texMessageResetPassword);
		return texMessageResetPassword;
	}	
	/*
	 * Back to Sign In Page
	 */
	public void backToSignInPage() {	
		sleep1(2000);	
		click(backToSignIndBtn);
	}
	
}