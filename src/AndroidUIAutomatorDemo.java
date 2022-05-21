import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUIAutomatorDemo extends BaseDriver {
	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> adriver = getCapabilities();

		adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		adriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click(); // Attribute(value) syntax
		adriver.findElement(MobileBy.AndroidUIAutomator("text(\"Animation\")")).click();

		int expectZero = adriver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().checked(true)")).size();

		System.out.println("###########" + expectZero);

	}

}
