package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public  abstract class BasePage {
	private WebDriver driver;
	private JavascriptExecutor js;
	private WebDriverWait wait;
    //2
    BasePage(WebDriver driver) {
    	this.driver = driver;	
    	PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(getDriver(), 10);		
    }	
	WebDriver getDriver() {
		return driver;
	}	
	public WebDriverWait getWait() {
		return wait;
	}
	public JavascriptExecutor getJs() {
		return js;
	}

	//3
	 void fillText(WebElement el, String text){		
		el.clear();
		highlightElement(el,"red");
		sleep1(2000);
		el.sendKeys(text);
		}
	void fillNumber(WebElement el, int num) {
		el.clear();
		highlightElement(el,"red");
		String snum=Integer.toString(num);
		sleep1(3000);		
		el.sendKeys(snum);
		}
	 void click(WebElement el) {
		highlightElement(el,"red");
		sleep1(2000);
		el.click();			
    }
	
	 String getText(WebElement el) {
		sleep1(2000);
		highlightElement(el,"red");
		sleep1(3000);
		return el.getText();
	}

	 void alertOK(String text) {
		Alert alert =getDriver().switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}
	 void alertOK() {
		getDriver().switchTo().alert().accept();
	}
	 void sleep1(long millis) {
		try {
				Thread.sleep(millis);
		}catch (InterruptedException e) {
		  //	TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	private void highlightElement(WebElement element, String color) {
			//keep the old style to change it back
			String originalStyle = element.getAttribute("style");
			String newStyle = "border: 1px solid " + color + ";" + originalStyle;
			JavascriptExecutor js = (JavascriptExecutor) driver;			
			// Change the style 
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
					element);
			// Change the style back after few miliseconds
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
					+ originalStyle + "');},400);", element);
		}
}
