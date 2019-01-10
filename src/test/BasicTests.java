import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class BasicTests {

    @Test
    public void testBrowseInTabs() {

        open("http://localhost:8080/testing/page.html");
        WebDriver driver = driver().getWebDriver();
        String openLinkInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElements(By.cssSelector("a")).get(0).sendKeys(openLinkInNewTab);

        // two tabs should be present
        Wait().until(numberOfWindowsToBe(2));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // first tab is in focus
        assertEquals("page", driver.findElements(By.cssSelector("h1")).get(0).getText());
        driver.switchTo().window(tabs.get(1));
        assertEquals("hello", driver.findElements(By.cssSelector("h1")).get(0).getText());
    }
}
