package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyntraHomePage {
	
	WebDriver driver;
	
	public @FindBy(id="desktop-header-cnt\"]/div[2]/div[1]")
	WebElement logo;
	
	public @FindBy(className ="desktop-searchBar")
	WebElement searchBar;
	
	public @FindBy(linkText="MEN")
	WebElement Men;
	
	public @FindBy(xpath= "//*[@linkText='MEN']/child::li[10]/a")
	WebElement rainJacket1;
	
	//String categoryContainer ="//*[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/div/div/div";
	
	public @FindBy(xpath="//*[@id='desktop-header-cnt']/div[2]/nav/div/div[1]/div/div/div/div/li[1]/ul/li[10]/a")
	WebElement rainJacket;
	
	public MyntraHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}

}
