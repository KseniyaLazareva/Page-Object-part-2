import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
    WebDriver driver;

    @FindBy(css = "a.dp-1c65d1k-root-root-root > img")
    WebElement logo;

    @FindBy(css = "[href=\"/information\"]")
    WebElement info;

    @FindBy(xpath = "//*[text()='Подготовка к полёту']")
    WebElement headerFlight;

    @FindBy(xpath = "//*[text()='Полезная информация']")
    WebElement headerUseful;

    @FindBy(xpath = "//div[@class='dp-k3o5jh-root']//*[text()='О компании']")
    WebElement headerCompany;

    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pageLoadingCheck() {
        Assertions.assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками", driver.getTitle());
        logo.isDisplayed();
    }

    public void hoverOverInfo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(info).perform();
    }

    public void headerOfPopupCheck() {
        headerFlight.isDisplayed();
        headerUseful.isDisplayed();
        headerCompany.isDisplayed();
    }
}
