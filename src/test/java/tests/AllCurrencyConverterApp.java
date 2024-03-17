package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyConverterApp {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();


    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']").isDisplayed());

        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(360, 320,1000);
        ReusableMethods.scrollWithUiScrollable("PLN");

        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(360,468,1000);
        ReusableMethods.scrollWithUiScrollable("TRY");

        // cevrilen tutar screenShot olarak kaydedilir
        ReusableMethods.scrollWithUiScrollable("1");// locate text alıyor, buluyor ve tıklıyor
        ReusableMethods.scrollWithUiScrollable("5");
        ReusableMethods.scrollWithUiScrollable("5");
        // bu hesaplama işlemi sonrası SS alacağız.
        // 1. YOL:
        //File file = driver.getScreenshotAs(OutputType.FILE);  // ---> SS işlemi yapıldı, ve file'a kaydettik.
        //FileUtils.copyFile(file, new File("ExchangeRateForZlotyToTRY.jpg"));
        // 2. YOL:
        ReusableMethods.getScreenshot("kevser");

        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        AndroidElement exchangeResult = driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB");
        String sonuc = exchangeResult.getText();

        // kullaniciya sms olarak bildirilir
        driver.sendSMS("5555555"," işlem sonucu : " + sonuc);


    }
}
