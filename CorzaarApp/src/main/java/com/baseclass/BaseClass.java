package com.baseclass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.Duration;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	 private static final Duration TIMEOUT = Duration.ofSeconds(20); 
	 
	  public static void click(AndroidDriver driver,WebElement element) {

	        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	        element.click();
	    }

	    public static  void sendKeys( AndroidDriver driver, WebElement element,String text) {

	        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
	        wait.until( ExpectedConditions.visibilityOf(element));
	        //element.click();
	        element.sendKeys(text);
	    }
 

    public static boolean displayed(AndroidDriver driver, WebElement element) {

        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


   
    public static void takeScreenshot(AndroidDriver driver,String fileName) throws Exception {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots/" + fileName + ".png");
        FileUtils.copyFile(source, destination);
    }


    

    public static void visibilityWait( AndroidDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver,TIMEOUT);
        wait.until( ExpectedConditions.visibilityOf(element));
    }


    

    public static void clickableWait(AndroidDriver driver,WebElement element) {

        WebDriverWait wait =new WebDriverWait(driver,TIMEOUT);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }




    public static void swipeUp(
            AndroidDriver driver) {

        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 100,
                        "top", 100,
                        "width", 200,
                        "height", 600,
                        "direction", "up",
                        "percent", 0.75
                ));
    }


    

    public static void swipeDown(
            AndroidDriver driver) {

        driver.executeScript(
                "mobile: scrollGesture",
                Map.of(
                        "left", 100,
                        "top", 400,
                        "width", 800,
                        "height", 1400,
                        "direction", "down",
                        "percent", 0.9
                ));
    }
    
    public static String getText(AndroidDriver driver, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

        wait.until(ExpectedConditions.visibilityOf(element));

        return element.getText().trim();

    }

    public static void hideKeyboard(AndroidDriver driver) {

        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }
    }

    // scrolls the screen until the text is visible, returns that element
    public static WebElement scrollToText(AndroidDriver driver, String text) {

        return driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).setMaxSearchSwipes(6)"
                        + ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
    }

    // true if a label (TextView) with this text is on the screen after scrolling - typed values are ignored
    public static boolean textOnScreen(AndroidDriver driver, String text) {

        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).setMaxSearchSwipes(6)"
                            + ".scrollIntoView(new UiSelector().className(\"android.widget.TextView\").textContains(\""
                            + text + "\"))"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // clicks a tab of the Institute portal, swiping the tab strip first if the tab is off screen
    public static void clickTab(AndroidDriver driver, WebElement tab, WebElement anyTab) {

        for (int i = 0; i < 4 && !displayed(driver, tab); i++) {
            swipeTabs(driver, anyTab, "left");
        }
        for (int i = 0; i < 6 && !displayed(driver, tab); i++) {
            swipeTabs(driver, anyTab, "right");
        }
        click(driver, tab);
    }

    public static void swipeTabs(AndroidDriver driver, WebElement anyTab, String direction) {

        Dimension screen = driver.manage().window().getSize();
        Rectangle tab = anyTab.getRect();
        driver.executeScript("mobile: swipeGesture", Map.of("left", 10, "top", tab.getY(), "width", screen.width - 20,
                "height", Math.max(tab.getHeight(), 20), "direction", direction, "percent", 0.7));
    }

    public static String timeStamp() {

        return new SimpleDateFormat("HHmmss").format(new Date());
    }
}
