package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
public class SelectLanguagePage extends BasePage {
	//language
	@FindBy(css = "div.language-menu.language-menu-universal > div > div > div > div:nth-child(4) > div > label")
	WebElement langSelectBtn;
	@FindBy(css = ".menu.search-list.gh-dropdown-menu.open>.item.gh-dropdown-menu-item label")//=13
	List <WebElement>languageList;
	
	//currency
	@FindBy(css = "div.language-menu.language-menu-universal >div > div > div > div:nth-child(5) > div > label ")
	WebElement currencyFieldBtn;	
	@FindBy(css = ".menu.search-list.open>.item")
	List <WebElement>currencyList;	

	//shipping destination
	@FindBy(css = "div.language-menu.language-menu-universal > div > div > div > div:nth-child(3) > div > label")
	WebElement countryShippingFieldBtn;	
	@FindBy(css = ".menu.search-list.open>.item>label")//United States//Israel
	List <WebElement>shippingCountryList;		
	//save
	@FindBy(css = ".save-selection.gh-btn.gh-btn-primary")
	WebElement saveSelectionBtn;

	public SelectLanguagePage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * select language+currency+shipping country
	 */
	public void selectLanguageCurrencyCountry (String lang, String currency,String shippingCountry) {
		// 1-languege=English
		click(langSelectBtn);//select langbtn
		for (int i = 0; i < languageList.size(); i++) {
			if (languageList.get(i).getText().equalsIgnoreCase(lang)) {	
				Actions action=new Actions(getDriver());
				action.click(languageList.get(i)).build().perform();				
				break;
			}
		}
		//2-Currency="USD ($)"
		click(currencyFieldBtn);//click on select list currency//countryFieldBtn
		for (int i = 0; i < currencyList.size(); i++) {
			if (currencyList.get(i).getText().contains(currency)){	
				//click ils
				Actions action=new Actions(getDriver());
				action.click(currencyList.get(i)).build().perform();				
				break;
			}	
		}
	/*	//3-ShippingDestination="IL - Israel"
		click(countryShippingFieldBtn);//click on select list currency//countryFieldBtn
		for (int i = 0; i < shippingCountryList.size(); i++) {
			if (shippingCountryList.get(i).getText().equalsIgnoreCase(shippingCountry)) {	
				Actions action=new Actions(getDriver());
				action.click(shippingCountryList.get(i)).build().perform();				
				break;
			}
		}*/
		click(saveSelectionBtn);// save	
	}	
}
