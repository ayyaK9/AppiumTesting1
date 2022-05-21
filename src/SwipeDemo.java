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

public class SwipeDemo extends BaseDriver {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> adriver = getCapabilities();

		// PRESS AND HOLD

		adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		adriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click(); // Attribute(value) syntax

		TouchAction ta = new TouchAction(adriver);
		AndroidElement dateWidgets_ele = adriver
				.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']"));

		ta.tap(tapOptions().withElement(element(dateWidgets_ele))).perform();

		AndroidElement inline_ele = adriver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']"));

		ta.tap(tapOptions().withElement(element(inline_ele))).perform();

		AndroidElement nineEle = adriver.findElement(By.xpath("//*[@content-desc='9']"));

		ta.tap(tapOptions().withElement(element(nineEle))).perform();

		AndroidElement fivteenEle = adriver.findElement(By.xpath("//*[@content-desc='15']"));

		AndroidElement fortyFiveEle = adriver.findElement(By.xpath("//*[@content-desc='45']"));

		// longpress for 1 sec and move to other object

		ta.longPress(longPressOptions().withElement(element(fivteenEle)).withDuration((ofSeconds(2))))
				.moveTo(element(fortyFiveEle)).release().perform();

	}

}
