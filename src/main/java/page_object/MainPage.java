package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private final String uri = "https://qa-scooter.praktikum-services.ru/";
    private static final By COOKIE_BUTTON =
            By.cssSelector(".App_CookieButton__3cvqF");

    //Кнопка Заказать вверху
    private static final By TOP_ORDER_BUTTON =
            By.cssSelector(".Button_Button__ra12g");

    //Кнопка Заказать внизу
    private static final By BOTTOM_ORDER_BUTTON =
            By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private static String[] questionArrowButtons = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    };
    private static String[] answerArrowFields = new String[] {
            "//div[@id='accordion__panel-0']/p",
            "//div[@id='accordion__panel-1']/p",
            "//div[@id='accordion__panel-2']/p",
            "//div[@id='accordion__panel-3']/p",
            "//div[@id='accordion__panel-4']/p",
            "//div[@id='accordion__panel-5']/p",
            "//div[@id='accordion__panel-6']/p",
            "//div[@id='accordion__panel-7']/p"
    };
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Вход на страницу
    public void enterPage() {
        driver.get(uri);
    }
    //Нажать на кнопку кук
    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }
    //Нажать на верхнюю кнопку Заказать
    public void clickTopOrderButton() {
        driver.findElement(TOP_ORDER_BUTTON).click();
    }
    //Нажать на нижнюю кнопку Заказать
    public void clickBottomOrderButton() {
        driver.findElement(BOTTOM_ORDER_BUTTON);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(BOTTOM_ORDER_BUTTON));
        driver.findElement(BOTTOM_ORDER_BUTTON).click();
    }
    //Проверка нажатия на стрелочки
    public void clickCursorArrowOfDropdown1(int index){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(By.id(questionArrowButtons[index])));
        driver.findElement(By.id(questionArrowButtons[index])).click();
    }
    //Проверка текста элемента стрелочек
    public String getDropdownText1(int index){
        return driver.findElement(By.xpath(answerArrowFields[index])).getText();
    }

}
