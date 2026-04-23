import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPOM {
    WebDriver driver;

    @FindBy(id = ":Rlama5durm:")
    WebElement fieldFromWhere;

    @FindBy(id = ":Rlqma5durm:")
    WebElement fieldWhere;

    @FindBy(id = ":Rlcma5durm:")
    WebElement fieldFlightThere;

    @FindBy(id = ":Rtcma5durm:")
    WebElement fieldReturnFlight;

    @FindBy(css = "button [class=\"dp-1a7d7wo-root\"]")
    WebElement buttonSearch;

    @FindBy(xpath = "//*[text()='Москва' and @class='dp-sgi8y9-root-suggestionName']")
    WebElement hintFromWhere;

    @FindBy(xpath = "//*[text()='Санкт-Петербург' and @class='dp-sgi8y9-root-suggestionName']")
    WebElement hintWhere;

    @FindBy(css = "div.dp-9bdwya-root > div > div.dp-1297k38-root > div > div")
    WebElement errorfieldFlightThere;

    public SearchPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ticketSearchBlockCheck() {
        fieldFromWhere.isDisplayed();
        fieldWhere.isDisplayed();
        fieldFlightThere.isDisplayed();
        fieldReturnFlight.isDisplayed();
    }

    public void entryCity(String fromWhere, String where) {
        fieldFromWhere.click();
        fieldFromWhere.sendKeys(fromWhere);
        hintFromWhere.click();
        fieldWhere.click();
        fieldWhere.sendKeys(where);
        hintWhere.click();
    }

    public void clickOnSearchButton() {
        buttonSearch.click();
    }

    public void checkBorderColorFlightThere() {
        Assertions.assertEquals("rgb(213, 0, 98)", errorfieldFlightThere.getCssValue("border-color"));
    }
}
