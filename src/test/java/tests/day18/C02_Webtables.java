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

    @Test
    public void table() {
        //● table( ) metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        // header kisminda birinci satir ve altindaki datalari locate edelim
        //      //thead//tr[1]//th"
        hotelMyCampPage=new HotelMyCampPage();
        List<WebElement> headerDatList=hmcWebTablePage.headerBirinciSatirDatalar;
        System.out.println("tablodaki sutun sayisi "+headerDatList.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //tbody
        System.out.println(hmcWebTablePage.tumBodyWebElementi.getText());
        // eger body'i tek bir webelement olarak locate edersek
        // icindeki tum datalari gettext() ile yazdirabiliriz
        // ancak bu durumda bu elementler ayri ayri degil body'nin icindeki tek bir String'in parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamiz mumkun olmaz
        // sadece contains methodu ile body'de olup olmadiklarini test ederiz

        // eger her datayi ayri ayri almak istersek
        //    //tbody//td   sekline locate edip bir list'e atabiliriz.
        List<WebElement>bodyTumDataList=hmcWebTablePage.tumBodyDatalariList;

        System.out.println(bodyTumDataList.size());

        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //○ 4.satirdaki(row) elementleri konsolda yazdırın
    }
}
