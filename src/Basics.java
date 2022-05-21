import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basics extends BaseDriver {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> adriver = getCapabilities();

		// xpath id classname and androidUIautomator find elements, (xpath)[2]

		adriver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		adriver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		adriver.findElement(By.id("android:id/checkbox")).click();
		adriver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();

		adriver.findElement(By.className("android.widget.EditText")).sendKeys("wifiSett");
		adriver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();

	}

}
