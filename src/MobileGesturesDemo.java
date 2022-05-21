import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileGesturesDemo extends BaseDriver {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> adriver = getCapabilities();

		// PRESS AND HOLD

		adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		adriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click(); // Attribute(value) syntax

		// Tap - difference between tap and click
		AndroidElement expandableList_ele = adriver
				.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));

		TouchAction ta = new TouchAction(adriver);

		ta.tap(tapOptions().withElement(element(expandableList_ele))).perform();

		AndroidElement customAdapter_ele = adriver
				.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));

		ta.tap(tapOptions().withElement(element(customAdapter_ele))).perform();

		AndroidElement peopleNames_ele = adriver
				.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		// LONG PRESS
		ta.longPress(longPressOptions().withElement(element(peopleNames_ele)).withDuration(ofSeconds(2))).release()
				.perform();

		System.out
				.println(adriver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
	}

}
