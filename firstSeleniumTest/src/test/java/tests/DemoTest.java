package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Files;

public class DemoTest {

    @Before
    public void startBrowser() {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void demo() {
    	
        WebDriver driver = RunEnvironment.getWebDriver();
        //maximize window
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        
        //Call take screenshot function
        try {
			takeSnapShot(driver, "C:\\Users\\moises.d.ramos\\workspace\\test.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		assertEquals("Google", driver.getTitle());
    }
    
//    @Test
//    public void ikasan_test() {
//    	
//        WebDriver driver = RunEnvironment.getWebDriver();
//        //maximize window
//        driver.manage().window().maximize();
//        driver.get("http://localhost:8080/db-jms-im/login.jsp");
//        
//        WebElement usernameElement = driver.findElement(By.name("j_username")); 
//        WebElement passwordElement = driver.findElement(By.name("j_password"));
//        WebElement formElement = driver.findElement(By.id("loginForm"));
//        
//        usernameElement.sendKeys("admin");
//        passwordElement.sendKeys("admin");
//        
//        formElement.submit();
//        
//        // Anticipate web browser response, with an explicit wait
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement messageElement = wait.until(
//               ExpectedConditions.presenceOfElementLocated(By.className("middle"))
//                );
//     
//        // Run a test
//        String message = messageElement.getText();
//        boolean success = message.contains("Welcome");
//        
//        //Call take screenshot function
//        try {
//			takeSnapShot(driver, "C:\\Users\\moises.d.ramos\\workspace\\test.png");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        assertTrue(success);
//    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
    
    /**
     * This function will take screenshot
     * @param webdriver
     * @param fileWithPath
     * @throws Exception
     */
    public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile=new File(fileWithPath);

        //Copy file at destination
        Files.copy(SrcFile.toPath(), DestFile.toPath());

    }
}
