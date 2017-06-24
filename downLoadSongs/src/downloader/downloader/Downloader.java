package downloader;


import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Downloader {
	
	
	private static ChromeDriver driver;
	
	public static void main(String[] args) {
		
				
		System.setProperty("webdriver.chrome.driver", "/home/ale/API/chromeDriver/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=/home/ale/.config/google-chrome/Default/Extensions/cfhdojbkjhnklbpkdaibdccddilifddb/1.13.2_0");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		
        String baseUrl = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
        driver.get(baseUrl);
        //String emptyTab = newTab();
        
        //driver.getWindowHandles();
        //Downloader.switchTabs();
        
        String youtubeTab = driver.getWindowHandle();
        driver.switchTo().window(youtubeTab);
        newTab();
        
        //driver.switchTo().window(emptyTab);
        System.exit(0);
        
	}
	
	public static String newTab(){
		String newTabShortcut = Keys.chord(Keys.CONTROL,"t");
		//driver.findElement(By.tagName("body")).sendKeys(selectLinkOpeninNewTab);
		driver.findElementById("masthead-search-term").sendKeys(newTabShortcut);
		//WebElement elementInThePage = driver.findElement(By.tagName("body"));
		//elementInThePage.click();
		//System.out.println("Element in page: "+elementInThePage.getText());
		
		//elementInThePage.sendKeys(newTabShortcut);
		
		return "";
	}
	
	public static String switchTabs(){
	    String base = driver.getWindowHandle();

	    Set <String> set = driver.getWindowHandles();

	    set.remove(base);
	    
	    //driver.switchTo().window(set.toArray(new String[0]));
	    String[] array = set.toArray(new String[0]);
	    System.out.println(array.toString());
	    //driver.close();
	    //driver.switchTo().window(base);
		
	    return "";
		
	}
	
	
/*    //Do something to open new tabs

    for(String handle : driver.getWindowHandles()) {
        if (!handle.equals(youtubeTab)) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }*/
	
	
}
