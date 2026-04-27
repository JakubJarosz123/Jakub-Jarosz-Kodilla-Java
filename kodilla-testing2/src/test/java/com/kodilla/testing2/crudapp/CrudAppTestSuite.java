package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {

    private static final String BASE_URL = "https://jakubjarosz123.github.io/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
    }


    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//input[@name='title']";
        final String XPATH_TASK_CONTENT = "//textarea[@name='content']";
        final String XPATH_ADD_BUTTON = "//button[@type='submit']";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement name = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(XPATH_TASK_NAME))
        );
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        Thread.sleep(2000);
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[1]")));

        driver.findElements(By.xpath("//form[@class='datatable_row']")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class='datatable_field-value']"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreatedCard = theForm.findElement(
                            By.xpath(".//button[contains(@class, 'card-creation')]")
                    );
                    buttonCreatedCard.click();
                });

        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        boolean result = false;

        ChromeOptions options = new ChromeOptions();
        // Podaj ścieżkę do swojego profilu Chrome - sprawdź w chrome://version -> Profile Path
        options.addArguments("C:\\Users\\jakub\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        options.addArguments("profile-directory=Default");

        WebDriver driverTrello = new ChromeDriver(options);
        driverTrello.get("https://trello.com");

        WebDriverWait wait = new WebDriverWait(driverTrello, 20);

        System.out.println("URL po otwarciu: " + driverTrello.getCurrentUrl());

        Thread.sleep(5000);
        System.out.println("URL po logowaniu: " + driverTrello.getCurrentUrl());
        System.out.println("Tytuł strony: " + driverTrello.getTitle());

        driverTrello.findElements(By.tagName("a")).stream()
                .filter(a -> a.getAttribute("href") != null)
                .forEach(a -> System.out.println("LINK -> href: " + a.getAttribute("href") + " | text: " + a.getText()));

        driverTrello.findElements(By.xpath("//a[contains(@href, '/b/')]")).stream()
                .filter(aHref -> aHref.getText().contains("Kodilla Application"))
                .findFirst()
                .ifPresent(WebElement::click);

        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        System.out.println("Wynik: " + result);

        driverTrello.close();
        return result;
    }

    private boolean deleteTaskInCrudApp(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='datatable_row']")));

        driver.findElements(By.xpath("//form[@class='datatable_row']")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class='datatable_field-value']"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement deleteButton = theForm.findElement(
                            By.xpath(".//*[@data-task-delete-button]")
                    );
                    deleteButton.click();
                });

        Thread.sleep(2000);

        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section")));

        boolean result = driver.findElements(By.xpath("//form[@class='datatable_row']")).stream()
                .noneMatch(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class='datatable_field-value']"))
                                .getText().equals(taskName));

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        assertTrue(deleteTaskInCrudApp(taskName));
    }
}
