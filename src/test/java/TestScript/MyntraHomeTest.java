package TestScript;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.*;

import PageObjects.CartPage;
import PageObjects.MyntraHomePage;
import PageObjects.RainJacketProductPage;
import PageObjects.RainJacketsPage;

public class MyntraHomeTest {

  public  ChromeOptions getCop(){
	  ChromeOptions cop = new ChromeOptions();
	  cop.addArguments("--disable-notifications");
	  return cop;
	}
   
  ChromeDriver driver = new ChromeDriver(getCop());
  MyntraHomePage myntrahome = new MyntraHomePage(driver);
  RainJacketsPage rp = new RainJacketsPage(driver);
  RainJacketProductPage productPage = new RainJacketProductPage(driver);
  CartPage cartPage = new CartPage(driver);

  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

  String siteURL = "https://www.myntra.com/";
  String price = "";
  String productInfo = "";
  String productPlatformFee = "20";

  @Test(priority = 1)
  void testOpen() {
    try {
      
      driver.get(siteURL);
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      wait.until(ExpectedConditions.visibilityOf(myntrahome.searchBar));
      Assert.assertEquals(driver.getTitle(), "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");

    } catch (Exception e) {
      System.out.println("Exception in TestOpen:" + e);
    }
  }
  @Test(priority = 2)
  void openRainJacket() {
    try {
      Actions builder = new Actions(driver);
      builder.moveToElement(myntrahome.Men).perform();
      myntrahome.rainJacket.click();

    } catch (Exception e) {
      System.out.println("Exception in openRainJacket:" + e);
    }
  }

  @Test(priority = 3)
  void selectAndAddToBag() {
    try {
      wait.until(ExpectedConditions.visibilityOf(rp.firstJacket));
      rp.firstJacket.click();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      Set < String > windows = driver.getWindowHandles();
      String currentWindow = driver.getWindowHandle();
      System.out.println("Current Handle:" + currentWindow);

      for (String tab: windows) {
        if (!tab.equalsIgnoreCase(currentWindow)) {

          driver.switchTo().window((String) tab);
          wait.until(ExpectedConditions.visibilityOf(productPage.priceSpan));
          price = productPage.priceSpan.getText(); // MRP₹ 899
          productInfo = productPage.productInfo.getText().substring(0, 81);
        }
      }

      productPage.sizeSM.click();
      productPage.addToBag.click();

    } catch (Exception e) {
      System.out.println("Exception 3::" + e);
    }
  }
  @Test(priority = 4)
  void verifyBag() {
    try {
      wait.until(ExpectedConditions.visibilityOf(productPage.goToBag)).click();
    } catch (Exception e) {
      System.out.println("Exception4 :: " + e);

    }
  }

  @Test(priority = 5)
  void cartPageVerify() {
    try {
      wait.until(ExpectedConditions.visibilityOf(cartPage.productName));
      Assert.assertTrue(productInfo.contains(cartPage.productName.getText()));
      Assert.assertTrue(productInfo.contains(cartPage.productDesciption.getText()));
      Assert.assertTrue(price.contains(cartPage.priceSpan.getText().substring(1, 3))); //verify price = 899
      Assert.assertEquals(cartPage.platformFee.getText(), productPlatformFee, "Platform Fee is not matching Expected Value");
      Assert.assertTrue(cartPage.sizeSpan.getText().contains("S/M"));
      Assert.assertTrue(cartPage.quantitySpan.getText().contains("1"));

    } catch (Exception e) {
      System.out.println("EXCEPTION IN CARTPAGEVERIFY:" + e);
    }
  }

  @AfterTest()
  void tearDown() {
    driver.quit();

  }
}