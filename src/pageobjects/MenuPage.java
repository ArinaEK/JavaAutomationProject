package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class MenuPage extends BasePage{
	@FindBy(css = " div.link-bar-wrapper > div > a:nth-child(1)")
	WebElement superDealsBtn;
	@FindBy(css = "#loading")//*********
	WebElement loadingIcon;
	
	@FindBy(css = "[data-ga-event-label='close-[03]']")
	private WebElement closeAdvertisementBtn;
	
	//All Titles 
	
	@FindBy(css = "#attribute-99 ")
	private WebElement superDealsFormTitle;
	
	@FindBy(css = "#attribute-88 ")
	private WebElement superDealsCertifacationTitle;
	
	@FindBy(css = "#attribute-89")
	private WebElement superDealsFormulatedForTitle;	
	
	@FindBy(css = "#BrandFilters > div > div ")
	private WebElement superDealsBrandsTitle;	
	
	@FindBy(css = "[aria-label='Sort By']")
	private WebElement selectSortByField;
	
	// addtocart+addTolist BTNs
	@FindBy(css = "#cart-qty")
	private WebElement countCartBtnLebel;
	
	@FindBy(css = ".iherb-header-cart> a")
	private WebElement cartBtn;
	
	@FindBy(css = ".my-account-label")
	private WebElement myAccountLabel;
	
	@FindBy(css = "ul.my-account-links > li:nth-child(3) > a")//myLists//aaa
	private WebElement listsBtn;
	
	@FindBy(css = "[data-ga-event-label='myaccount-signout-click']")
	private WebElement signOutBtn;	
	
	@FindBy(css = ".iherb-header-signed-out.icon-header_signed-out.sign-in.tablet-icon-login-link")
	private WebElement signInBtn;

	
	MenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/*
	 * SortByPriceLowToHigh on the top of the page : Price: Low to High
	 */
	public void waitForLoading() {
		getWait().until(ExpectedConditions.visibilityOf(loadingIcon));
		getWait().until(ExpectedConditions.invisibilityOf(loadingIcon));
	}
	public void SortByPriceLowToHigh(String sortSelection) {
		sleep1(3000);
		moveToTitleForm();
		Select selectSortByPriceLowToHigh=new Select(selectSortByField);
		selectSortByPriceLowToHigh.selectByVisibleText(sortSelection);	
	}
	public void closeAdvertisement() {
		sleep1(2000);
		click(closeAdvertisementBtn)	;
	}
		public void moveToTitleCertification() {
			Actions action = new Actions(getDriver());
			action.moveToElement(superDealsCertifacationTitle).build().perform();
		}
		
		public void moveToTitleFormulated() {
			Actions action = new Actions(getDriver());
			action.moveToElement(superDealsFormulatedForTitle).build().perform();
		}
		public void moveToTitleFormulatedAndClick() {
			Actions action = new Actions(getDriver());
			action.moveToElement(superDealsFormulatedForTitle).build().perform();
			click(superDealsFormulatedForTitle);
		}
		public void moveToTitleForm() {
			Actions action = new Actions(getDriver());
			action.moveToElement(superDealsFormTitle).build().perform();
		}

		public void moveToTitleBrands() {
			Actions action = new Actions(getDriver());
			action.moveToElement(superDealsBrandsTitle).build().perform();	
		}


		/*
		 * return Label from productCountLabel
		 */
	public double productCountLabel() {
		sleep1(2000);
		String sCountCart=getText(countCartBtnLebel);
		double countCart=Double.parseDouble(sCountCart);
		return countCart;
	}
	/*
	 * open Cart
	 */
	public void openCart() {
		sleep1(5000);
		click(cartBtn);
	}	
	/*
	 * edit account menu +click on myLists
	 */
	/*
	 *open super deals page
	 */
	public void openSuperDealsPage() {
		click(superDealsBtn);
		sleep1(2000);
	}	
	public void openAccountListsClickListBtn() {
		sleep1(10000);
		Actions action =new Actions(getDriver());
		action.moveToElement(myAccountLabel).build().perform();
		click(listsBtn);
		//sleep1(5000);
	}
	/*
	 * edit account menu +click on SignOut
	 */
	public void openAccountListsClickSignOutBtn() {
		sleep1(3000);
		Actions action =new Actions(getDriver());
		action.moveToElement(myAccountLabel).build().perform();
		click(signOutBtn);
		sleep1(5000);
	}
	/*
	 * openSignInPage
	 */
	public void openSignInPage() {
		sleep1(2000);
		click(signInBtn);
	}
}