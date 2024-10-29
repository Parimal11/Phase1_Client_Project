package com.test;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/resources/features", // Path to your feature files
    glue = "stepdefinitions", // Path to your step definitions
    plugin = {
        "pretty", // Print the results in a readable format
        "html:target/cucumber-reports/cucumber.html", // Generate HTML report
        "json:target/cucumber-reports/cucumber.json", // Generate JSON report
        "junit:target/cucumber-reports/cucumber.xml" // Generate XML report
    },
    monochrome = true, // Make the console output more readable
    dryRun = false // Set to true to check for step definitions without running tests
)
public class RunCucumberTest {
}
