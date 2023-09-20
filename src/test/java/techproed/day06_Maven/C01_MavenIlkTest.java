package techproed.day06_Maven;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        https://www.amazon.com/ sayfasina gidelim
        arama kutusunu locate edelim
       “Samsung headphones” ile arama yapalim
        Bulunan sonuc sayisini yazdiralim
        Ilk urunu tiklayalim
        Sayfadaki tum basliklari yazdiralim
         */

        driver.get("https://amazon.com");
        WebElement aramaKutusu=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String [] sonucSayisi=sonucYazisi.getText().split(" ");
        System.out.println("sonuc Sayisi = "+sonucSayisi[2]);
        driver.findElement(By.xpath("(//h2//a)[1]")).click();
        List<WebElement>basliklar=driver.findElements(By.xpath("//h1 | //h2"));
        //  | sembolu hem h1 hemde h2 leri alabilmek icin digerlerini de istersek | ile ekleyebiliriz h6 ya kadar biz uzamasin diye bu kadar aldik.
        basliklar.forEach(t-> System.out.println(t.getText()));  //list i yazdirmak icin forEach kullaniyoruz











    }
}
