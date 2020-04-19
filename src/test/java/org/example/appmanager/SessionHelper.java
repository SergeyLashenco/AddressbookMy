package org.example.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
   public SessionHelper(WebDriver wb) {
      super(wb);
   }

   public void login(String userName, String password) {

      try {
         wb.get("http://localhost/addressbook/index.php");
         type(By.name("user"), userName);
         type(By.name("pass"), password);
         click(By.xpath(
                 "(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]"));
      } catch (Exception ex) {
         System.out.println(" На данный момент не запущен XAMP авторизация не возможна");
         ex.printStackTrace();
         wb.quit();
      }
   }
}
