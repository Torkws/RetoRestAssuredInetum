package Inetum;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Inetum",
        plugin = {"pretty", "json:target/build/cucumber.json"},
        tags = "@step"
)

public class ServicesTest {
}
