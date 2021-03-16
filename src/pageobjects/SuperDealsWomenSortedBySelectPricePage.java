package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SuperDealsWomenSortedBySelectPricePage extends MenuPage{
	@FindBy(css = ".price.discount-red")
	List <WebElement>womenProductsPriceList;
	public SuperDealsWomenSortedBySelectPricePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/*
	 * check validation: CheckSortedPriceAfterSortByPriceLowToHigh
	 */
	public boolean isCheckSortedPriceAfterSortByPriceLowToHigh1() {
		sleep1(3000);
		boolean flag=true;
		for (int i = 0; i < womenProductsPriceList.size(); i++) {
			System.out.println(womenProductsPriceList.get(i).getText());//print price in format text
			
		}
		String sPrice=getText(womenProductsPriceList.get(0));			
		sPrice=sPrice.replace("$", "");
		double price=Double.parseDouble(sPrice);
		double tempPrice=price;
		for (int i = 1;(i < (womenProductsPriceList.size())&&(flag)); i++) {
			sPrice=getText(womenProductsPriceList.get(i));			
			sPrice=sPrice.replace("$", "");
			price=Double.parseDouble(sPrice);
			if (price>=tempPrice) {
				tempPrice=price;
				flag=true;
			}else {
				flag=false;
				System.out.println("error sort");
				return flag;				
			}
		}		
		return flag;
	}
}