package tests;

import pageObject.MainPage;
import org.junit.Test;
import pageObject.PersonDataFillingPage;

import static org.junit.Assert.assertEquals;

public class ClickButtonsTest extends BaseTest {

    private final String expectedPageTitle = "Для кого самокат";

    @Test
    public void clickTopButton() {

        MainPage mainPage = new MainPage(driver);
        PersonDataFillingPage personDataFillingPage = new PersonDataFillingPage(driver);
        mainPage.clickTopOrderButton();
        personDataFillingPage.getPageTitle();

        String actualPageTitle = personDataFillingPage.getPageTitle();

        assertEquals("Titles are not equal", expectedPageTitle, actualPageTitle);


    }

    @Test
    public void clickBottomButton() {



        MainPage mainPage = new MainPage(driver);
        PersonDataFillingPage personDataFillingPage = new PersonDataFillingPage(driver);
        mainPage.clickBottomOrderButton();
        String actualPageTitle = personDataFillingPage.getPageTitle();

        assertEquals("Titles are not equal", expectedPageTitle, actualPageTitle);


    }

}
