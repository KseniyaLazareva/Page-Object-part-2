import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class TestsPOM {

    HomePagePOM objHomePagePOM;
    SearchPOM objSearchPOM;
    BookingPOM objBookingPOM;
    ViewOrderPagePOM objViewOrderPagePOM;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flypobeda.ru");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPopup() {
        objHomePagePOM = new HomePagePOM(driver);
        objHomePagePOM.pageLoadingCheck();
        objHomePagePOM.hoverOverInfo();
        objHomePagePOM.headerOfPopupCheck();

    }

    @Test
    public void testTicketSearch() {
        objHomePagePOM = new HomePagePOM(driver);
        objSearchPOM = new SearchPOM(driver);
        objHomePagePOM.pageLoadingCheck();
        objSearchPOM.ticketSearchBlockCheck();
        objSearchPOM.entryCity("Москва", "Санкт-Петербург");
        objSearchPOM.clickOnSearchButton();
        objSearchPOM.checkBorderColorFlightThere();
    }

    @Test
    public void testBooking() {
        objHomePagePOM = new HomePagePOM(driver);
        objBookingPOM = new BookingPOM(driver);
        objViewOrderPagePOM = new ViewOrderPagePOM(driver);
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
