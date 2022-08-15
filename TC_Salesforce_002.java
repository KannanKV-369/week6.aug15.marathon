package week6.aug15.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Salesforce_002 {

	public static void main(String[] args) throws InterruptedException
	{
		//To disable Notifications
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		//		01) Launch https://login.salesforce.com/
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//		02) Login to Salesforce with your username and password
		driver.findElement(By.id("username")).sendKeys("ptv.kannen@gmail.com");
		//Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("OmS@iram369");
		//click on the login button
		driver.findElement(By.id("Login")).click();
		//		03) Click on the App Launcher (dots)
		driver.findElement(By.className("slds-icon-waffle")).click();
		////span[text()='App Launcher']
		//		04) Click View All
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//		05) Type Content on the Search box	
		//WebElement element = driver.findElement(By.xpath("//label[text()='Search apps or items...']"));
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Individuals");
		//		06) Click Individuals Link
		driver.findElement(By.xpath("//span//mark[text()='Individuals']")).click();
		//		07) Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//		08) Select Salutation with data (coming from excel)
		driver.findElement(By.xpath("//a[text()='--None--']")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		//		09) Type Last Name 
		String lname = "Velappan";
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys(lname);
		//		10) Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(5000);
		//		11) Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//		12) Click View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//		13) Type Customers on the Search box
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Customers");
		//		14) Click Customers Link
		driver.findElement(By.xpath("//span/p/mark[text()='Customers']")).click();
		Thread.sleep(3000);
		//		15) Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//		16) Type the same name provided in step 8 and confirm it appears
		driver.findElement(By.xpath("//input[@title='Search Individuals']")).sendKeys(lname);
		String text2 = driver.findElement(By.xpath("//div[contains(@class,'primaryLabel')]")).getText();
		if(lname.contains(text2))
			System.out.println("Name Confirmed");
		else
			System.out.println("Wrong name");
		//		17) Close the browser
		driver.quit();

	
	}
}
