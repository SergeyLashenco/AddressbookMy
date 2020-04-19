package org.example.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   private final Properties properties;
   private WebDriver wb;

   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
 //  private ContactHelper contactHelper;
   private String browser;


   public ApplicationManager(String browser) {
      this.browser = browser;
      properties = new Properties();
   }


   public void init() throws IOException {
      initDriver();
      String target = System.getProperty("target", "local");
      properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

      // baseUrl = "https://www.katalon.com/";
      wb.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      wb.get(properties.getProperty("web.baseUrl"));
      groupHelper = new GroupHelper(wb);
      navigationHelper = new NavigationHelper(wb);
      sessionHelper = new SessionHelper(wb);
     // contactHelper = new ContactHelper(wb);
      sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
   }

   private void initDriver(){
      if (browser == null || "chrome".equals(browser.toLowerCase())) {
         File file = new File("./src/drivers/chromedriver");
         System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable-notifications");
         wb = new ChromeDriver();
      } else if ("firefox".equals(browser)) {
         File file = new File("./src/drivers/geckodriver");
         System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
         FirefoxOptions profile = new FirefoxOptions();
         profile.addArguments("--disable-notifications");
         wb = new FirefoxDriver();
      }
   }



   public void stop() {
      wb.quit();
   }

   public GroupHelper group() {
      return groupHelper;
   }

   public NavigationHelper goTo() {
      return navigationHelper;
   }

   /*
    public ContactHelper contact() {
      return contactHelper;
   }

   public  DbHelper db () {
      return dbHelper;
   }
    */

}




/*
 String target = System.getProperty("target", "local");
      properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


      File file = new File("./src/drivers/chromedriver");
      System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
      switch (browser) {
         case BrowserType.FIREFOX:
            wb = new FirefoxDriver();
            break;
         case BrowserType.CHROME:
            wb = new ChromeDriver();
            break;
         case BrowserType.IE:
            wb = new InternetExplorerDriver();
            break;
      }
 */