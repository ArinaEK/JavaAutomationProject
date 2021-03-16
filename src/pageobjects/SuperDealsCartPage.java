package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SuperDealsCartPage extends MenuPage{

	@FindBy(css = "[data-qa-element='line-item']>div:nth-child(1)>div:nth-child(2)>a")
	List <WebElement>womenProductsCartList;
	
	@FindBy(css = "[data-ga-element='btnItemRemove']")
	List <WebElement>removeProductsListBtn;
	
	@FindBy(css = "#cart-qty")
	private WebElement countCartBtnLebel;
	
	public SuperDealsCartPage(WebDriver driver) {
		super(driver);
	}
	/*
	 * check if product exist in cart after added/removed
	 */
	public boolean IsProductExistInCart(String productName) {
		sleep1(2000);
		productName=productName.replace(",", "");  //move all , from productName
		String pn;
		for (int i = 0; i < womenProductsCartList.size(); i++) {
			pn=(getText(womenProductsCartList.get(i)));
			pn=pn.replace(",", "");
			if (pn.equalsIgnoreCase(productName)){
				System.out.println(getText(womenProductsCartList.get(i)));
				return true;
			}			
		}
		return false;
	}
	/*
	 * choose one product to update
	 */
	public void ChooseProductToUpdate(String productName) {
		sleep1(2000);
		productName=productName.replace(",", "");  //move all , from productName
		String pn;
		System.out.println( womenProductsCartList.size());
		for (int i = 0; i < womenProductsCartList.size(); i++) {
			pn=(getText(womenProductsCartList.get(i)));
			pn=pn.replace(",", "");
			if (pn.equalsIgnoreCase(productName)){
				System.out.println(getText(womenProductsCartList.get(i)));
				click(womenProductsCartList.get(i));//return to product page
				break;
			}			
		}		
	}
	/*
	 * remove product from Cart
	 */
	public void removeFromCart(String productName) {
		sleep1(2000);
		productName=productName.replace(",", "");  //move all , from productName
		String pn;
		System.out.println( womenProductsCartList.size());
		for (int i = 0; i < womenProductsCartList.size(); i++) {
			pn=(getText(womenProductsCartList.get(i)));
			pn=pn.replace(",", "");
			if (pn.equalsIgnoreCase(productName)){
				click(removeProductsListBtn.get(i));//return to product page
				break;
			}			
		}		
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
}
