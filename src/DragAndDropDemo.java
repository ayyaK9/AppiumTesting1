import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragAndDropDemo extends BaseDriver{
public static void main(String[] args) throws MalformedURLException {
	
	AndroidDriver<AndroidElement> adriver = getCapabilities();

	adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	adriver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click(); // Attribute(value) syntax
	adriver.findElement(MobileBy.AndroidUIAutomator("text(\"Drag and Drop\")")).click(); 
	
	WebElement source = adriver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
	WebElement dest = adriver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
	
	TouchAction ta = new TouchAction(adriver);
	
	ta.longPress(element(source))
	.moveTo(element(dest)).release().perform();
	
	System.out.println(adriver.findElement(By.xpath("//*[@text='Dropped!']")).isDisplayed());
	
	
}
}
