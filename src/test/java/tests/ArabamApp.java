package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class ArabamApp {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void arabamSetUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        capabilities.setCapability("appPackage","com.dogan.arabam");
        // hangi uygulama üzerinde çalışmak istiyorsak o uygulamaya ait appPackage değeri yani kimlik bilgisi
        // girmemiz gerekir.  Apk Bilgisi uygulamasından bu değeri öğreniyoruz.

        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        // uygulamayı ilk açtığımızda, başlamasını istediğimiz sayfayı belirleyebiliriz.
        // bunun için appActivity bilgisine ihtiyacımız var.
        // appActivity bilgilerine yine Apk Bilgisi uygulamasından ulaşabiliriz.

        // teste başladığımızda hangi uygulamayı kullanmasını söylediğimizde,
        // nereden başlaması gerektiğini de belirtmek zorundayız.

        // appPackage değeri giriyorsak ---> appActivity değeri de girmek zorundayız.

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // com.dogan.arabam.presentation.feature.home.HomeActivity

    }


    @Test
    public void arabamTest() throws InterruptedException {
        //driver.activateApp("com.dogan.arabam");
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed()); // uygulamanın logosunu

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir

        //driver.findElementByXPath("//*[@text='Otomobil']").click(); ---> tıklama işlemi için kullanılan klasik yöntem.

        Thread.sleep(1000);
        TouchAction action = new TouchAction<>(driver); // Hangi cihaz üzerinde çalışacaksak o cihaza ait driver

        action.press(PointOption.point(994,500)) // Ekranda tıklama yapılacak en-boy bilgilerinin girldiği kısım. En-Boy (x,y) bilgileri Inspector'den geliyor.
              .release() //tıklama işlemi yaptıktan sonra tıklamanın gerçekleşmesi için ekrandan parmağımızı kaldırma işlemi
              .perform(); // verilen action görevlerinin yerine getirilmesi için action methodlarına verilen YAP (yerine getir) emri.


        Thread.sleep(1000);

        for(int i=0; i<5; i++){
        action.press(PointOption.point(482,1516)) // kaydırma yapmak için ekranda belirlenecek nokta
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
                .moveTo(PointOption.point(482,320))
                .release()
                .perform();
        Thread.sleep(500);
        }

        // arac olarak Volkswagen secilir
        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir
        // 412  721
        action.press(PointOption.point(420,720))
                .release()
                .perform();


        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir






    }




}
