package codigo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpotifyAuto {

    public static void main(String[] args) throws InterruptedException {

        String rutaDriver = "C:\\Users\\pablo.cabrera\\IdeaProjects\\SeleniumSpotify\\src\\test\\resources\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver",rutaDriver);

        //Instanciar un objeto de tipo webdriver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spotify.cl/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Click en boton "Registrarse"
        driver.findElement(By.xpath("//button[contains(text(),'Reg')]")).click();
        Thread.sleep(2000);

        //Obtener texto
        String texto = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/section[1]/div[1]/div[1]/header[1]/h1[1]")).getText();
        System.out.println(texto);

        //Ingreso de correo formato no valido
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("correonovalido" + "\t");
        Thread.sleep(2000);
        String advertencia = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/main[1]/section[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")).getText();
        System.out.println(advertencia);

        //Volver a pagina anterior
        driver.navigate().back();

        //Buscar "Los Jaivas"
        driver.findElement(By.xpath("//span[contains(text(),'Buscar')]")).click();
        Thread.sleep(2000);
        String buscar = driver.findElement(By.xpath("//input[@maxlength=\"800\"]")).getText();
        System.out.println(buscar);
        driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/form[1]/input[1]")).sendKeys("Los Jaivas" + "\n");
        Thread.sleep(5000);

        driver.quit();

    }

}