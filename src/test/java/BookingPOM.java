import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class BookingPOM {

    private SelenideElement sectionBooking = $("div:nth-child(4) >[href=\"/services/booking-management\"]");
    private SelenideElement inputOrderNumber = $(By.id(":r3:"));
    private SelenideElement inputSurname = $(By.id(":r1:"));
    private SelenideElement buttonSearchBooking = $("button.dp-u0lwsb-root-root-submitBtn");

    public void openBooking() {
        sectionBooking.scrollTo().click();
    }

    public void checkOpenBooking() {
        inputOrderNumber.shouldBe(visible);
        inputSurname.shouldBe(visible);
        buttonSearchBooking.shouldBe(visible);
    }

    public void searchBooking(String orderNumber, String surname) {
        inputOrderNumber.sendKeys(orderNumber);
        inputSurname.sendKeys(surname);
        buttonSearchBooking.click();
    }

    public void openAndCheckNewWindow() {
        switchTo().window ("Просмотр заказа");


    }


}
