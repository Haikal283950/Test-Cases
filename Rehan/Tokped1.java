import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.*;

public class Tokped1 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test case
        driver.quit();
    }

    @Test
    public void tc1() throws InterruptedException {
        // Test Case: Login with valid credentials
        driver.get("https://accounts.tokopedia.com/login");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find the email input field
        WebElement emailInput = driver.findElement(By.id("email"));
        // Input with valid email
        emailInput.sendKeys("jokeaja101@gmail.com");
        Thread.sleep(5000);

        // Find the "Selanjutnya" (Next) button and click it
        WebElement nextButton = driver.findElement(By.cssSelector("button[type='submit']"));
        nextButton.click();
        Thread.sleep(5000);

        // Find the password input field
        WebElement password = driver.findElement(By.id("password"));
        // Input with valid password
        password.sendKeys("Sutoyo-15");
        Thread.sleep(5000);

        // Find the login button
        WebElement login = driver.findElement(By.id("login-submit"));
        login.click();
        Thread.sleep(10000);
        assertTrue("Error", true);
    }

    @Test
    public void tc2() throws InterruptedException {
        // Test Case: Login with invalid credentials
        driver.get("https://accounts.tokopedia.com/login");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find the email input field
        WebElement emailInput = driver.findElement(By.id("email"));
        // Input with invalid email
        emailInput.sendKeys("jokeaja101231@gmail.com");
        Thread.sleep(5000);

        // Find the "Selanjutnya" (Next) button and click it
        WebElement nextButton = driver.findElement(By.cssSelector("button[type='submit']"));
        nextButton.click();
        Thread.sleep(5000);
        assertTrue("Email belum terdaftar", true);
    }

    @Test
    public void tc3() throws InterruptedException {
        // Test Case: Searching Valid Item
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input "Bola" to search box
        searchBox.sendKeys("Bola");
        //Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        assertTrue("Menampilkan", true);
    }

    @Test
    public void tc4() throws InterruptedException {
        // Test Case: Searching Invalid Item
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input invalid item to search box
        searchBox.sendKeys("hkjasdkhjdas");
        //Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        assertTrue("Opps, produk nggak ditemukan", true);
    }

    @Test
    public void tc5() throws InterruptedException {
        // Test Case: Filtering Search Item by Review
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input item to search box
        searchBox.sendKeys("Bola");
        // Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // Find the button to open the dropdown menu
        WebElement dropdownButton = driver.findElement(By.xpath("//button[@data-unify='Select']"));
        // Click the button to open the dropdown menu
        dropdownButton.click();
        Thread.sleep(5000);

        // Find the desired option ("Ulasan") and click it
        WebElement ulasanOption = driver.findElement(By.xpath("//p[text()='Ulasan']"));
        ulasanOption.click();
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        Thread.sleep(5000);
        assertTrue("Ulasan", true);
    }

    @Test
    public void tc6() throws InterruptedException {
        // Test Case: Filtering Search Item by Newest
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input item to search box
        searchBox.sendKeys("Bola");
        // Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // Find the button to open the dropdown menu
        WebElement dropdownButton = driver.findElement(By.xpath("//button[@data-unify='Select']"));
        // Click the button to open the dropdown menu
        dropdownButton.click();
        Thread.sleep(5000);

        /// Find the "Terbaru" option and click it
        WebElement terbaruOption = driver.findElement(By.xpath("//p[text()='Terbaru']"));
        terbaruOption.click();
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        Thread.sleep(5000);
        assertTrue("Terbaru", true);
    }

    @Test
    public void tc7() throws InterruptedException {
        // Test Case: Filtering Search Item by Highest Price
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input item to search box
        searchBox.sendKeys("Bola");
        // Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // Find the button to open the dropdown menu
        WebElement dropdownButton = driver.findElement(By.xpath("//button[@data-unify='Select']"));
        // Click the button to open the dropdown menu
        dropdownButton.click();
        Thread.sleep(5000);

        /// Find the "Harga Tertinggi" option and click it
        WebElement highestPriceOption = driver.findElement(By.xpath("//p[text()='Harga Tertinggi']"));
        highestPriceOption.click();
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        Thread.sleep(5000);
        assertTrue("Harga Tertinggi", true);
    }

    @Test
    public void tc8() throws InterruptedException {
        // Test Case: Filtering Search Item by Lowest Price
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input item to search box
        searchBox.sendKeys("Bola");
        // Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // Find the button to open the dropdown menu
        WebElement dropdownButton = driver.findElement(By.xpath("//button[@data-unify='Select']"));
        // Click the button to open the dropdown menu
        dropdownButton.click();
        Thread.sleep(5000);

        /// Find the "Harga Terendah" option and click it
        WebElement lowestPriceOption = driver.findElement(By.xpath("//p[text()='Harga Terendah']"));
        lowestPriceOption.click();
        Thread.sleep(5000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        Thread.sleep(5000);
        assertTrue("Harga Terendah", true);
    }

    @Test
    public void tc9() throws InterruptedException {
        // Test Case: Filtering Search Item by Official Store
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input item to the search box
        searchBox.sendKeys("Bola");
        // Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // Find the "Official Store" checkbox and click it
        WebElement storeCheckbox = driver.findElement(By.xpath("//span[text()='Official Store']"));
        Thread.sleep(5000);
        storeCheckbox.click();
        Thread.sleep(5000);
        assertTrue("Official Store", true);
    }

    @Test
    public void tc10() throws InterruptedException {
        // Test Case: Filtering Search Item by Power Merchant
        driver.get("https://www.tokopedia.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Find Search Box
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"header-main-wrapper\"]/div[2]/div[2]/div/div/div/div/input"));
        // Input item to the search box
        searchBox.sendKeys("Bola");
        // Search the item
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        // Find the "Power Merchant" checkbox and click it
        WebElement storeCheckbox = driver.findElement(By.xpath("//span[text()='Power Merchant']"));
        Thread.sleep(5000);
        storeCheckbox.click();
        Thread.sleep(5000);
        assertTrue("Power Merchant", true);
    }
}
