package tests.day22;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class C01_TestNGReports extends TestBaseRapor {
    @Test
    public void windowHandlereusableTest() throws IOException {
        extentTest=extentReports.createTest("window handle","title ile 2.sayfaya gecis yapildigi test edildi");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("herokuapp sayfasina gidildi");
        Driver.getDriver().findElement(By.xpath("(//a[@target='_blank'])[1]")).click();
        extentTest.info("yeni window linkine tiklandi");
        ReusableMethods.switchToWindow("New Window");
        extentTest.info("resuable method kullanarak acilan 2.sayfaya gecildi");
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        extentTest.pass("title'in expected title ile ayni oldugu test edildi");

    }
}
