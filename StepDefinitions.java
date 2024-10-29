package stepdefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import com.project.pages.Page;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    private WebDriver driver;
    private Page page;

    @SuppressWarnings("deprecation")
	@Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver(); // Use the class-level driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set implicit wait
        page = new Page(driver);
        driver.get("http://localhost:4200/register"); // Adjust the URL as necessary
    }

    @When("I enter {string} as username")
    public void i_enter_as_username(String username) {
        page.registerUser(username, "", ""); // Placeholder for email and password
    }

    @When("I enter {string} as email in register")
    public void i_enter_as_email_in_register(String email) {
        page.registerUser("", email, ""); // Placeholder for username and password
    }

    @When("I enter {string} as password in register")
    public void i_enter_as_password_in_register(String password) {
        page.registerUser("", "", password); // Placeholder for username and email
    }

    @When("I submit the registration form")
    public void i_submit_the_registration_form() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("registerButton"))); // Replace with actual ID
        JavascriptExecutor js = (JavascriptExecutor) driver;
 
        
        // Click using JavaScript if necessary
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        Assert.assertTrue("Success message not displayed", driver.getPageSource().contains("Registration successful")); // Example message
    }

    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
    	String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:4200/login"; // Adjust as necessary
        Assert.assertEquals("User is not redirected to the login page", expectedUrl, currentUrl);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
    }

    @When("I enter {string} as email in login")
    public void i_enter_as_email_in_login(String email) {
        page.loginUser(email, ""); // Placeholder for password
    }

    @When("I enter {string} as password in login")
    public void i_enter_as_password_in_login(String password) {
        page.loginUser("", password); // Placeholder for email
    }

    @When("I submit the login form")
    public void i_submit_the_login_form() {
        // Locate the submit button using its ID or another selector
        WebElement submitButton = driver.findElement(By.name("loginButton")); // Replace with actual ID
        submitButton.click(); // Click the submit button to submit the login form
    }

    @Then("I should see the portfolios page")
    public void i_should_see_the_portfolios_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Portfolios page not displayed", currentUrl.contains("/portfolios"));
    }

    @Given("I am on the portfolios page")
    public void i_am_on_the_portfolios_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/portfolios");
    }

    @When("I enter {string} as portfolio name")
    public void i_enter_as_portfolio_name(String portfolioName) {
        page.addPortfolio(portfolioName, ""); // Placeholder for description
    }

    @When("I enter {string} as description")
    public void i_enter_as_description(String description) {
        page.addPortfolio("", description); // Placeholder for portfolio name
    }

    @When("I submit the portfolio form")
    public void i_submit_the_portfolio_form() {
        WebElement submitButton = driver.findElement(By.name("submitPortfolioButton")); // Replace with actual ID
        submitButton.click(); // Click the submit button to submit the portfolio form
    }

    @Then("I should see {string} in the portfolio list")
    public void i_should_see_in_the_portfolio_list(String portfolioName) {
        Assert.assertTrue("Portfolio not found in the list", driver.getPageSource().contains(portfolioName));
    }

    @Then("I should be redirected to the project tasks page")
    public void i_should_be_redirected_to_the_project_tasks_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Project tasks page not displayed", currentUrl.contains("/project-tasks"));
    }

    @Given("I am on the project tasks page")
    public void i_am_on_the_project_tasks_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/project-tasks");
    }

    @When("I enter {string} as task title")
    public void i_enter_as_task_title(String taskTitle) {
        page.addTask(taskTitle, ""); // Placeholder for status
    }

    @When("I select {string} as status")
    public void i_select_as_status(String status) {
        page.addTask("", status); // Placeholder for task title
    }

    @When("I submit the task form")
    public void i_submit_the_task_form() {
        WebElement submitButton = driver.findElement(By.name("submitTaskButton")); // Replace with actual ID
        submitButton.click(); // Click the submit button to submit the task form
    }

    @Then("I should see {string} in the project tasks list")
    public void i_should_see_in_the_project_tasks_list(String taskTitle) {
        Assert.assertTrue("Task not found in the list", driver.getPageSource().contains(taskTitle));
    }

    @Then("I should be redirected to the schedule meeting page")
    public void i_should_be_redirected_to_the_schedule_meeting_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Schedule meeting page not displayed", currentUrl.contains("/schedule-meeting"));
    }

    @Given("I am on the schedule meeting page")
    public void i_am_on_the_schedule_meeting_page() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // Update with your path
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/schedule-meeting");
    }

    @When("I enter {string} as title")
    public void i_enter_as_title(String title) {
        page.scheduleMeeting(title, "", ""); // Placeholder for date and time
    }

    @When("I enter {string} as date")
    public void i_enter_as_date(String date) {
        page.scheduleMeeting("", date, ""); // Placeholder for title and time
    }

    @When("I enter {string} as time")
    public void i_enter_as_time(String time) {
        page.scheduleMeeting("", "", time); // Placeholder for title and date
    }

    @When("I submit the meeting form")
    public void i_submit_the_meeting_form() {
        WebElement submitButton = driver.findElement(By.name("submitMeetingButton")); // Replace with actual ID
        submitButton.click(); // Click the submit button to submit the meeting form
    }

    @Then("I should see a success message for meeting")
    public void i_should_see_a_success_message_for_meeting() {
        Assert.assertTrue("Meeting success message not displayed", driver.getPageSource().contains("Meeting scheduled successfully")); // Example message
    }

    @Then("I should see {string} in the scheduled meetings")
    public void i_should_see_in_the_scheduled_meetings(String meetingTitle) {
        Assert.assertTrue("Meeting not found in the scheduled meetings", driver.getPageSource().contains(meetingTitle));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Closes the browser and quits the driver
        }
    }
}