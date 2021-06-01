package stranice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Pocetna {
	
	
	public static final String URL = "https://www.saucedemo.com/";
	public static final String USERNAME_XPATH = "//*[@id=\"user-name\"]";	
	public static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	public static final String LOGIN_XPATH = "//*[@id=\"login-button\"]";
	
	
	public static void enterUsername(WebDriver driver, String username) {
		
		WebElement we = driver.findElement(By.xpath(USERNAME_XPATH));
		we.sendKeys(username);
		
		
	}
	
	public static void enterPassword (WebDriver driver, String password) {
		
		WebElement we = driver.findElement(By.xpath(PASSWORD_XPATH));
		we.sendKeys(password);
		
		
	}
	
	public static void login (WebDriver driver) {
		
		WebElement we = driver.findElement(By.xpath(LOGIN_XPATH));
		we.click();
		
	}
	
}
