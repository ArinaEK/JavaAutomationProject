package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class SuperDealsWomenProductsPage extends MenuPage{
	    @FindBy(css = ".applied-filter")
		private WebElement superDealsWomenFilterLabel;
	    @FindBy(css = "#PriceFilters>div>div.filter-header-wrapper > div")
		private WebElement superDealsWomenPriceLabelBtn1;
	    
		@FindBy(css = "[title='$10 - $20']")
		private WebElement priceRange3From10To15ChrckBoxBtn;

		@FindBy(css = ".range-filter.icon-recentlyviewedarrowright")
		private WebElement priceSearchMinMaxBtn;
		
		@FindBy(css = ".range-min")
		private WebElement filterPriceMinInboxField;
		@FindBy(css = ".range-max")
		private WebElement filterPriceMaxInboxField;
		
		//add to cart
		@FindBy(css = ".product-inner.product-inner-wide>.absolute-link-wrapper>.product-title")//18
		List <WebElement> productLinkList;	
		
		@FindBy(css = ".form-add-to-cart.add-to-cart-wrapper>button")//=19
		List <WebElement> addToCartBtnList;	

		@FindBy(css = ".icon-exit.close")
		private WebElement exitBtn;
		
		public SuperDealsWomenProductsPage(WebDriver driver) {
			super(driver);
		}
		/*
		 * return texkLabel from SuperDealsNewPage: (New)
		 */
		public String superDealsWomenLabel() {
			String label=getText(superDealsWomenFilterLabel);
			return label;
		}
		/*
		 * open filters Range of Price
		 */
		public void openfiltersOfPrice1() {				
			sleep1(3000);
			//moveToTitleCertification();//*** added 6.12
			click(superDealsWomenPriceLabelBtn1);			
		}	
		/*
		 * open Filter priceMintoMax
		 */
		public void openSuperDealsWomenProductsAfterFilterInputPriceRangePage(int minPrice,int maxPrice) {
			sleep1(2000);
			fillNumber(filterPriceMinInboxField,minPrice);
			fillNumber(filterPriceMaxInboxField,maxPrice);
			click(priceSearchMinMaxBtn);			
		}	
		/*
		 *open  Filter price checkbboxPriceRange3: 10-15
		 */
		public void openSuperDealsWomenFilterPriceRange3() {
			sleep1(2000);
			moveToTitleFormulated();//*** added 6.12
			click(priceRange3From10To15ChrckBoxBtn);
		}	

		/*
		 *open  women product page after sort by select price on the top of the page
		 */
		public void openWomenProductsAfterSortBySelectPrice(String sortSelection) {
			sleep1(2000);
			SortByPriceLowToHigh(sortSelection);
		}
		/*
		 *add to cart ByBtn
		 */
		public void addToCartByBtn(String productName) {
			sleep1(5000);
			//moveToTitleFormulated();//7.12
			//closeAdvertisement();
		
			System.out.println( productLinkList.size());
			
			for (int i = 0; i < productLinkList.size(); i++) {	
				Actions action=new Actions(getDriver());
				action.moveToElement(productLinkList.get(i)).build().perform();		
				
				if (getText(productLinkList.get(i)).equalsIgnoreCase(productName)){
				//	Actions action=new Actions(getDriver());
				//	action.moveToElement(productLinkList.get(i)).build().perform();			
					click(addToCartBtnList.get(i));
					click(exitBtn);
					break;
				}
				
			}
		}	
		/*
		 * addToCartByChoosingProduct-open product page
		 */
		public void addToCartByChoosingProduct(String productName) {
			
			sleep1(3000);
			for (int i = 0; i < productLinkList.size(); i++) {
				Actions action=new Actions(getDriver());
				action.moveToElement(productLinkList.get(i)).build().perform();	
				
				if (getText(productLinkList.get(i)).equalsIgnoreCase(productName)){
				//	Actions action=new Actions(getDriver());
				//	action.moveToElement(productLinkList.get(i)).build().perform();	
					action.click(productLinkList.get(i)).build().perform();//**************
					//click(productLinkList.get(i));
					break;
				}			
			}
		}	

}
