package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage implements SeleniumPage{

    private String baseUrl;
    private WebDriver driver;

    public String getBaseUrl(){
        return this.baseUrl;
    };

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


}
