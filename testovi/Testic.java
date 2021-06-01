package testovi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import stranice.Inventory;
import stranice.Pocetna;

public class Testic {

	private static WebDriver driver;

	@BeforeClass

	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\emmad\\Desktop\\itbootcamp\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test

	public void nevalidniKredencijali() {

		File f = new File("data.xlsx");

		try {
			InputStream in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sh = wb.getSheetAt(0);

			SoftAssert sa = new SoftAssert();

			for (int i = 0; i < 3; i++) {

				Row row = sh.getRow(i);

				Cell cell0 = row.getCell(0);
				Cell cell1 = row.getCell(1);

				String username = cell0.toString();
				String password = cell1.toString();

				driver.navigate().to(Pocetna.URL);

				Pocetna.enterUsername(driver, username);
				Pocetna.enterPassword(driver, password);
				Pocetna.login(driver);

				String currentUrl = driver.getCurrentUrl();
				String expectedUrl = "https://www.saucedemo.com/";

				sa.assertEquals(currentUrl, expectedUrl);

			}

			sa.assertAll();

			wb.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test

	public void validniKredencijali() {

		File f = new File("data.xlsx");

		try {
			InputStream in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sh = wb.getSheetAt(0);

			SoftAssert sa = new SoftAssert();

			Row row = sh.getRow(3);

			Cell cell0 = row.getCell(0);
			Cell cell1 = row.getCell(1);

			String username = cell0.toString();
			String password = cell1.toString();

			driver.navigate().to(Pocetna.URL);

			Pocetna.enterUsername(driver, username);
			Pocetna.enterPassword(driver, password);
			Pocetna.login(driver);

			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "https://www.saucedemo.com/inventory.html";

			sa.assertEquals(currentUrl, expectedUrl);

			sa.assertAll();

			wb.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test

	public void testSortiranje() {
		
		File f = new File("data.xlsx");

		try {
			InputStream in = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(in);
			Sheet sh = wb.getSheetAt(0);

			

			Row row = sh.getRow(3);

			Cell cell0 = row.getCell(0);
			Cell cell1 = row.getCell(1);

			String username = cell0.toString();
			String password = cell1.toString();

			driver.navigate().to(Pocetna.URL);

			Pocetna.enterUsername(driver, username);
			Pocetna.enterPassword(driver, password);
			Pocetna.login(driver);
			
			Inventory.sort(driver);
			Inventory.lowToHigh(driver);
			Inventory.firstItem(driver);
			
			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=2";

			Assert.assertEquals(currentUrl, expectedUrl);

			
			

			wb.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
