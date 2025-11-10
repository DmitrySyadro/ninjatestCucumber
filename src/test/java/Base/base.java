package Base;



import com.fasterxml.jackson.databind.deser.Deserializers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ConfigerReader;



public class base {
    public static Logger log = LogManager.getLogger(String.valueOf(Deserializers.Base.class));
    public static WebDriver driver;
    public static ConfigerReader reader;


    @BeforeClass
    @Parameters({"os","browser"})
    public void setUp(String os, String br)
    {
        switch (br.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default:
                System.out.println("Invalid browser name");
                return;
        }
    }

}
