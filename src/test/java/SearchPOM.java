import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class SearchPOM {

    private SelenideElement fieldFromWhere = $(By.id(":Rlama5durm:"));
    private SelenideElement fieldWhere = $(By.id(":Rlqma5durm:"));
    private SelenideElement fieldFlightThere = $(By.id(":Rlcma5durm:"));
    private SelenideElement fieldReturnFlight = $(By.id(":Rtcma5durm:"));
    private SelenideElement buttonSearch = $("button [class=\"dp-1a7d7wo-root\"]");
    private SelenideElement hintFromWhere = $x("//*[text()='Москва' and @class='dp-sgi8y9-root-suggestionName']");
    private SelenideElement hintWhere = $x("//*[text()='Санкт-Петербург' and @class='dp-sgi8y9-root-suggestionName']");
    private SelenideElement errorfieldFlightThere = $("div.dp-9bdwya-root > div > div.dp-1297k38-root > div > div");

    public void ticketSearchBlockCheck() {
        fieldFromWhere.shouldBe(visible);
        fieldWhere.shouldBe(visible);
        fieldFlightThere.shouldBe(visible);
        fieldReturnFlight.shouldBe(visible);
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
