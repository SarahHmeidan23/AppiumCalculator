import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Class {
	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@BeforeTest
	public void Setup() {
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Sara");

		File myApp = new File("src/myApplications/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, myApp.getAbsolutePath());
	}

	@Test(enabled = false)
	public void AddAllNumbers() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < AllButtons.size(); i++) {
			if (AllButtons.get(i).getAttribute("resource-id").contains("digit")) {
				AllButtons.get(i).click();
			}
		}
	}

	@Test(enabled = false)
	public void ClickOnEvenNumber() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < AllButtons.size(); i++) {
			if (AllButtons.get(i).getAttribute("resource-id").contains("digit")) {
				int num = Integer.parseInt(AllButtons.get(i).getAttribute("content-desc"));
				if (num % 2 == 0) {
					AllButtons.get(i).click();

				}
			} else {
				continue;

			}
		}
	}

	@Test(enabled = false)
	public void ClickOnOddNumber() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < AllButtons.size(); i++) {
			if (AllButtons.get(i).getAttribute("resource-id").contains("digit")) {
				int num = Integer.parseInt(AllButtons.get(i).getAttribute("content-desc"));
				if (num % 2 == 1) {
					AllButtons.get(i).click();

				}
			} else {
				continue;

			}
		}

	}

	@Test()
	public void Multiply() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
		String ActualResult = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		Assert.assertEquals(ActualResult, "182");
	}

	@AfterTest
	public void Post() {
	}
}
