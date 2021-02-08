package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuperDealsPage extends MenuPage{
	
	@FindBy(css = "#CategoryFilters > div:nth-child(1) > label > input")
	private WebElement searchInputCategoryField;

	@FindBy(css = ".filter-item.filter-included")
	List <WebElement>categoryList;
	
	@FindBy(css = "#BrandFilters > div:nth-child(1) > label > input")
	private WebElement searchInputBrandsField;

	@FindBy(css = ".filter-item.filter-included")
	List <WebElement>brandsList;

	
	@FindBy(css = "#attribute-89 > div > ul > li:nth-child(2) > div > label")
	private WebElement superDealsWomenCheckBoxBtn;	
	
	public SuperDealsPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * go-to SuperDealsCertificationtitle+openSuperDealsWomenPage2
	 */
	public void openSuperDealsWomenProductsPage() {
		sleep1(2000);
		//closeAdvertisement();
		moveToTitleCertification();
		//moveToTitleFormulatedAndClick();
		click(superDealsWomenCheckBoxBtn);
	}
	/*
	 * search by category name
	 */
	public void searchCategoryName(String categoryName) {
		sleep1(2000);
		fillText(searchInputCategoryField,categoryName);				
	}	
	/*
	 * check validation categoryName contains in search
	 */
	public boolean isCategoryExist(String categoryName) {
		sleep1(2000);
		for (int i = 0; i < categoryList.size(); i++) {			
			if (getText(categoryList.get(i)).contains(categoryName)) {
				return true;								
			}			
		}
		return false;
	}
	
	/*
	 * search by brands =Revlon
	 */
	public void searchBrandsName(String brandName) {
		sleep1(2000);
		fillText(searchInputBrandsField,brandName);				
	}	

	/*
	 * check validation brandName exist in search
	 */
	public boolean isBrandsExist(String brandName) {
		for (int i = 0; i < brandsList.size(); i++) {			
			if (getText(brandsList.get(i)).contains(brandName)) {
				return true;
			}			
		}
		return false;
	}

}
