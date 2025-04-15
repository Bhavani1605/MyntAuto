package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	private WebDriver driver;
	
	public @FindBy(xpath="//div[@class='itemContainer-base-brand']")
	WebElement productName;
	
	public @FindBy(xpath="//div[@class='itemContainer-base-brand']/following-sibling::a")
	WebElement productDesciption;
	
	public @FindBy(xpath="//div[@class='itemComponents-base-quantity']/child::span")
	WebElement quantitySpan;
	
	public @FindBy(xpath="//div[@class='itemComponents-base-size']/child::span")
	WebElement sizeSpan;
	
	public @FindBy(xpath="//div[@class='priceDetail-base-row ']/child::span[2]/span[2]")
	WebElement priceSpan;
	
	public @FindBy(xpath="//div[@class='priceDetail-base-row '][3]/span[2]/span")
	WebElement platformFee;
	
	//Constructor
			public CartPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver,this);
			}

}
