import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollingDemo extends BaseDriver {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> adriver = getCapabilities();

		

		adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		adriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click(); // Attribute(value) syntax

		adriver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Picker\"));"));

	}

}
