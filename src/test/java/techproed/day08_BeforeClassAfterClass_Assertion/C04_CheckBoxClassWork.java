package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {
    //a.Verilen web sayfasına gidin.
    // https://the-internet.herokuapp.com/checkboxes
    //b.Checkbox1 ve checkbox2 elementlerini locate edin.
    //c.Checkbox1 seçili değilse onay kutusunu tıklayın
    //d.Checkbox2 seçili değilse onay kutusunu tıklayın

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBox() throws InterruptedException {
    WebElement checkbox1=driver.findElement(By.xpath("(//input)[1]"));
    WebElement checkbox2=driver.findElement(By.xpath("(//input)[2]"));

      Thread.sleep(2000);
    //c.Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1.isSelected()){  //secili degilse
            checkbox1.click();    //checkbox1 i click yap
        }
        Thread.sleep(2000);
        // d.Checkbox2 seçili değilse onay kutusunu tıklayın

        if (!checkbox2.isSelected()){  //secili degilse
            checkbox2.click();    //checkbox2 i click yap
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
