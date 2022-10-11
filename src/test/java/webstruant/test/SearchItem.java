package webstruant.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import websturant.pages.HomePage;
import websturant.utils.Constants;

public class SearchItem extends Constants {

	public static void main(String[] args) throws InterruptedException {

		setUp();

		searchTest();

		tearDown();

	}

	public static void searchTest() throws InterruptedException {
		homeobj = new HomePage();
		homeobj.enterItemName("stainless work table");
		homeobj.searchButton();

		String result = driver.getPageSource();

		if (result.contains("Table")) {
			System.out.println("Table is in search results");

		} else {
			System.out.println("Table not found in search result");
		}

		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@id='paging']/nav/ul/li"));

		WebElement lastItem = searchResults.get(searchResults.size() - 1);

		lastItem.click();

		homeobj.addToCartButton();
		homeobj.cartButton();
		homeobj.deleteButton();
	}
//
	public static void setUp() {
		String url = "https://www.webstaurantstore.com/";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
