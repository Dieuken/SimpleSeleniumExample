import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test {

    private String path = System.getProperty("user.dir");

    private WebDriver driver;
    /**
     * Rigorous Test :-)
     */

    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", path + "/src/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @org.junit.Test
    public void testLogin() throws InterruptedException {



        Pages page = new Pages(driver);

        page.goToWebsite("https://automationintesting.online/#/admin");

        Thread.sleep(1000);

        page.writeToAuthUsername("admin");

        page.writeToAuthPassword("password");

        Thread.sleep(1000);

        page.pressLoginButton();

        page.waitForLogoutButton();

        assertTrue( page.isPresentLogoutButton() );

    }

    @org.junit.Test
    public void ScreenshotTest() throws IOException {

        Pages pages = new Pages(driver);

        pages.goToWebsite("https://team1.automationintesting.online/#/");

        pages.waitForLetMeHackButton();

        BufferedImage expectedImage = pages.takeScreenshot();

        pages.clickLetMeHackButton();

        BufferedImage actualImage = pages.takeScreenshot();

        ImageIO.write(expectedImage, "png", new File(path + "/screenshots/expectedScreenshot.png"));
        ImageIO.write(actualImage, "png", new File(path + "/screenshots/actualScreenshot.png"));

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

        BufferedImage diffImage = diff.getMarkedImage();

        ImageIO.write(diffImage, "png", new File(path + "/screenshots/diffScreenshot.png"));

        driver.quit();

        assertFalse(diff.hasDiff());
        
    }


}
