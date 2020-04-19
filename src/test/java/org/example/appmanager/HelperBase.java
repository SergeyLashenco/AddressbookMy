package org.example.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {
   WebDriver wb;

   public HelperBase(WebDriver wb) {
      this.wb = wb;
   }

   protected void click(By locator) {
      wb.findElement(locator).click();
   }

   protected void type(By locator, String text) {
      click(locator);
      if (text != null) {
         String existingText = wb.findElement(locator).getAttribute("value");
         if (!text.equals(existingText)) {
            wb.findElement(locator).clear();
            wb.findElement(locator).sendKeys(text);
         }
      }
   }

   protected void attach(By locator, File file) {
      if (file != null) {
         wb.findElement(locator).sendKeys(file.getAbsolutePath());
      }
   }

   public boolean isAlertPresent() {
      try {
         wb.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   protected boolean isElementpresent(By locator) {
      try {
         wb.findElement(locator);
         return true;
      } catch (NoSuchElementException ex) {
         return false;
      }

   }
}
