package com.pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CoursesPage {

    public AndroidDriver driver;

	public CoursesPage(AndroidDriver driver) {
		this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),this);

    }

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Courses\")")
    public WebElement coursesTab;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Add course\")")
    public WebElement addCourseButton;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"e.g. Advanced Excel\")")
    public WebElement courseTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"What will students learn?\")")
    public WebElement courseDescription;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Technology\")")
    public WebElement technologyCategory;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"8 weeks\")")
    public WebElement courseDuration;

    @AndroidFindBy(xpath ="//android.widget.EditText[@resource-id=\"course-fees\"]")
    public WebElement courseFee;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Submit for admin review\")")
    public WebElement submitForReview;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"submitted for admin review\")")
    public WebElement submittedMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Add a course title\")")
    public WebElement titleError;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"(?i)published\")")
    public List<WebElement> publishedCourses;
}
