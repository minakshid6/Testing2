package parameterconcept;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoWebShopParameterConcept {
	
	  WebDriver driver;
	
	  @BeforeSuite
	  public void openBrowser()
	  {
		  
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
			
			 driver = new ChromeDriver();
	  }
	
	
	@BeforeTest
	  public void getUrl() 
	{
		driver.get("http://demowebshop.tricentis.com/register");
	  }

	@BeforeClass
	  public void maximize() 
	 {
		driver.manage().window().maximize();
	  }
	
	@BeforeMethod
	  public void getAllCookie()
	{
		
		Set<Cookie> cookies = driver.manage().getCookies();
		int count = cookies.size();
		System.out.println("total cookies count is ---"+count);
		 
	  }
	
	
	
@Test
@Parameters({"fname","lname","email","pass","cpass","city","address1","address2","zipcode","phone",})
public void f(String fname,String lname,String email,String pass,String cpass,String city,String address1,String address2,String zipcode,String phone) throws InterruptedException 
{
	  driver.findElement(By.id("gender-male")).click();
	  driver.findElement(By.id("FirstName")).sendKeys(fname);
	  driver.findElement(By.id("LastName")).sendKeys(lname);
	  driver.findElement(By.id("Email")).sendKeys(email);
	  driver.findElement(By.id("Password")).sendKeys(pass);
	  driver.findElement(By.id("ConfirmPassword")).sendKeys(cpass);
	 
	  driver.findElement(By.id("register-button")).submit();
	  WebElement msg = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
	  System.out.println(msg.getText());
	 
//	  ADD TO CART FUNCTIONALITY
	  driver.findElement(By.xpath("//input[@value='Continue']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.partialLinkText("Computers")).click();
	  driver.findElement(By.xpath("//h2/child::a[@title='Show products in category Notebooks']")).click();
	  driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Shopping cart')]")).click();
	  
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	  driver.findElement(By.xpath("//button[@name='checkout']")).click();
	  
//	  BILLING ADDRESS
	  WebElement wb  = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
	  Select sel = new Select(wb);
	  sel.selectByValue("9");
	  driver.findElement(By.xpath("//input[@name='BillingNewAddress.City']")).sendKeys(city);  
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys(address1);
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']")).sendKeys(address2);
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys(zipcode); 
	  driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys(phone); 
	  driver.findElement(By.xpath("//div[@id='billing-buttons-container']/child::input[1]")).click();
	  
	  
//    SHIPPING ADDRESS
	  WebElement element = driver.findElement(By.xpath("//select[@name='shipping_address_id']"));
	  Select sel1 = new Select(element);
	  sel1.selectByVisibleText("Jinu Minu, Apt 8151, Windsor 60950, Bahamas");
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	    driver.findElement(By.xpath("//p/following-sibling::input[@onclick ='Shipping.save()']")).click();
	    driver.findElement(By.xpath("//label[@for='shippingoption_1']")).click();
	    driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
	    
	 WebElement pmethod =   driver.findElement(By.xpath("//input[@id='paymentmethod_0']"));
	System.out.println("Flag is on ----"+pmethod.isSelected());
	
	driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
	driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
	driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']")).click();
	WebElement msg1 = driver.findElement(By.xpath("//li[contains(text(),'Order number')]"));
	String text = msg1.getText();
	System.out.println("displayed message is == "+ text);
	driver.findElement(By.linkText("Click here for order details.")).click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		
	  
}

@AfterMethod
public void screenShot() throws IOException {
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
		File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\DemoWeb");
	    FileUtils.copyFileToDirectory(src, src1);
	  
}

@AfterClass
public void deletAllCookie() {
	  System.out.println("delet cookies");
}

@AfterTest
public void dbClose() {
	System.out.println("db close");  
	  
}

@AfterSuite
public void afterSuite() {
//	  driver.close();
}



      
      
}





