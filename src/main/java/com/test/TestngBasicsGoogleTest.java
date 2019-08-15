package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngBasicsGoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver.exe");
	driver = new ChromeDriver();//launch chrome
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("http://www.google.com");
	
	}
	@Test(priority=1,groups="Title")
	public void googleTitleTest() {
		String title =driver.getTitle();
		System.out.println(title);
	}
	@Test(priority=2,groups="Logo")
	public void googleLogoTest() {
	boolean b =driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
	}
	@Test(priority=3,groups="Mail")
	public void mailLinkTest() {
		boolean b =driver.findElement(By.linkText("mail")).isDisplayed();	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}



