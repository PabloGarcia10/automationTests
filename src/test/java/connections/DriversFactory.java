package connections;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.collections.Lists;

public class DriversFactory {

	public static WebDriver driver;
	private static final String CHROME_DRIVER_PATH = "./Drivers/chromedriver.exe";
	private static final String FIREFOX_DRIVER_PATH = "./Drivers/geckodriver.exe";
	private static final String IE_DRIVER_PATH = "./Drivers/IEDriverServer.exe";
	private static final int IMPLICIT_WAIT_TIME = 5;
	private static final int PAGE_LOAD_TIMEOUT = 5;
	
	
	public static void connect(String url) {

		String navegator = "Chrome";

		if (navegator.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			driver = new ChromeDriver();

		} else if (navegator.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();

		} else if (navegator.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.chrome.driver", IE_DRIVER_PATH);
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		System.out.println("Website Title: " + driver.getTitle());
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void scrollDown() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
	}

	public void secondTab() {
		List<String> browserTabs = Lists.newArrayList(driver.getWindowHandles());
		driver.switchTo().window(browserTabs.get(1)); // Switch to second tab
		driver.getTitle();
	}
}
