package pages;

// Import necessary libraries

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class CreateCourseSteps {
    private WebDriver driver;
    private WinjigoPage winjigoPage;

    @Given("I am logged in as {string} with password {string}")
    public void login(String username, String password) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swinji.azurewebsites.net");
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        winjigoPage = new WinjigoPage(driver);

        driver.get("https://swinji.azurewebsites.net/");
        winjigoPage.login(username, password);
    }


    @When("I create a new course with title {string}, description {string}, and price {string}")
    public void createCourse(String title, String description, String price) {
        winjigoPage.goToCoursesPage();
        winjigoPage.createCourse(title, description, price);
    }
    @Then("I should see the course title {string} displayed in the courses list")
    public void verifyCourseTitle(String title) {
        boolean isDisplayed = winjigoPage.isCourseTitleDisplayed(title);
        assertTrue(isDisplayed);

        driver.quit();
    }
}

