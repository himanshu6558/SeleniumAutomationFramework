package org.example.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int EXTENDED_TIMEOUT = 20;
    private static final int SHORT_TIMEOUT = 3;

    // Not recommended - use only for debugging
    public static void pauseExecution(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted", e);
        }
    }

    // Sets implicit wait - use with caution, can conflict with explicit waits
    public static void setImplicitWait(WebDriver driver, int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    // Wait for element to be visible with default timeout
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return waitForVisibility(driver, locator, DEFAULT_TIMEOUT);
    }

    // Wait for element to be visible with custom timeout
    public static WebElement waitForVisibility(WebDriver driver, By locator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for element to be visible
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element to be present in DOM
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXTENDED_TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for element to have specific text
    public static boolean waitForElementText(WebDriver driver, WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    // Fluent wait with custom polling
    public static WebElement waitFluently(WebDriver driver, String xpath, int maxTimeInSeconds, int pollingInSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTimeInSeconds))
                .pollingEvery(Duration.ofSeconds(pollingInSeconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(xpath));
            }
        });
    }

    // For direct element access - use with caution
    protected static WebElement findElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }
}
