package com.amazon.utilies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass
{
    public static WebDriver driver;
    @BeforeSuite(alwaysRun = true)
    public void setUpDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUpBrowser(@Optional("chrome") String browser)
    {
        if(browser.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
    }
@AfterMethod(alwaysRun = true)
    public void tearDown()
{
    driver.close();
}

}
