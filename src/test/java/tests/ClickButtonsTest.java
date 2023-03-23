package tests;

import page_object.MainPage;
import org.junit.Test;
import page_object.PersonDataFillingPage;

import static org.junit.Assert.assertEquals;

public class ClickButtonsTest extends BaseTest{

    private final String expectedPageTitle = "Для кого самокат";
    @Test
    public void clickTopButton() {
        MainPage mainPage = new MainPage(driver);
        PersonDataFillingPage personDataFillingPage = new PersonDataFillingPage(driver);

        mainPage.enterPage();
        mainPage.clickCookieButton();
        mainPage.clickTopOrderButton();
        personDataFillingPage.getPageTitle();

        String actualPageTitle = personDataFillingPage.getPageTitle();

        assertEquals("Titles are not equal", expectedPageTitle, actualPageTitle);


    }

    @Test
    public void clickBottomButton() {

        MainPage mainPage = new MainPage(driver);
        PersonDataFillingPage personDataFillingPage = new PersonDataFillingPage(driver);

        mainPage.enterPage();
        mainPage.clickCookieButton();
        mainPage.clickBottomOrderButton();
        String actualPageTitle = personDataFillingPage.getPageTitle();

        assertEquals("Titles are not equal", expectedPageTitle, actualPageTitle);


    }
}
