package websturant.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import websturant.utils.Constants;

public class HomePage {

	@FindBy(id = "searchval")
	WebElement searchField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	@FindBy(name = "addToCartButton")
	WebElement addToCartButton;

	@FindBy(xpath = "//*[text() = 'View Cart']")
	WebElement cartButton;

	@FindBy(xpath = "//*[@class = 'itemDelete__icon']")
	WebElement deleteButton;

	public HomePage() {

		PageFactory.initElements(Constants.driver, this);//
	}

	public void enterItemName(String username) {
		searchField.sendKeys(username);
	}

	public void searchButton() {
		searchButton.click();

	}

	public void addToCartButton() {
		addToCartButton.click();
	}

	public void cartButton() {
		cartButton.click();

	}

	public void deleteButton() {
		deleteButton.click();

	}

}
