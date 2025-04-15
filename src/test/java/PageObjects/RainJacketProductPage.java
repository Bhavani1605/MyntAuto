package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RainJacketProductPage {
	
	private WebDriver driver;
	
	//public @FindBy(xpath="//span[@class='pdp-price']")
	
	public@FindBy(xpath="//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[1]/div/p[1]/span")
	WebElement priceSpan;
	
	public @FindBy(xpath= "//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[1]")  //*[@id="mountRoot"]/div/div[1]/main/div[2]/div[2]/div[1]/div/p[1]/span 
	WebElement productInfo;
	
	public @FindBy(xpath = "//*[@id='mountRoot']/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]")
	WebElement addToBag;
	
	
	public @FindBy(xpath = "//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/a")
	WebElement goToBag;
	
	
	public @FindBy(xpath="//*[@id=\"sizeButtonsContainer\"]/div[2]/div[2]")
	WebElement sizeSM;
	
	//Constructor
		public RainJacketProductPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}


}
