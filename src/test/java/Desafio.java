import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
gitgit
public class Desafio {


    private WebDriver driver;

    @Before
    public void main(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
    }
    @Test
    public void fluxoFeliz(){

        driver.findElement(By.name("username")).sendKeys("JR");

        driver.findElement(By.name("password")).sendKeys("123456");


        WebElement campoComents = driver.findElement(By.name("comments"));
        campoComents.clear();
        campoComents.sendKeys("teste1 e teste2");

        driver.findElement(By.xpath("//input[@value='cb1']")).click();
       // driver.findElement(By.xpath("//input[@value='cb2']")).click();
        driver.findElement(By.xpath("//input[@value='cb3']")).click();


        driver.findElement(By.xpath("//input[@value='rd1']")).click();
       // driver.findElement(By.xpath("//input[@value='rd2']")).click();
       // driver.findElement(By.xpath("//input[@value='rd3']")).click();

        //driver.findElement(By.xpath("//input[@value='ms1']")).click();

        //*[@id="HTMLFormElements"]/table/tbody/tr[7]/td/select/option[2]
        //*[@id="HTMLFormElements"]/table/tbody/tr[5]/td/input[1]

        driver.findElement(By.xpath("//input[@value='submit']")).click();

        //Validações

        Assert.assertEquals("JR", driver.findElement(By.id("_valueusername")).getText());

        Assert.assertEquals("123456", driver.findElement(By.id("_valuepassword")).getText());

        Assert.assertEquals("teste1 e teste2", driver.findElement(By.id("_valuecomments")).getText());

        Assert.assertEquals("cb1", driver.findElement(By.id("_valuecheckboxes0")).getText());

        Assert.assertEquals("rd1", driver.findElement(By.id("_valueradioval")).getText());

    }

    @Test
    public  void fluxoAlternativo(){

        WebElement campoComents = driver.findElement(By.name("comments"));
        campoComents.clear();


        driver.findElement(By.xpath("//input[@value='submit']")).click();

        //validações
        Assert.assertEquals("No Value for username", driver.findElement(By.xpath("/html/body/div[1]/div[3]/p[1]/strong")).getText());
        Assert.assertEquals("No Value for password", driver.findElement(By.xpath("/html/body/div[1]/div[3]/p[2]/strong")).getText());
        Assert.assertEquals("No Value for comments", driver.findElement(By.xpath("/html/body/div[1]/div[3]/p[3]/strong")).getText());
    }

}
