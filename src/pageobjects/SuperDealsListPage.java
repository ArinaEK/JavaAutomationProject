package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;


public class SuperDealsListPage extends MenuPage{
	@FindBy(css = "#Folder")
	private WebElement selectedFolderFieldnew;
	@FindBy(css = "#WishlistTitle")
	private WebElement selectedFolderListTitle;
	
	@FindBy(css = "a.lists.selected")
	private WebElement listBtn;//to redresh

	@FindBy(css = ".wishlist-product-container.no-padding.col-xs-24>.list-row>div>div>div> a")
	List <WebElement>productsList;
	
	@FindBy(css = "[value='Add to Cart']")
	List <WebElement>addToCartList;
	@FindBy(css = "#Folder")
    private WebElement selectFolderLists;
	
	@FindBy(css = ".wl-add-to-cart.btn.btn-lg.btn-primary.btn-block")
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
	 *2 select my added list from select
	 */
	public void chooseFromSelectMyNewFolder(String folderName) {
		sleep1(5000);
		click(selectFolderLists);
		//select quantity
		String fName=String.valueOf(folderName);//My List4"
		Select s=new Select(selectedFolderFieldnew);
		//s.selectByValue(fName);
		s.selectByVisibleText(fName);
		sleep1(2000);
	}	
	/*
	 *3 return title from new folder name from select
	 */
	
	public String titleFromFolderList() {
	 	sleep1(2000);
	 	String textTitleFromFolderList=getText(selectedFolderListTitle);
		System.out.println(textTitleFromFolderList);
		return textTitleFromFolderList;
	}		
	
	/*
	 * 4. check if product exist in myList after added/removed
	 */
	public boolean IsProductExistInList(String productName) {
		sleep1(3000);
		for (int i = 0; i < productsList.size(); i++) {
			Actions action=new Actions(getDriver());
			action.moveToElement(productsList.get(i)).build().perform();	
			if (getText(productsList.get(i)).equalsIgnoreCase(productName)){
				System.out.println(getText(productsList.get(i)));
				return true;
			}			
		}
		return false;
	}
	/*
	 *5. add product From List To Cart
	 */
	public void addProductFromListToCart(String productName) {
		sleep1(3000);
		for (int i = 0; i < productsList.size(); i++) {
			Actions action=new Actions(getDriver());
			action.moveToElement(productsList.get(i)).build().perform();	
			if (getText(productsList.get(i)).equalsIgnoreCase(productName)){
				System.out.println(getText(productsList.get(i)));
				click(addToCartBtnList.get(i));
				break;
			}			
		}
	}	
	
}
