package techproed.day07_MavenJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         /*
        1.http://zero.webappsecurity.com sayfasina gidin
        2.Signin buttonuna tiklayin
        3.Login alanine “username” yazdirin
        4.Password alanine “password” yazdirin
        5.Sign in buttonuna tiklayin
        6.Online Banking altinda Pay Bills sayfasina gidin
        7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8.tarih kismina “2020-09-10” yazdirin
        9.Pay buttonuna tiklayin
        10.“The payment was successfully submitted.” mesajinin ciktigini control edin
         */

        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.cssSelector("button")).click();
        //WebElement login=driver.findElement(By.xpath("//*[@type='text']"));
        //login.sendKeys("username");
        //WebElement password=driver.findElement(By.xpath("//*[@type='password']"));
        //password.sendKeys("password");
        //driver.findElement(By.xpath("//*[@type='submit']")).click();

        //****************usttekileri ben alttakileri hoca 2 satirda bitirdi************

        //3.Login alanine "username" yazdirin
        //4.Password alanine "password" yazdirin
       //5.Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("input#user_login"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);

        Thread.sleep(2000);
        driver.navigate().back();

        driver.findElement(By.xpath("(//strong)[2]")).click();
        /*
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        //-->(//*[text()=.])[11] Bu şekilde text ile aldığımız bir xpath'de text değişse bile biz o webelementi handle edebiliriz.
         */
        driver.findElement(By.xpath("(//*[@class='headers'])[4]")).click();
        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("(//span)[1]"));
        System.out.println(sonucYazisi.getText());
        if (sonucYazisi.getText().equals("The payment was successfully submitted.")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        if (sonucYazisi.isDisplayed()){        ////Webelementin görünür olup olmadığını doğrulamak için yaptık
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");



    }
}
