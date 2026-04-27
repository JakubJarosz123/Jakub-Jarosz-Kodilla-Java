package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();

        Thread.sleep(2000);
        try {
            WebElement acceptCookies = driver.findElement(
                    By.xpath("//button[contains(., 'Allow all cookies') or contains(., 'Zezwól na wszystkie')]")
            );
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookies already accepted or not found.");
        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement createAccountButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(@data-testid,'open-registration-form-button')]")
                )
        );
        createAccountButton.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='birthday_day']"))
        );

        WebElement dayDropdown = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText("15");

        WebElement monthDropdown = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText("Maj");

        WebElement yearDropdown = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText("1995");

        driver.quit();
    }
}
