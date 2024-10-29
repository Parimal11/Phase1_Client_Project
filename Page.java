package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    // Registration Methods
    public void registerUser(String username, String email, String password) {
        waitForElement(By.id("username")).sendKeys(username); // Username input
        waitForElement(By.id("email")).sendKeys(email); // Email input
        waitForElement(By.id("password")).sendKeys(password); // Password input
        waitForElement(By.name("registerButton")).click(); // Register button
        handleAlert(); // Handle alert after registration
    }

    // Login Methods
    public void loginUser(String email, String password) {
        waitForElement(By.id("email")).sendKeys(email); // Email input
        waitForElement(By.id("password")).sendKeys(password); // Password input
        waitForElement(By.name("loginButton")).click(); // Login button
    }

    // Portfolio Methods
    public void addPortfolio(String portfolioName, String description) {
        waitForElement(By.id("portfolioName")).sendKeys(portfolioName); // Portfolio name input
        waitForElement(By.id("portfolioDescription")).sendKeys(description); // Description input
        waitForElement(By.name("submitPortfolioButton")).click(); // Add Portfolio button
    }

    // Task Methods
    public void addTask(String taskTitle, String status) {
        waitForElement(By.id("taskTitle")).sendKeys(taskTitle); // Task title input
        waitForElement(By.id("taskStatus")).sendKeys(status); // Status dropdown (you may want to select from dropdown)
        waitForElement(By.id("submitTaskButton")).click(); // Add Task button
    }

    // Meeting Methods
    public void scheduleMeeting(String title, String date, String time) {
        waitForElement(By.id("meetingTitle")).sendKeys(title); // Meeting title input
        waitForElement(By.id("meetingDate")).sendKeys(date); // Meeting date input
        waitForElement(By.id("meetingTime")).sendKeys(time); // Meeting time input
        waitForElement(By.name("submitMeetingButton")).click(); // Schedule Meeting button
        handleAlert(); // Handle alert after scheduling a meeting
    }

    // Wait for element to be present and visible
    private WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Alert handling method
    private void handleAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert text: " + alertText);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Alert did not appear or could not be handled.");
        }
    }
}