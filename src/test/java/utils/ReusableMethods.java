package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ReusableMethods {

    public static void koordinatTiklamaMethodu(int xKoordinati, int yKoordinati, int beklemeSuresi) throws InterruptedException {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xKoordinati, yKoordinati)).release().perform();
        Thread.sleep(beklemeSuresi);
    }

    public static void ekranAsagiKaydırma(int waitAction) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(500, 1500))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500, 280))
                .release()
                .perform();
    }

    public static void ekranYukariKaydırma(int waitAction) {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(500, 280))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(waitAction)))
                .moveTo(PointOption.point(500, 1500))
                .release()
                .perform();
    }

    public static void scrollScreenMethod(int xKoordinati, int yKoordinati, int beklemeSuresi, int mXKoordinati, int mYKoordinati, int threadSleep) throws InterruptedException {
        TouchAction action = new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(xKoordinati, yKoordinati))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(beklemeSuresi)))
                .moveTo(PointOption.point(mXKoordinati,mYKoordinati))
                .release()
                .perform();
        Thread.sleep(threadSleep);
    }




}
