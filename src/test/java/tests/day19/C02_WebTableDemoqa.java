package tests.day19;

import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTableDemoqa {
    @Test
    public void demoqaTest() {

    //Bir Class olusturun D19_WebtablesHomework
    //1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("DemoqaUrl"));

        DemoqaPage demoqaPage = new DemoqaPage();
    //2. Headers da bulunan department isimlerini yazdirin
     //  normalde //thead//th olurdu ancak bu tablo class isimleri ile organize edilmis
        System.out.println("baslik satiri elementi :"+demoqaPage.baslikSatriElementi.getText());

        //ikinci yontem olarak basliklari bir listeye koyabiliriz
       // baslikSatriElementiListesi


    //3. sutunun basligini yazdirin
        System.out.println("3.sutun basligi :"+demoqaPage.basliklarWebelementiListesi.get(2).getText());


    //4. Tablodaki tum datalari yazdirin
        System.out.println("============TUM BODY==========");
        System.out.println(demoqaPage.bodyTumWebelement.getText());
    //5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("tablodaki data sayisi :"+demoqaPage.tumDataWebelementList.size());
    //6. Tablodaki satir sayisini yazdirin
        System.out.println("tum satir sayisi :"+demoqaPage.tumSatirlarWebelementList.size());
    //7. Tablodaki sutun sayisini yazdirin
       //farkli yollardan hesaplanabilir ama biz hucre sayisi /satir sayisi yapalim
        System.out.println("tablodaki sutun sayisi :"
                +demoqaPage.tumDataWebelementList.size()/demoqaPage.tumSatirlarWebelementList.size());
    //8. Tablodaki 3.kolonu yazdirin
        demoqaPage.sutunYazdir(3);
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
      demoqaPage.ismeGoreMaasYazdir("Kierra");
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
    //girdigimde bana datayi yazdirsin
        demoqaPage.hucreYazdir(2,3);

        Driver.closeDriver();
}
}