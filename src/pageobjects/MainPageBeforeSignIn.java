package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.interactions.Actions;


public class MainPageBeforeSignIn extends MenuPage {
	@FindBy(css = ".language-select.hidden-xs.hidden-sm")
	private WebElement mainLanguageSelectBtn;
	
	@FindBy(css = ".currency-select.hidden-xs.hidden-sm")
	private WebElement mainCurrencySelectBtn;	

	@FindBy(css = ".selected-country-wrapper>.country-select span")
	private WebElement mainShippingCountrySelectBtn;
	
	//2	

	public MainPageBeforeSignIn(WebDriver driver) {
		super(driver);
	}
	/*
	 * openSelectLanguage
	 */
	public void openSelectLanguage() {
		sleep1(2000);
		click(mainLanguageSelectBtn);
	}
	/*
	 * validation method :return titleBtnlSelectCurrency
	 */
	public String titleBtnlSelectCurrency() {
	 	sleep1(2000);
	 	String currencyBtnString=getText(mainCurrencySelectBtn);
		return currencyBtnString;
	}
	/*
	 * validation method :return titleBtnlSelectLang
	 */
	public String titleBtnlSelectLanguage() {
	 	sleep1(2000);
		String langBtnLanguage=getText(mainLanguageSelectBtn);
		return langBtnLanguage;
	}	
	/*
	 * validation method :return titleBtnlSelectCountry
	 */
	public String titleBtnlSelectShippingCountry() {
	 	sleep1(2000);
		String shippingBtnString=getText(mainShippingCountrySelectBtn);
		return shippingBtnString;
	}	
	
	/*
	 * openSuperDealsPage
	 */
	public void openSuperDealsPage() {
		sleep1(2000);
		//closeAdvertisement();
		click(superDealsBtn);
	}	
}