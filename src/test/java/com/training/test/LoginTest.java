package com.training.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	static String browserName = "edge";
	static WebDriver driver;

	@BeforeEach
	public void setup() {
		if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@Test
	public void testLogin() {
		driver.get("http://localhost:8080/ers-app/index.jsp");
		driver.manage().window().maximize();
		// XPATH locators
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("stormy");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
	}
	
	@AfterEach
	public void TearDown() {
		driver.close();
		driver.quit();
	}

}
