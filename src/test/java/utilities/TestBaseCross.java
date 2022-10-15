package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBaseCross {
    protected WebDriver driver;
    @Parameters("browser")
    //@BeforeClass ve @AfterClass notasyonlarini TestNG de kullanirken JUnit'teki gibi static yapmaya gerek yoktur
    @BeforeMethod
    public void setUp(@Optional String browser){


        driver=CrossDriver.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterMethod
    public void tearDown(){

        CrossDriver.closeDriver();
    }
}
