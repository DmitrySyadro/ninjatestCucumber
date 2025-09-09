package Base;



import com.fasterxml.jackson.databind.deser.Deserializers;
import org.openqa.selenium.WebDriver;
import utils.ConfigerReader;

import java.util.logging.Logger;

public class base {
    public static Logger log = Logger.getLogger(String.valueOf(Deserializers.Base.class));
    public static WebDriver driver;
    public static ConfigerReader reader;

}
