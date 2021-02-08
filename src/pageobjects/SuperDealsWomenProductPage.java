package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SuperDealsWomenProductPage extends MenuPage{
	//add new list folder
	@FindBy(css = ".icon-uparrow.wishlist-arrow")
	private WebElement addToListBtn;
	
	@FindBy(css = ".create-new-list")
	private WebElement createNewListBtn;

	@FindBy(css = "div.input-new-list.active > input")
	private WebElement inputNewListFieldName;
	
	@FindBy(css = "div.input-new-list.active > button")
	private WebElement createNewListSubmitBtn;
	
	@FindBy(css = ".btn.btn-primary.btn-block.btn-lg.btn-add-to-cart")
	private WebElement addToCartBtn;
	
	
	@FindBy(css = "#ddlQty")
	private WebElement quantityField;	
	
	@FindBy(css =".wishlist-sub-items >div>div")
	List <WebElement>checkBoxList;
	
	public SuperDealsWomenProductPage(WebDriver driver) {
		super(driver);
	}	
	/*
	 *select list folder to add product
	 */
	public void addToListSelect(String fListName) {
		sleep1(3000);
		click(addToListBtn);
		click(createNewListBtn);
		fillText(inputNewListFieldName,fListName);
		click(createNewListSubmitBtn);
		sleep1(10000);
	}	
	
	/*
	 *add/ update product-to cart details-open productPage
	 */
	public void addProductToCart(String pName, int q) {
		sleep1(3000);
		//select quantity
		String sQuantity=String.valueOf(q);
		Select s=new Select(quantityField);
		s.selectByValue(sQuantity);
		click(addToCartBtn);
		sleep1(2000);
	}	
	/*
	 *add/  product-to List
	 */
	public void addProductToList(String listName) {
		sleep1(3000);
		click(addToListBtn);
		for (WebElement el:checkBoxList) {
			if (getText(el).equalsIgnoreCase(listName)) {
				click(el);
				sleep1(10000);
				break;
			}
		}
	}	
}

