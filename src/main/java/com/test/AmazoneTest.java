package com.test;



import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazoneTest {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		new WebDriverWait(driver, Duration.ofSeconds(10));
	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	

		WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone15 Pro Max (256 GB)");
		WebElement searchbtn =driver.findElement(By.xpath("//input[@type='submit']"));
		searchbtn.click();
		
		WebElement iphone=driver.findElement(By.linkText("Apple iPhone 15 Pro Max (256 GB) - Blue Titanium"));
		iphone.click();
		
	
	//searchBox0.submit();
		//Handle new Window tab
		 Set<String> newWindow=driver.getWindowHandles();//parentId,childId,subchidId
		 
		 Iterator<String> it= newWindow.iterator();
		 String parentId=(String)it.next();
		 String childId= (String) it.next();
		 driver.switchTo().window(childId);
		
		
		WebElement buybtn=driver.findElement(By.xpath("//input[@id='buy-now-button']"));
		buybtn.click();
		
		driver.switchTo().window(parentId);
	
	

		

	}

}
