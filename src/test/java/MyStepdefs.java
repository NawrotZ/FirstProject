import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs {

    public WebDriver webDriver;
    public WebDriverWait wait;



    @Given("I open a browser")
    public void iOpenABrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver, 10);

    }

    @And("I go to University page")
    public void iGoToUniversityPage() {
        webDriver.get("https://us.edu.pl/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div[2]/div/div/div/a/em"))).click();
    }

    @When("I search for Zuzanna Sielska")
    public void iSearchForZuzannaSielska() {
        webDriver.findElement(By.xpath("//*[@id='search-form']/div[1]/input")).sendKeys("Zuzanna Sielska", Keys.ENTER);
    }


    @Then("I see results")
    public void iSeeResults() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/main/div[2]/div/div/div[1]/div/a[1]")));
        boolean ResultFound = false;

        for (int count = 1; count<=30 ;count++){
            System.out.println(webDriver.findElement(By.xpath("/html/body/main/main/div[2]/div/div/div[1]/div/a["+count+"]")).getText());
            if (webDriver.findElement(By.xpath("/html/body/main/main/div[2]/div/div/div[1]/div/a["+count+"]")).getText().contains("Zuzanna Sielska")) {
                ResultFound = true;

            }
        }
        Assert.assertTrue(ResultFound);

    }
}
