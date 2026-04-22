import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewOrderPagePOM {

    WebDriver driver;

    @FindBy(css = "div.customCheckbox")
    WebElement checkbox;

    @FindBy(css = "button.btn")
    WebElement buttonSearch;

    @FindBy(css = "div.message_error")
    WebElement messageError;

    public ViewOrderPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
