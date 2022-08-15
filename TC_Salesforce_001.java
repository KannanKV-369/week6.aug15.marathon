package week6.aug15.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Salesforce_001 {

	public static void main(String[] args) throws InterruptedException
	{
		//To disable Notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//		01) Launch https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
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
		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Content");
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		//element.sendKeys("Content",Keys.ENTER);
		//element.sendKeys("Content");
		//		06) Click Content Link
		driver.findElement(By.xpath("//span/following::p/mark[text()='Content']")).click();
		//		07) Click on Chatter Tab
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		//		08) Verify Chatter title on the page
		String title = driver.getTitle();
		System.out.println("Chatter Title:"+title);
		if(title.contains("Lightning Experience"))
			System.out.println("Title is verified:");
		else
			System.out.println("Wrong Title");
		//		09) Click Question tab
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		//		10) Type Question with data (coming from excel)
		String Q1 = "Which is your place of Birth?";
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(Q1);
		//		11) Type Details with data (coming from excel)
		String Q2 = "Which is your first school?";
		//		12) Click Ask
		driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]")).sendKeys(Q2);
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();
		//String text2 = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		String question1 = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();		
		System.out.println("Question : "+question1);
		//String question2 = driver.findElement(By.xpath("//span[text()='Which is your fist school?']")).getText();
		//System.out.println("Question : "+question2);
		//		13) Confirm the question appears
		if(Q1.equals(question1))
			System.out.println("Question Matched");
		else
		  System.out.println("Wrong match");
		//		14) Close the browser
		driver.quit();
	}
}
