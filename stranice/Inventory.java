package stranice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

public class Inventory {
	
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	public static final String SORT_XPATH = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select" ;
	public static final String FIRSTITEM_XPATH = "//*[@id=\"item_2_img_link\"]/img";
	
	public static void sort (WebDriver driver) {
		
		WebElement we = driver.findElement(By.xpath(SORT_XPATH));
		we.click();
		
	}
	
	public static void lowToHigh (WebDriver driver) {
		
		Select dropSort = new Select(driver.findElement(By.xpath(SORT_XPATH)));
		dropSort.selectByVisibleText("Price (low to high)");
		
		
		
	}
	
	public static void firstItem (WebDriver driver) {
		
		WebElement we = driver.findElement(By.xpath(FIRSTITEM_XPATH));
		we.click();
	}

}
