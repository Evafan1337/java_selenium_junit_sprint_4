package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class MainPageTest {

    WebDriver driver;
    MainPage page;
    String url = "https://qa-scooter.praktikum-services.ru/";
    @Before
    public void startUpAll(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get(url);
        this.page = new MainPage();
    }

    @Test
    public void showMainPageSuccess(){
        Assert.assertEquals("Url не совпадают!",url, driver.getCurrentUrl());
    }
    @Test
    public void showQuestionsAndAnswersSuccess(){

        WebElement element = driver.findElement(page.getquestionsAndAnswersBlock());
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.manage().timeouts().implicitlyWait(1000,
                TimeUnit.MILLISECONDS);

        int questionsCount = page.getQuestionsCount();
        String headerClassMask = page.getQuestionsAndAnswersElem();
        String answerClassMask = page.getQuestionsAndAnswersElemAnswer();
        for(int i = 0; i < questionsCount; i++){

            String headerIdMaskCurrent = headerClassMask + i;
            String answerIdMaskCurrent = answerClassMask + i;
            System.out.println(headerIdMaskCurrent);

            By headerElemLocator = By.id(headerIdMaskCurrent);
            By answerElemLocator = By.id(answerIdMaskCurrent);

            WebElement headerElem = driver.findElement(headerElemLocator);
            String headerElemText = headerElem.getText();
            assert page.getQuestionElem(headerElemText) != null;
            headerElem.click();

            driver.manage().timeouts().implicitlyWait(1000,
                    TimeUnit.MILLISECONDS);

            WebElement answerElem = driver.findElement(answerElemLocator);

            assert answerElem.isDisplayed();

            String answerElemText = answerElem.getText();
            assert page.getQuestionElem(headerElemText) == answerElemText;
        }
    }

    @After
    public void teardown(){
        this.driver.quit();
    }

}
