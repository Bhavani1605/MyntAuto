package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RainJacketsPage {
	
	public @FindBy(xpath="//*[@class='search-searchProductsContainer row-base']/descendant::a")
	WebElement firstJacket;
	
	private WebDriver driver;
	
	//Constructor
	public RainJacketsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

}
