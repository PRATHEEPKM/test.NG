package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TvSection  {
static long browserstart;
static WebDriver driver;
static long open;
static long close;
static String parent;
@BeforeClass	
public static void  browser () {
	browserstart=System.currentTimeMillis();
	System.out.println(browserstart );
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\pratheep.km\\\\eclipse-workspace\\\\JunitProject\\\\src\\\\Drivers\\\\chromedriver.exe");
	driver =new ChromeDriver();
	String url="https://www.flipkart.com/";
	driver.get(url);
	driver.manage().window().maximize();
	
}
@AfterClass
public static void browserquit() {
	long browserclose=System.currentTimeMillis();
	System.out.println("browser quit time"+(browserclose-browserstart));	
	driver.quit();
}
@BeforeMethod
public void close()  {
	 open=System.currentTimeMillis();
	System.out.println(open);
}
@AfterMethod
public void closed() {
	long close=System.currentTimeMillis();
	System.out.println("close time"+(close-open));
}
@Test (priority = 1)
public void closepop() throws Exception {
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[text()])[1]")).click();
	System.out.println("closed the pop up");	
}
@Test (priority = 2)
public void entertv() throws Exception {
		Thread.sleep(2000);	
	driver.findElement(By.xpath("//*[@type='text']")).sendKeys("samsung tv",Keys.ENTER);
	driver.findElement(By.xpath("//*[@type='submit']"));
	WebElement move=driver.findElement(By.xpath("//*[contains(text(),'Explore')]"));
	Thread.sleep(3000);
	Actions ac=new Actions(driver);
	ac.moveToElement(move).perform();
	System.out.println("Enter the TV");
}
@Test (priority = 3)
public void windowswitching() {
	 parent=driver.getWindowHandle();
	System.out.println(parent);	
}
@Test (priority = 4)
public void samsungtv1(){
	WebElement TV1=driver.findElement(By.xpath("(//*[contains(text(),'SAMSUNG 80')])[1]"));
	TV1.click();
	 
	driver.switchTo().window(parent);
	}
@Test (priority = 5)
	public void samsungtv2(){
		WebElement TV2=driver.findElement(By.xpath("(//*[contains(text(),'SAMSUNG 80')])[2]"));
		TV2.click();		 
		driver.switchTo().window(parent);
	
}


	}


