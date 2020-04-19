package org.example.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
   public NavigationHelper(WebDriver wb) {
      super(wb);
   }

   public void groupPage() {
      if (isElementpresent(By.tagName("h1"))
              && wb.findElement(By.tagName("h1")).getText().equals("Groups")
              && isElementpresent(By.name("new"))) {
         return;
      }
      click(By.linkText("groups"));
   }

   public void gotoHomePage() {
      if (isElementpresent(By.id("maintable"))) {
         return;
      }
      click(By.linkText("home"));
   }
}
