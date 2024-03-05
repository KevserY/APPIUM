package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
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

        // com.dogan.arabam.presentation.feature.home.HomeActivity -

    }


    @Test
    public void arabamTest() throws InterruptedException {
        //driver.activateApp("com.dogan.arabam");

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        assertTrue(driver.isAppInstalled("com.dogan.arabam"));

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir
        //driver.findElementByXPath("//*[@text='Otomobil'").click();  // tıklama yapmak için kullanılan klasik yöntem
        Thread.sleep(2000);
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(994,500)) // ekranda tıklamam yapılacak en ve boy bilgilerinin girildiği kısım.
                .release()// tıklama işlemi yaptıktan sonra tıklamanın gerçekleşmesi için ekranda parmağımızı kaldırma işlemi
                .perform();// verilen action görevlerinin yerine getirmesi için action methodlarına verilen YAP(yerine getir) emri.

        // arac olarak Volkswagen secilir


        // arac markasi olarak passat secilir

        // 1.4 TSI BlueMotion secilir

        // Paket secimi yapilir

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir






    }




}
