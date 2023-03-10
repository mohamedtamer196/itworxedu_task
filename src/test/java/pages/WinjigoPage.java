package pages;

// Import necessary libraries
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WinjigoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Define page elements
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By coursesLink = By.xpath("//a[contains(@href, 'courses')]");
    private final By createCourseButton = By.xpath("//a[@class='btn btn-success']");
    private final By courseTitleField = By.id("title");
    private final By courseDescriptionField = By.id("description");
    private final By coursePriceField = By.id("price");
    private final By saveCourseButton = By.id("submit");
    private final By courseTitleColumn = By.xpath("//table[@id='course-list']//td[contains(text(), 'Course Title')]");

    // Define constructor that initializes driver and wait
    public WinjigoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Define methods to interact with page elements
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void goToCoursesPage() {
        driver.findElement(coursesLink).click();
    }

    public void createCourse(String title, String description, String price) {
        driver.findElement(createCourseButton).click();
        driver.findElement(courseTitleField).sendKeys(title);
        driver.findElement(courseDescriptionField).sendKeys(description);
        driver.findElement(coursePriceField).sendKeys(price);
        driver.findElement(saveCourseButton).click();
    }

    public boolean isCourseTitleDisplayed(String title) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(courseTitleColumn, title));
    }
}


