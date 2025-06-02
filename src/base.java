import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class base {
    public static AndroidDriver capabilities() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        File appDir = new File("src");
        File app = new File(appDir, "app-debug.apk");

        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:deviceName", "Pixel 9 Pro API 35");
        cap.setCapability("appium:automationName", "uiautomator2");
        cap.setCapability("appium:app", app.getAbsolutePath());

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, cap);
        
        return driver;
    }
}
