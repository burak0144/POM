package tests.day20;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.plaf.LabelUI;
import java.awt.*;
import java.awt.image.WritableRenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ortak {
    AmazonPage amazonPage=new AmazonPage();
    @Test
    public void testName() throws InterruptedException, IOException {
        String date;
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));
        String path="src/test/java/resources/TestExcel.xlsx";
        String page="Sheet1";
        Workbook workbook=null;
        String aranacak;
        WebElement sonucYazisi;
        File gecici;
        File dosyaYolu;
        FileOutputStream fos;

        try {
            FileInputStream fis=new FileInputStream(path);
            workbook= WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i =1; i <=3 ; i++) {
            aranacak=workbook.getSheet(page).getRow(i).getCell(0).toString();
            amazonPage.amazonAramaKutusu.sendKeys(aranacak, Keys.ENTER);
            Thread.sleep(3000);
            sonucYazisi=amazonPage.sonucYazisiElementi;
            date=new SimpleDateFormat("yymmddhhmmss").format(new Date());
            dosyaYolu=new File("target/SS/Excell"+date+".png");
            gecici=sonucYazisi.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(gecici,dosyaYolu);
            workbook.getSheet(page).getRow(i).createCell(1).setCellValue(""+dosyaYolu);
            fos=new FileOutputStream(dosyaYolu);
              workbook.write(fos);

         //   imageContent = Files.readAllBytes(imagePath);
         //   int pictureIndex = workbook.addPicture(imageContent, Workbook.PICTURE_TYPE_JPEG);
         //   anchor = new XSSFClientAnchor(0, 0, 0, 0, 3, (i), 5, (i + 1));
//
         //   drawingPatriarch = sheet.createDrawingPatriarch();
         //   drawingPatriarch.createPicture(anchor, pictureIndex);
//

            amazonPage.amazonAramaKutusu.clear();
        }




    }

}
