package com.baseclass;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	private static final Duration TIMEOUT = Duration.ofSeconds(20);

	public static void click(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void sendKeys(AndroidDriver driver, WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	public static boolean displayed(AndroidDriver driver, WebElement element) {

		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static void visibilityWait(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getText(AndroidDriver driver, WebElement element) {

		visibilityWait(driver, element);
		return element.getText().trim();
	}

	public static void hideKeyboard(AndroidDriver driver) {

		if (driver.isKeyboardShown()) {
			driver.hideKeyboard();
		}
	}

	public static WebElement scrollToText(AndroidDriver driver, String text) {

		return driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().className(\"android.widget.ScrollView\")).setMaxSearchSwipes(6)"
						+ ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"));
	}

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

	public static boolean waitForText(AndroidDriver driver, String text) throws InterruptedException {

		for (int i = 0; i < 3; i++) {
			if (textOnScreen(driver, text)) {
				return true;
			}
			Thread.sleep(1000);
		}
		return false;
	}

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

	public static int getCount(AndroidDriver driver, WebElement element) {

		String digits = getText(driver, element).replaceAll("\\D", "");
		return digits.isEmpty() ? 0 : Integer.parseInt(digits);
	}

	public static int getCountByLabel(AndroidDriver driver, String label) {

		String number = ".fromParent(new UiSelector().textMatches(\"\\\\d+\"))";
		try {
			return getCount(driver, driver.findElement(
					AppiumBy.androidUIAutomator("new UiSelector().text(\"" + label + "\")" + number)));
		} catch (Exception e) {
			return getCount(driver, driver.findElement(
					AppiumBy.androidUIAutomator("new UiSelector().textContains(\"" + label + "\")" + number)));
		}
	}

	public static int getSize(AndroidDriver driver, List<WebElement> elements) {

		return elements.size();
	}

	public static String timeStamp() {

		return new SimpleDateFormat("HHmmss").format(new Date());
	}
}
