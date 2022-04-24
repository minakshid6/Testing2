package dependsOn;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssertionPriorityDemoBlazeConcept {
	
      WebDriver driver;
      
      @BeforeSuite
	  public void openBrowser() {
		  
		  System.setProperty("webdriver.chrome.driver", "C:/Users/minak/Documents/Minakshi/webDriver/98_chromeDriver/chromedriver.exe");
			
			 driver = new ChromeDriver();
	  }
      
      @BeforeTest
	  public void getUrl() {
		driver.get("https://demoblaze.com/");
	  }
      
      @BeforeClass
	  public void maximize() {
    	  System.out.println("maximize");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	  }
      
      @BeforeMethod
       public void getCookie() 
      {
    	  System.out.println("implicitlyWait");
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  
      }
      
      @Test(priority = 1)
      public void signUpFunctionality() throws InterruptedException 
      
      {
    	  System.out.println(" signUpFunctionality");
    	  driver.findElement(By.id("signin2")).click();
    	  driver.findElement(By.id("sign-username")).sendKeys("jinu139@gmail.com");
//    	  driver.findElement(By.cssSelector("input#sign-username")).sendKeys("jinu125@gmail.com");
    	  driver.findElement(By.cssSelector("input#sign-password")).sendKeys("jinu123456");
    	  driver.findElement(By.xpath("//button[text()='Sign up']")).click();
    	  Thread.sleep(1000);
    	  String msg =  driver.switchTo().alert().getText();
    	  driver.switchTo().alert().accept();
    	  System.out.println("message "+msg);
    	  
    	  Assert.assertEquals(msg, "Sign up successful.");
    	  System.out.println("Assertion pass");
      }
      
      @Test(priority = 2)
      public void loginFunctionality() throws InterruptedException 
      
      {
    	  System.out.println("loginFunctionality");
    	  driver.findElement(By.id("login2")).click();
    	  driver.findElement(By.id("loginusername")).sendKeys("jinu139@gmail.com");
    	  driver.findElement(By.id("loginpassword")).sendKeys("jinu123456");
    	  driver.findElement(By.xpath("//button[text()='Log in']")).click();
    	  Thread.sleep(2000);
    	  String username = driver.findElement(By.xpath("//a[@id='nameofuser']")).getText();
    	  System.out.println("username==="+username );
    	  Assert.assertEquals(username, "Welcome jinu139@gmail.com");
    	  System.out.println("Login Pass");
      }
      @Test(priority = 3)
      public void addToCartFunctionality() throws InterruptedException 
      {
    	  System.out.println("addToCartFunctionality");
    	  driver.findElement(By.xpath("//a[text()='Phones']")).click();
    	  driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
    	  driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
    	  Thread.sleep(1000);
    	  driver.switchTo().alert().accept();
    	
    	  
    	  
      }
      @Test(priority = 4)
      public void placeOrderFunctionality() throws InterruptedException 
      {
    	  System.out.println("placeOrderFunctionality");
    	  driver.findElement(By.xpath("//a[@id='cartur']")).click();
    	  driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
    	  
//    	  form details for placing order
    	  driver.findElement(By.xpath("//input[@id='name']")).sendKeys("jinal");
    	  driver.findElement(By.id("country")).sendKeys("India");
    	  driver.findElement(By.id("city")).sendKeys("Pune");
    	  driver.findElement(By.id("card")).sendKeys("123456789123");
    	  driver.findElement(By.id("month")).sendKeys("August");
    	  driver.findElement(By.id("year")).sendKeys("2025");
    	  driver.findElement(By.xpath("//button[text()='Purchase']")).click();
    	  Thread.sleep(1000);
         WebElement msg =  driver.findElement(By.xpath("//p[@class='lead text-muted ']"));
    	  System.out.println("Message displayed "+ msg.getText());
    	  
      }
      
   
    
     @AfterMethod
     public void screenshot() throws IOException 
     {
    	 File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 File src1 = new File("C:\\Users\\minak\\Documents\\Minakshi\\demoblaze");
    	 FileUtils.copyFile(src, src1);
    	System.out.println("Take screenshot"); 
    	 
     }
     
     
     
     
}



