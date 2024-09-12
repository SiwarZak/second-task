package secondTestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondTestCase {
    public static void main(String[] args) {
        // Set up WebDriver and launch the browser
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 1. Navigate to the site and verify the title
        driver.get("https://www.saucedemo.com/");
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verified: " + actualTitle);
        } else {
            System.out.println("Title verification failed. Actual: " + actualTitle);
        }

        // 2. Login to the site
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");  // Use valid username
        password.sendKeys("secret_sauce");   // Use valid password
        loginButton.click();

        // 3. Pick a product and add it to the cart
        WebElement firstProduct = driver.findElement(By.className("inventory_item_img"));
        firstProduct.click();
        WebElement addToCartButton = driver.findElement(By.className("btn_inventory"));
        addToCartButton.click();
        System.out.println("Item added to cart");

        // 4. Navigate to cart page and verify
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
        String cartPageUrl = driver.getCurrentUrl();
        if (cartPageUrl.contains("cart")) {
            System.out.println("Navigated to cart page: " + cartPageUrl);
        } else {
            System.out.println("Failed to navigate to cart page.");
        }

        // 5. Click continue shopping 
        WebElement continueButton = driver.findElement(By.id("continue-shopping"));
        continueButton.click();

        // 6. Logout from the site
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        logoutLink.click();

        // Close the browser
        driver.quit();
    }
}
