package techproed.day07_MavenJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    /*
         Notasyonlara sahip methodlar oluşturabilmek için mause+sağtik+generate(kısayol alt+insert) yaparak
     after methodu için teardown'u seçeriz.
     before methodu için setup'ı seçeriz.
     test methodu için de test'i seçeriz.
     Junit frameworkunde testlerimizi sıralama yapabilmek için ekstra bir notasyon yoktur
     Eğer belli bir sıralamada çalıştırmak istersek method isimlerini alfabetik ve sayısal olarak belirtmemiz gerekir.
      */
    @After
    public void tearDown() throws Exception {   //click-->generate-->teardown
        System.out.println("After Her test methodundan sonra bir kez çalışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before Her test methodundan önce bir kez çalışır");
    }
    //once after yazsak da o before var mi diye bakip once before u calistirir.


    @Test
    public void test1() {
        System.out.println("Test1 methodu çalıştı");
    }
    @Test
    public void test2() {
        System.out.println("Test2 methodu çalıştı");
    }
    @Test
    public void test3() {
        System.out.println("Test3 methodu çalıştı");
    }
    //test lerin sirasini degistirsek de metod ismini alfabetik ve sayisal olarak natural siralar-->test1,test2,test3

}
