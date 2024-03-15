package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class KiwiPage {

    public KiwiPage() {

        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(), this);
        /*  Biz almış olduğumuz locate'leri testlerimiz içerisinde kullanmak istediğimiz POM'a göre bu sayfaya kaydedilen locateleri kullanırız.
            Bu locate'ler test esnasında oluşturulan obje üzerinden çağrıldığında eğer WebDriver özelliğini kullanmazsa
            o locate'ler işlemlerini yerine getiremez.
            Bunun için bu sayfadaki tanımlanan driver'ımızın WebDriver casting'i yapılarak alınan locate'leri
            bu WebDriver'ın API'larını kullanan appium artık işlemleri yapabilir hale gelir. */
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement kalkisTextKutusu;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButonu;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement sonucFiyat;


}