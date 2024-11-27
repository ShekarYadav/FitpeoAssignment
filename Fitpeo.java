package fitpeo.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Fitpeo {
	 

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		
		//Clicking on Revenue Calculator
		WebElement RevenuceCalc=driver.findElement(By.xpath("//div[@class='MuiBox-root css-70qvj9']//div[text()='Revenue Calculator']//parent::a"));
		JavascriptExecutor Js =(JavascriptExecutor) driver;
		Js.executeScript("arguments[0].click()",RevenuceCalc);
		Thread.sleep(2000);
		
		//Scrolling to the slider
		WebElement Scrollto=driver.findElement(By.xpath("//div[@class='MuiBox-root css-79elbk']//h4"));
		Js.executeScript("arguments[0].scrollIntoView()",Scrollto);
		
		//Adjusting slider and getting location of it
		WebElement Slider= driver.findElement(By.xpath("//div[@class='MuiBox-root css-j7qwjs']//child::span[3]"));		
		Actions act= new Actions(driver);
		System.out.println("Sliderlocation"+Slider.getLocation());
		Thread.sleep(1000);		
		act.dragAndDropBy(Slider,93,4).perform();
		System.out.println("Sliderlocation"+Slider.getLocation());
		Thread.sleep(1000);
		
		//Entering input in sliderinput box
		WebElement Sliderinput= driver.findElement(By.xpath("//input[@type='number']"));
		act.click(Sliderinput).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		Sliderinput.sendKeys("560");
		Thread.sleep(1000);
		System.out.println("Sliderlocation"+Slider.getLocation());
		
	
		//Selecting Checkboxes
		List <WebElement> Checkboxes=driver.findElements(By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']"));
		WebElement Scrollintotwo=driver.findElement(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt' and text()='CPT-99091']"));
		Js.executeScript("arguments[0].scrollIntoView()",Scrollintotwo);
		int count = 1;
		
			for(WebElement checkbox:Checkboxes) {
				Thread.sleep(1000);
				
				if(count==1|count==2|count==3|count==8) {			
					Js.executeScript("arguments[0].click()",checkbox);
				}
					count++;
				}
		
		//Validating Reiumbersment Amount
		WebElement ReimbursementAmount= driver.findElement(By.xpath("//p[text()='Total Recurring Reimbursement for all Patients Per Month']//following::p[1]"));
		Js.executeScript("arguments[0].scrollIntoView()",ReimbursementAmount);
			System.out.println("Total Recurring Reimbursement for all Patients Per Month:"+ReimbursementAmount.getText());
			if(ReimbursementAmount.getText()=="$110700") {
				System.out.println("Test case passed");
			}
			else {
				System.out.println("Test case failed");
			}
		}


	}


