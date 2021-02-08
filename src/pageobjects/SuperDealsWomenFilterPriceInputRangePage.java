package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SuperDealsWomenFilterPriceInputRangePage extends MenuPage{
	@FindBy(css = ".price.discount-red")
	List <WebElement>productsPriceList;
	
	public SuperDealsWomenFilterPriceInputRangePage(WebDriver driver) {
		super(driver);				
	
	}
		/*
		 * check validation: Range the price
		 */
	
		public boolean IsPriceInRange(int minPrice,int maxPrice) {
			sleep1(3000);
			boolean flag=true;
			String sPrice="";
			//moveToTitleFormulated();
			for (int i = 0; i < (productsPriceList.size()); i++) {
				sPrice=getText(productsPriceList.get(i));			
				sPrice=sPrice.replace("$", "");
				double price=Double.parseDouble(sPrice);
				if (price<=maxPrice&&price>minPrice) {		
					System.out.println(price);
					flag=true;
				}				
			}
			if(flag) {
				return true;
			}else {
				return false;
			}
		}
}
