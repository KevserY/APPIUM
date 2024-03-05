package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMakinesi {

    AndroidDriver<AndroidElement> driver; // android cihazlardaki işlemleri yapabilmemizi sağlayan driver objesi
    AndroidDriver<MobileElement> driver2; // android cihazlardaki işlemleri yapabilmemizi sağlayan driver objesi
//    IOSDriver<IOSElement>  iosDriver; // IOS cihazlardaki işlemleri yapabilmemizi sağlayan driver objesi
//    AppiumDriver<MobileElement> appiumDriver; // her iki paltformada da işlemleri yapmamızı sağlayan objedir.


    @Test
    public void test01() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar

        DesiredCapabilities capabilities = new DesiredCapabilities(); // testi oluşturmadan önce cihaz hk. bilgileri buraya giriyoruz.

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL");
        //capabilities.setCapability("deviceName", "PIXEL"); --> şeklinde de tanımlayabiliriz.
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");  // android driver
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\HUAWEI\\IdeaProjects\\Appium_T127\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
        /*
        UiAutomator2 otomasyon ismi:
            - sadece android 6'dan yüksek olan android sistemleri için çalışır.
        UiAutomator ise :
            - 6 ve 6'dan düşük olan Android sistemler için çalışır.          */

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // bu satırda da Driver'ı göndereceğimiz yeri tanımlıyoruz. Driver'ı server'a gönderiyoruz.
        // ortak bir URL de buluşuyorlar
        // bu oluşturduğumuz URL'e tanımladığımız capabilities'i gönderiyoruz.

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));

        // uygulamanin acildigini dogrular
        // uygulamada yeralan bir elementi locate almalı:
        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());

        // 200 un 7 katininin 1400 oldugunu hesap makinasindan dogrulayalim
        // --- işlemi uygulamaya yaptıracağız. her tuşun locate ini alıp, işlemi yaptıracağız.
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("7").click();
        driver.findElementByAccessibilityId("equals").click();
        String sonuc =driver.findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println(sonuc);

        Assert.assertEquals(Integer.parseInt(sonuc),1400);



    }
}
