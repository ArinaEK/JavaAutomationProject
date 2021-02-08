package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuperDealsWomenFilterPriceRange3Page extends MenuPage{
	
	@FindBy(css = ".price.discount-red")
	List <WebElement>productsPriceList;
	
	@FindBy(css = "div.applied-filter-row>.col-xs-24>.applied-filter")
	List <WebElement>filterList;	
		
	@FindBy(css = ".applied-filter-clear")
	private WebElement clearAllFilterInRange3Btn;

	public SuperDealsWomenFilterPriceRange3Page(WebDriver driver) {
		super(driver);
	}
		/*
		 * check validation: Range the price
		 */
	public boolean IsPriceInRange() {
		sleep1(3000);
		boolean flag=true;
		moveToTitleFormulated();
		String sPrice="";
		for (int i = 0; i < (productsPriceList.size()); i++) {
			sPrice=getText(productsPriceList.get(i));			
			sPrice=sPrice.replace("$", "");
			double price=Double.parseDouble(sPrice);
			if (price<=20&&price>10) {		
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
	/*
	 * //DeleteFilterPriceRange3Test
	 */
	public void DeleteFilterPriceRange3(String filterName) {
		sleep1(5000);
		moveToTitleBrands();
		for (int i = 0; i < (filterList.size()); i++) {
			if (getText(filterList.get(i)).contains(filterName)) {
			click(filterList.get(i));				
			break;
			}
		}
		sleep1(1000);
	}
	/*
	 * //ClearAllFilters
	 */
	public void ClearAllFilters() {
		sleep1(5000);		
		moveToTitleBrands();
		click(clearAllFilterInRange3Btn);
	}
}

				
			
			
		
		