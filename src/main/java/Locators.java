import org.openqa.selenium.By;

public class Locators {

    public static By authUsername = By.id("username");
    public static By authPassword = By.id("password");
    public static By authLogin = By.id("doLogin");

    public static By brandLogout = By.linkText("Logout");

    public static By headButton = By.cssSelector("button[class='btn btn-primary']");
}
