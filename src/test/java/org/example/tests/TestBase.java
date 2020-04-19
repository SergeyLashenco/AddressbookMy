package org.example.tests;

import org.example.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

   protected static final ApplicationManager app
           = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
   @BeforeSuite
   public void setUp() throws IOException {
      app.init();
   }

   @AfterSuite(alwaysRun = true)
   public void tearDown() {
      app.stop();
   }

  /*
   @BeforeMethod
   public  void  logTestStart(Method m, Object[] p  ){
      logger.info("Start " + m.getName() + " with parameters " + Arrays.asList(p));

   }

    @AfterMethod(alwaysRun = true)
   public  void  logTestStop(Method m){
      logger.info("Stop " + m.getName());

   }
   */

}
