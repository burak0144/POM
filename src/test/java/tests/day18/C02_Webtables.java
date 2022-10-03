package tests.day18;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMCWebTablePage;
import pages.HotelMyCampPage;

import java.util.List;

public class C02_Webtables {
    HotelMyCampPage hotelMyCampPage;
    HMCWebTablePage hmcWebTablePage;
    @Test
    public void loginT() {
        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //○ Username : manager
        //○ Password : Manager1!
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
    }

    @Test(dependsOnMethods = "loginT")
    public void table() {
        //● table( ) metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        // header kisminda birinci satir ve altindaki datalari locate edelim
        //      //thead//tr[1]//th"
        hmcWebTablePage = new HMCWebTablePage();
        List<WebElement> headerDataList = hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println("tablodaki sutun sayisi " + headerDataList.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //table
        System.out.println(hmcWebTablePage.tumBodyWebhElementi.getText());
        // eger body'i tek bir webelement olarak locate edersek
        // icindeki tum datalari gettext() ile yazdirabiliriz
        // ancak bu durumda bu elementler ayri ayri degil body'nin icindeki tek bir String'in parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
        // sadece contains methodu ile body'de olup olmadiklarini test ederiz

        // eger her datayi ayri ayri almak istersek
        //    //tbody//td   sekline locate edip bir list'e atabiliriz.
        List<WebElement> bodyTumDataList = hmcWebTablePage.tumBodyDatalariList;
        System.out.println(bodyTumDataList.size());
    }

    @Test(dependsOnMethods = "loginT" )
    public void testName() {

    //● printRows( ) metodu oluşturun //tr
        hmcWebTablePage=new HMCWebTablePage();
        System.out.println(hmcWebTablePage.satirlarListesi.size());
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement>satirlarListesiWebElementi=hmcWebTablePage.satirlarListesi;
        for (WebElement each:satirlarListesiWebElementi
             ) {
            System.out.println(each.getText());
        }

        //○ 4.satirdaki(row) elementleri konsolda yazdırın
        System.out.println("4.satir :"+satirlarListesiWebElementi.get(3).getText());
    }
}
