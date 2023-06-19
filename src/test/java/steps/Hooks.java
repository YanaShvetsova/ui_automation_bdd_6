package steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {

    @After
    public void tearDown(Scenario scenario){
        System.out.println("Scenario = " + scenario.getName() + "\nStatus = " +  scenario.getStatus());
        try{
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot)Driver.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot.png");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            Driver.quitDriver();
        }
    }
}
