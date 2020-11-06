import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import java.awt.image.BufferedImage;

public class Pages {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public Pages(WebDriver webdriver){
        this.webDriver = webdriver;
        wait = new WebDriverWait(webDriver, 2);
    }

    public void writeToAuthUsername(String data){
        WebElement element =  webDriver.findElement(Locators.authUsername);
        element.sendKeys(data);
    }

    public void writeToAuthPassword(String data){
        WebElement element = webDriver.findElement(Locators.authPassword);
        element.sendKeys((data));
    }

    public void pressLoginButton(){
        WebElement element = webDriver.findElement(Locators.authLogin);
        element.click();
    }

    public void goToWebsite(String data) {
        webDriver.get(data);
    }

    public boolean isPresentLogoutButton() {
        return webDriver.findElements(Locators.brandLogout).size() != 0;
    }

    public void waitForLogoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.brandLogout));
    }

    public void clickLetMeHackButton() {
        webDriver.findElement(Locators.headButton).click();
    }

    public void waitForLetMeHackButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.headButton));
    }

    public BufferedImage takeScreenshot(){
        Screenshot screenshot = new AShot().takeScreenshot(webDriver);
        return screenshot.getImage();
    }
}
