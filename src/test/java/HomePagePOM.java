import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePagePOM {

    private SelenideElement logo = $("a.dp-1c65d1k-root-root-root > img");
    private SelenideElement info = $("[href=\"/information\"]");
    private SelenideElement headerFlight = $x("//*[text()='Подготовка к полёту']");
    private SelenideElement headerUseful = $x("//*[text()='Полезная информация']");
    private SelenideElement headerCompany = $x("//div[@class='dp-k3o5jh-root']//*[text()='О компании']");


    public void pageLoadingCheck() {
        Assertions.assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками", Selenide.title());
        logo.shouldBe(visible);
    }

    public void hoverOverInfo() {
        info.hover();
    }

    public void headerOfPopupCheck() {
        headerFlight.shouldBe(visible);
        headerUseful.shouldBe(visible);
        headerCompany.shouldBe(visible);
    }
}
