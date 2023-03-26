package tests;

import org.hamcrest.MatcherAssert;
import page_object.AboutRentPage;
import page_object.MainPage;
import page_object.PersonDataFillingPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
 public class ScooterOrderTest extends BaseTest {
    private String nameField;
    private String surnameField;
    private String addressField;
    private String metroStationSelect;
    private String phoneNumberField;
    private String deliveryDate;
    private String rentDuration;
    private String scooterColour;
    private String commentForDeliveryMan;
    private boolean result;

    public ScooterOrderTest(String nameField, String surnameField, String addressField,
                                  String metroStationSelect, String phoneNumberField,String deliveryDate, String rentDuration,String scooterColour, String commentForDeliveryMan,boolean result) {
        this.nameField = nameField;
        this.surnameField = surnameField;
        this.addressField = addressField;
        this.metroStationSelect = metroStationSelect;
        this.phoneNumberField = phoneNumberField;
        this.deliveryDate = deliveryDate;
        this.rentDuration = rentDuration;
        this.scooterColour = scooterColour;
        this.commentForDeliveryMan = commentForDeliveryMan;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] personData() {
        return new Object[][]{
                {"Имя", "Фамилия", "г.Москва,Красная площадь,1", "Охотный Ряд", "89998887766","30.03.2023", "сутки", "black", "Вези быстрее",true},
                {"ЕщеИмя", "ЕщеФамилия", "г.Москва,Лубянка,2", "Лубянка", "89991112233","31.03.2023", "пятеро суток", "grey", "Хочу кататься!",true},
        };
    }

        @Test
        public void rentScooter() {
            MainPage mainPage = new MainPage(driver);
            PersonDataFillingPage personDataFillingPage = new PersonDataFillingPage(driver);
            AboutRentPage aboutRentPage = new AboutRentPage(driver);

            mainPage.enterPage();
            mainPage.clickCookieButton();
            mainPage.clickTopOrderButton();
            personDataFillingPage.getPageTitle();

            personDataFillingPage.setInputNameField(nameField);
            personDataFillingPage.setInputSurnameField(surnameField);
            personDataFillingPage.setInputAddressField(addressField);
            personDataFillingPage.chooseMetroStation(metroStationSelect);
            personDataFillingPage.setInputPhoneNumberField(phoneNumberField);

            personDataFillingPage.clickNextButton();

            aboutRentPage.checkAboutRentPageTitle();
            aboutRentPage.chooseDeliveryDate(deliveryDate);
            aboutRentPage.chooseRentDuration(rentDuration);
            aboutRentPage.chooseScooterColour(scooterColour);
            aboutRentPage.setCommentForDeliveryMan(commentForDeliveryMan);

            aboutRentPage.clickOrderButtonInsideOfForm();
            aboutRentPage.clickYesButton();

            String expected = "Заказ оформлен";
            String actual = aboutRentPage.checkConfirmationWindow();
            MatcherAssert.assertThat(actual, startsWith(expected));

        }
}
