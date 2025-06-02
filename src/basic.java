import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class basic extends base {
    public static void main(String[] args) throws Exception {
        AndroidDriver driver = capabilities();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.example.trendify:id/btnMasuk\"]")).click();
        Thread.sleep(6000);  // jeda 6 detik untuk penjelasan

        // 1. LOGIN BERHASIL
        try {
            // 1. Enter email (if needed)
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.example.trendify:id/editEmail"))
            ).sendKeys("iffatun@gmail.com");
            Thread.sleep(3000);

            // 2. Locate password field using the most reliable locator
            WebElement passwordField = wait.until(wd -> {  
                WebElement el = wd.findElement(By.id("com.example.trendify:id/editPassword"));
                if (el.isDisplayed()) return el;
                return wd.findElement(By.xpath("//android.widget.EditText[@hint='Masukkan Password']"));
            });

            // 3. Interact with password field
            passwordField.click();  
            passwordField.clear();  
            passwordField.sendKeys("iffa1234");
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Current page source:\n" + driver.getPageSource());
            throw e;
        }
        
        driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.example.trendify:id/btnMasuk\"]")).click();
        Thread.sleep(3000);
        
        // 2. Klik kategori baju
        WebElement kategoriBaju = wait.until(
        		ExpectedConditions.elementToBeClickable(
        			By.xpath("//android.widget.LinearLayout[@resource-id='com.example.trendify:id/kategori_baju']")
        ));
        kategoriBaju.click();
        Thread.sleep(3000);
        
        WebElement home = wait.until(
        		ExpectedConditions.elementToBeClickable(
        				By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]")
        ));
        home.click();
        Thread.sleep(3000);
        
        // 3. Klik item yang ada di beranda
        WebElement itemBeranda = wait.until(
        	    ExpectedConditions.elementToBeClickable(
        	        By.xpath("//android.widget.GridLayout/android.widget.LinearLayout[@clickable='true']")
        	    )
        );
        itemBeranda.click();
        Thread.sleep(3000);
        
	    // Tunggu tombol "Tambah" tampil dan klik
        WebElement tombolTambah = wait.until(
        		ExpectedConditions.elementToBeClickable(
        			By.xpath("//android.widget.ImageButton[@content-desc='Tambah']")
        	    )
        );
        tombolTambah.click();
        Thread.sleep(3000);
        
        // 4. Mencoba menambahkan item kedalam keranjang
        WebElement tambahKeranjang = wait.until(
        		ExpectedConditions.elementToBeClickable(
        			By.xpath("//android.widget.Button[@resource-id=\"com.example.trendify:id/btnAddToCart\"]")
        	    )
        );
        tambahKeranjang.click();
        Thread.sleep(3000);
        
        // 5. Checkout item
        WebElement checkout = wait.until(
        		ExpectedConditions.elementToBeClickable(
        				By.xpath("//android.widget.Button[@resource-id=\"com.example.trendify:id/btnCheckout\"]")
        ));
        checkout.click();
        Thread.sleep(3000);
        
        // 6. Pembayaran
        WebElement bayar = wait.until(
        		ExpectedConditions.elementToBeClickable(
        				By.xpath("//android.widget.Button[@resource-id=\"com.example.trendify:id/btn_pembayaran\"]")
        ));
        bayar.click();
        Thread.sleep(3000);
        
        // 7. Profil
        WebElement profil = wait.until(
        		ExpectedConditions.elementToBeClickable(
        				By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]")
        ));
        profil.click();
        Thread.sleep(3000);
        
        // 8. Logout
        WebElement logout = wait.until(
        		ExpectedConditions.elementToBeClickable(
        				By.xpath("//android.widget.Button[@resource-id=\"com.example.trendify:id/btnLogout\"]")
        ));
        logout.click();
        Thread.sleep(3000);
    }
}
