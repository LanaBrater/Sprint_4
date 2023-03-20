package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    private final String uri = "https://qa-scooter.praktikum-services.ru/";

    private static final By COOKIE_BUTTON =
            By.cssSelector(".App_CookieButton__3cvqF");
    protected WebDriver driver;

    @Before
    public void beforeTest() {
        driver = myGetDriver("chrome");
        driver.get(uri);
        driver.findElement(COOKIE_BUTTON).click();
    }

    private WebDriver myGetDriver(String browserName) {
        WebDriver driver;
        switch (browserName) {
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default: {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origin");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            }
        }
        return driver;
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}

