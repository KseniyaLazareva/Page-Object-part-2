import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.open;


public class TestsPOM {

    HomePagePOM objHomePagePOM;
    SearchPOM objSearchPOM;
    BookingPOM objBookingPOM;
    ViewOrderPagePOM objViewOrderPagePOM;
    WebDriver driver;

    @BeforeEach
    public void setUp() {

        Configuration.browserSize = "1920x1080";
        open("https://www.flypobeda.ru");
    }

    @Test
    public void testPopup() {
        objHomePagePOM = new HomePagePOM();
        objHomePagePOM.pageLoadingCheck();
        objHomePagePOM.hoverOverInfo();
        objHomePagePOM.headerOfPopupCheck();

    }

    @Test
    public void testTicketSearch() {
        objHomePagePOM = new HomePagePOM();
        objSearchPOM = new SearchPOM();
        objHomePagePOM.pageLoadingCheck();
        objSearchPOM.ticketSearchBlockCheck();
        objSearchPOM.entryCity("Москва", "Санкт-Петербург");
        objSearchPOM.clickOnSearchButton();
        objSearchPOM.checkBorderColorFlightThere();
    }

    @Test
    public void testBooking() {
        objHomePagePOM = new HomePagePOM();
        objBookingPOM = new BookingPOM();
        objViewOrderPagePOM = new ViewOrderPagePOM();
        objHomePagePOM.pageLoadingCheck();
        objBookingPOM.openBooking();
        objBookingPOM.checkOpenBooking();
        objBookingPOM.searchBooking("XXXXXX", "Qwerty");
        objBookingPOM.openAndCheckNewWindow();
        objViewOrderPagePOM.clickOnCheckbox();
        objViewOrderPagePOM.clickOnButtonSearch();
        objViewOrderPagePOM.checkErrorMessage();
    }

}
