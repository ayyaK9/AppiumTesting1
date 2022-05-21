import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseDriver {

	public static AndroidDriver<AndroidElement> getCapabilities() throws MalformedURLException {
		// Which app --.apk file
		// Which Device -- device name
		// all the test cases should direct to 4723 port

		// Android Driver
		File appdir = new File("src");
		File app = new File(appdir, "ApiDemos-debug.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 Emulator");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// UI AUTOMATOR2

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		AndroidDriver<AndroidElement> a_driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);

		return a_driver;

	}

}
