package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {

    /*
    DROPDOWN -->Alt basliklarin oldugu acilir menu listesidir.
    Dropdown'u handle(outomate) etmek icin
          1-Dropdown menuyu ilk olarak locate ederiz.
          2-Select objesi olustururuz.
          3-Select objesinin dropdownmenu(ddm) web elementinin icerigine ve seceneklerine erisim saglamasi icin
          SELECT sinifina arguman olarak locate ettigimiz webelementi koyariz
          SYNTAX:
                  Select select=new Select(ddm webelementi)
          4-Select class'i , sadece <select> tag'i ile olusturulmus dropdown menulere uygulanabilir.
          5-Select objesi ddm'yu handle edebilmek icin 3 method kullanir
                  a) selectByVisibleText() --> ddm deki elemente gorunur metin ile ulasmak icin kullanilir.
                  b) selectByIndex()      --> Index ile ulasmak icin kullanilir(index = 0 dan baslar)
                  c) selectByValue()      --> Elementin degeri ile ulasmak icin kullanilir.(Option taglarindaki deger()value ile)
          6-getOptions()  --> Locate ettigimiz ddm deki tum secenekleri bize verir.(Liste atip loop ile yazdirabiliriz.)
          7-getFirstSelectedOPtion() --> ddm'deki secili kalan secenegi bize verir.Birden fazla secenek secili ise
          secililerin ilkini bize verir.
     */
    /*SORU:

      Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
      -3 farklı test methodu oluşturalım
    1.Method:
        a. Yil,ay,gün dropdown menu'leri locate ediniz
        b. Select objesi olustur
        c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    2.Method:
        a. Tüm eyalet isimlerini yazdıralım
    3.Method:
        a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

 */
       WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void test01() {
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));

        //b. Select objesi olustur
        Select select=new Select(yil);
        Select select1=new Select(ay);
        Select select2=new Select(gun);

        //c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);  //index 0 dan baslar 2018 i secer.
        select1.selectByValue("6");
        select2.selectByVisibleText("3");

    }

    @Test
    public void test02() {
        //a. Tüm eyalet isimlerini yazdıralım (Select ile)
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        select.getOptions().forEach(w-> System.out.println(w.getText()));
        //getOptions() methodu ile tüm seçenekleri yazdırdık
        //2. yol
        System.out.println("****************************************************************");
        List<WebElement> eyaletlerr = driver.findElements(By.xpath("(//select)[5]"));
        eyaletlerr.forEach(w-> System.out.println(w.getText()));
    }

    @Test
    public void test03() {
       // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select=new Select(eyaletler);
        String seciliSecenek=select.getFirstSelectedOption().getText();
        System.out.println(seciliSecenek);
        Assert.assertEquals("Select a State",seciliSecenek); //asserttrue ile de yapabilirdik.

    }
}
