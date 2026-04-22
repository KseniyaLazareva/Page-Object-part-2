import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPOM {

    WebDriver driver;

    @FindBy(css = "div:nth-child(4) >[href=\"/services/booking-management\"]")
    WebElement sectionBooking;

    @FindBy(id = ":r3:")
    WebElement inputOrderNumber;

    @FindBy(id = ":r1:")
    WebElement inputSurname;

    @FindBy(css = "button.dp-u0lwsb-root-root-submitBtn")
    WebElement buttonSearchBooking;

    public BookingPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openBooking() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
        sectionBooking.click();
    }

    public void checkOpenBooking() {
        inputOrderNumber.isDisplayed();
        inputSurname.isDisplayed();
        buttonSearchBooking.isDisplayed();
    }

    public void searchBooking(String orderNumber, String surname) {
        inputOrderNumber.sendKeys(orderNumber);
        inputSurname.sendKeys(surname);
        buttonSearchBooking.click();
    }

    public void openAndCheckNewWindow() {
        for (String handle : driver.getWindowHandles()) {
    driver.switchTo().window(handle);
    if (driver.getTitle().contains("Просмотр заказа")) {
        break;
    }
}

    }


}
