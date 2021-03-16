package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;

public class SuperDealsListPage extends MenuPage{
	//#menu- > div.MuiPaper-root.MuiMenu-paper.MuiPopover-paper.MuiPaper-elevation8.MuiPaper-rounded > ul > li:nth-child(1)
	@FindBy(css = "#Folder")
	private WebElement selectedFolderFieldnew;
	@FindBy(css = "#WishlistTitle")
	private WebElement selectedFolderListTitle;
	
	@FindBy(css = "a.lists.selected")
	private WebElement listBtn;//to redresh

	@FindBy(css = "div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-6 > a")
	List <WebElement>productsList;	
	
	@FindBy(css = ".MuiButtonBase-root.css-rho6wz.ee7r4vx1")
	List <WebElement>addToCartBtnList;	

	public SuperDealsListPage(WebDriver driver) {
		super(driver);
	}
	/*
	 *1  click on list link Lists TO DO REFRESH PAGE
	 */
	public void openListsWithProduct() {
		sleep1(10000);
		click(listBtn);			
	}	

	/*
	 *2. add all products From List To Cart
	 */
	public void addProductFromListToCart() {
		sleep1(3000);
		for (int i = 0; i < productsList.size(); i++) {
			Actions action=new Actions(getDriver());
			action.moveToElement(productsList.get(i)).build().perform();	
				System.out.println(getText(productsList.get(i)));
				click(addToCartBtnList.get(i));
		}
	}	
	
}
