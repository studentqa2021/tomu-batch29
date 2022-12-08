package com.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
		static WebDriver driver;
		
		public static WebDriver getBrowser(String browserName){
			
		
			if(browserName.contains("chrome")) {
				WebDriverManager.chromedriver().setup();
				  driver = new ChromeDriver();
			}else if(browserName.contains("edge")) {
				 
				 WebDriverManager.edgedriver().setup();
				  driver = new EdgeDriver();
			}else if(browserName.contains("safari")) {
				 WebDriverManager.safaridriver().setup();
				  driver = new SafariDriver();
			}
			return driver;
		}

	}


