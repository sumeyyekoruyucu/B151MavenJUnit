package deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Deneme01 {
    //"https://testcenter.techproeducation.com/index.php?page=dropdown" adresine gidiniz.
    //programming languages ddm den istediğiniz 4 seçeneği seçiniz
    //Eğer sadece seçili olan option'ları yani seçenekleri yazdırmak istersek;
    //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
    //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
    //Seçtiğimiz seçeneklerin hepsini kaldırmak için;
    //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
    //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
    //Index olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
    //Value olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
    
    WebDriver driver;


    @Test
    public void test1() {

        //"https://testcenter.techproeducation.com/index.php?page=dropdown" adresine gidiniz.
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //programming languages ddm den istediğiniz 4 seçeneği seçiniz
        WebElement diller=driver.findElement(By.xpath("//*[@name='Languages']"));//"(//select)[6]"
        Select select=new Select(diller);
        bekle(2);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);

        //Eğer sadece seçili olan option'ları yani seçenekleri yazdırmak istersek;
        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));
        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        System.out.println("*********************************");
        //Seçtiğimiz seçeneklerden ilkini yazdıralım, ilk seçeneğin Java olduğunu doğrulayalım
        System.out.println(select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());
        bekle(3);

        //Seçtiğimiz seçeneklerin hepsini kaldırmak için;
        select.deselectAll();

        //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
        diller.sendKeys("C#");

        bekle(3);
        //visibleText olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
       selectVisibleText(diller,"Java");
       bekle(2);

        //Index olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectIndex(diller,3);
        bekle(2);

        //Value olarak seçim yapacağımız bir method oluşturup programming languages ddm den bir seçenek seçelim
        selectValue(diller,"js");  //value dikkat et value farkli olabilir. incele den bak.
        //ornegin burda visible text: Java Script ama value: js


    }
    public void selectVisibleText(WebElement ddm,String secenek){
        Select select=new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);     //bunu yazip noktali virgul  disina nokta koyarsak try otomatik cikar.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void selectIndex(WebElement ddm,int index){
        Select select=new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm,String value){
        Select select=new Select(ddm);
        select.selectByValue(value);
    }

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.close();
    }
}
