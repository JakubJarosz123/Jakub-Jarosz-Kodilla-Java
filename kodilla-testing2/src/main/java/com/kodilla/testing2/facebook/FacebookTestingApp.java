package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookTestingApp {

    public static final String XPATH_ALLOW_COOKIES = "div[role='dialog'] button";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

//        Thread.sleep(6000);
//
//        try {
//            WebElement allowCookies = driver.findElement(By.cssSelector(XPATH_ALLOW_COOKIES));
//            allowCookies.click();
//        } catch (Exception e) {
//            System.out.println("Cookies not found" + e.getMessage());
//        }
    }
}
