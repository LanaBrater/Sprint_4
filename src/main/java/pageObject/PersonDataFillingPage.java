package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonDataFillingPage {

    private WebDriver driver;


    //Заголовок формы заказа
    private static final By ORDER_FORM_TITLE =
            By.cssSelector(".Order_Header__BZXOb");

    //Поле ввода имени
    private static final By INPUT_NAME_FIELD =
            By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Имя']");

    //Поле ввода фамилии
    private static final By INPUT_SURNAME_FIELD =
            By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Фамилия']");

    //Поле ввода адреса
    private static final By INPUT_ADDRESS_FIELD =
            By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Адрес: куда привезти заказ']");

    //Выпадающий список станций метро
    private static final By METRO_STATION_SELECTOR =
            By.cssSelector(".select-search__input");

    //Поле ввода номера телефона
    private static final By INPUT_PHONE_NUMBER_FIELD =
            By.cssSelector(".Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private static final By NEXT_BUTTON =
            By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public PersonDataFillingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка отображения заголовка формы
    public String getPageTitle(){
        return driver.findElement(ORDER_FORM_TITLE).getText();
    }

    //Заполнение поля Имя
    public void setInputNameField(String name){
        driver.findElement(INPUT_NAME_FIELD).sendKeys(name);
    }

    //Заполнение поля Фамилия
    public void setInputSurnameField(String surname){
        driver.findElement(INPUT_SURNAME_FIELD).sendKeys(surname);
    }

    //Заполение поля Адрес
    public void setInputAddressField(String address){
        driver.findElement(INPUT_ADDRESS_FIELD).sendKeys(address);
    }

    //Выбор станции метро
    public void chooseMetroStation(String station){
        driver.findElement(METRO_STATION_SELECTOR).sendKeys(station);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String locator = String.format(metroOptionTemplate, station);
        driver.findElement(By.xpath(locator)).click();
    }

    //Ввод номера телефона
    public void setInputPhoneNumberField(String phoneNumber){
        driver.findElement(INPUT_PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }

    //Нажатие кнопка Далее
    public void clickNextButton(){
        driver.findElement(NEXT_BUTTON).click();
    }

}
