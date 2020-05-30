package com.app;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "drivers/32/IEDriverServer.exe");
        //Initialize InternetExplorerDriver Instance.
		DesiredCapabilities cap = new DesiredCapabilities();  
		//cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		 cap.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
         cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //disable protected mode settings
         cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true); //disable protected mode settings
         cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true); //disable protected mode settings
         
		WebDriver driver = new InternetExplorerDriver(cap);
//		WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://test.sinarmasmsiglife.co.id:8800/E-LionsExtraMagna/");
//        WebElement user = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        //WebElement user= driver.findElement(By.id("name"));
       WebElement user = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='name']")));
        WebElement pass = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='pass']")));
        WebElement button = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("btnLogin")));
        
//        ((JavascriptExecutor) driver).executeScript(String.format("document.getElementById('name').value='{0}';","patar"));
//        ((JavascriptExecutor) driver).executeScript(String.format("alert('test');","patar"));
    //    ((JavascriptExecutor) driver).executeScript(String.format("document.getElementById('name').value='{0}';","patar"));
        //user.sendKeys("TITIS33");
        
        user.sendKeys("RANDY");
        pass.sendKeys("Randy123");
        button.click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("elions.png"));
        driver.navigate().to("http://test.sinarmasmsiglife.co.id:8800/E-LionsExtraMagna/bac/editspajnew.htm?data_baru=true&flagAwal=1&jenis_pemegang_polis=");
        
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("elions2.png"));
        WebElement kopispaj = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='kopiSPAJ']")));
        WebElement copyclik = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='Copy Data dari Spaj:']")));
        
        kopispaj.sendKeys("09.1000.91");
        copyclik.click();
        
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("elions3.png"));
        
//((JavascriptExecutor) driver).executeScript("arguments[0].click();",button);
        
/*		driver.get("https://www.google.com/");

		//Locating the elements using name locator for the text box
		driver.findElement(By.name("q")).sendKeys("BrowserStack");

		//name locator for google search button
		WebElement searchIcon = driver.findElement(By.name("btnK"));
		searchIcon.click();*/
		
		Thread.sleep(1000);
        System.out.println("Selenium Webdriver Script in Internet Explorer browser | Software Testing Material");
        driver.close();
        driver.quit();
	}

}
