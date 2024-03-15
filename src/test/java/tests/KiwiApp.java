package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;
import utils.ReusableMethods;

import java.util.ResourceBundle;

import static org.testng.Assert.assertTrue;

public class KiwiApp {


    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    /* Hali hazırda testlerimizde kullanacak olduğumuz driver'ı Driver Class'ında oluşturduğumuz için,
       oluşturulan driver'ı bu scope içinde Android Element olarak döndürülmesini istediğimizden,
       Driver Class'ındaki static methodumuzu buradaki boş driver'a atama yaparak,
       bu sayfada kullanacak olduğumuz driver'a bir tanımlama ataması yapmış oluruz.
     */
    KiwiPage page = new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        assertTrue(driver.isAppInstalled("com.skypicker.main"));

        // uygulamanin basariyla acildigi dogrulanir
        assertTrue(page.misafirButonu.isDisplayed());

        // misafir olarak devam et e tiklanir
        page.misafirButonu.click();

        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir --> tıklama işlemini for loop ile 3 kez döngüye aldık
        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklamaMethodu(500,1700,1000);
        }

        // Trip type,one way olarak secilir
        Thread.sleep(1000);
        ReusableMethods.koordinatTiklamaMethodu(220,610,1000);
        ReusableMethods.koordinatTiklamaMethodu(270,1340,1000);
        Thread.sleep(1000);
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.koordinatTiklamaMethodu(290,770,1000);
        Thread.sleep(1000);
        ReusableMethods.koordinatTiklamaMethodu(1013,210,1000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (!driver.isKeyboardShown()) {
            page.kalkisTextKutusu.sendKeys("Istanbul"); // klavye görünmüyorsa, locate'e "Istanbul" gönder
        } else {
            driver.getKeyboard().pressKey("Istanbul"); // (oldu ki klavye görünmedi) else; klavye'yi getir ve "Istanbul" yaz
        }
        ReusableMethods.koordinatTiklamaMethodu(482,290,1000); // arama kutusuna istanbul yazdıktan sonra ilk çıkan seçenek tıklanır.
        page.chooseButonu.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.koordinatTiklamaMethodu(508,917,1000);
        driver.getKeyboard().pressKey("Antalya");
        Thread.sleep(1000);
        ReusableMethods.koordinatTiklamaMethodu(482,290,1000);
        page.chooseButonu.click();
        Thread.sleep(1000);

        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.koordinatTiklamaMethodu(537,1048,1000);
        ReusableMethods.koordinatTiklamaMethodu(541,1140,1000);
        ReusableMethods.koordinatTiklamaMethodu(716,1721,1000);

        // search butonuna tiklanir
        ReusableMethods.koordinatTiklamaMethodu(540,1200,3000);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.koordinatTiklamaMethodu(252,252,1000);
        ReusableMethods.koordinatTiklamaMethodu(563,584,2000);

        ReusableMethods.koordinatTiklamaMethodu(519,256,1000);
        ReusableMethods.koordinatTiklamaMethodu(511,1458,3000);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String biletFiyati = page.sonucFiyat.getText();
        driver.sendSMS("55555555","Kiwi App'de aradığınız biletin fiyatı: "+biletFiyati);



    }
}
