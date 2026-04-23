import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;


public class ViewOrderPagePOM {

    private SelenideElement checkbox = $("div.customCheckbox");
    private SelenideElement buttonSearch = $("button.btn");
    private SelenideElement messageError = $("div.message_error");

    public void clickOnCheckbox() {
        checkbox.click();
    }

    public void clickOnButtonSearch() {
        buttonSearch.click();
    }

    public String getErrorMessage() {
        return messageError.getText();
    }

    public void checkErrorMessage() {
        Assertions.assertEquals("Заказ с указанными параметрами не найден", getErrorMessage());
    }

}
