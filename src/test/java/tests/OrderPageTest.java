package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.OrderPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class OrderPageTest {

    WebDriver driver;
    OrderPage page;
    String url = "https://qa-scooter.praktikum-services.ru/order";

    String name;
    String secondName;
    String location;
    String subway;
    String phone;
    String arrivalDate;
    String rentDuration;
    String color;
    String courierComment;
    boolean result;


    @Before
    public void startUpAll(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.get(url);
        this.page = new OrderPage();
    }

    public OrderPageTest(String name, String secondName, String location, String subway, String phone, String arrivalDate, String rentDuration, String color, String courierComment, boolean result){
        this.name = name;
        this.secondName = secondName;
        this.location = location;
        this.subway = subway;
        this.phone = phone;
        this.arrivalDate = arrivalDate;
        this.rentDuration = rentDuration;
        this.color = color;
        this.courierComment = courierComment;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { "Александр", "Парамоновович", "город Москва улица Тверская д.1","Бульвар Рокоссовского", "89542311525", "ноябрь 30", "трое суток", "чёрный жемчуг", "по приезду позвонить", true},
                { "Михаил", "Лиамович", "город Москва улица Тверская д.1","Бульвар Рокоссовского", "89542311525", "ноябрь 29", "трое суток", "чёрный жемчуг", "", false}
        };
    }

    @Test
    public void showOrderPageSuccess(){
        Assert.assertEquals("Url не совпадают!",url, driver.getCurrentUrl());
    }

    @Test
    public void makeOrderSuccess(){

        driver.findElement(page.getNameInputLocator()).sendKeys(this.name);
        driver.findElement(page.getSecondNameInputLocator()).sendKeys(this.secondName);
        driver.findElement(page.getLocationInputLocator()).sendKeys(this.location);
        driver.findElement(page.getLocationSubwayLocator()).click();

        WebElement subwayWrapper = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input"));

        Actions builder = new Actions(driver);
        builder.moveToElement(subwayWrapper);
        builder.clickAndHold(subwayWrapper);
        driver.manage().timeouts().implicitlyWait(1000,
                TimeUnit.MILLISECONDS);
        String xpathSubway = "//*[contains(@class,'select-search__options')]/./li/button/div[2][text()='"+this.subway+"']";
        driver.findElement(By.xpath(xpathSubway)).click();
        builder.release(subwayWrapper);
        driver.findElement(page.getPhoneLocator()).sendKeys(this.phone);
        driver.findElement(By.xpath("//*[contains(@class, 'Button_Middle__1CSJM') and text() = 'Далее']")).click();

        driver.manage().timeouts().implicitlyWait(1000,
                TimeUnit.MILLISECONDS);

        //  Date arrival handle
        String dayInput = this.arrivalDate.substring(this.arrivalDate.lastIndexOf(" ")+1);
        if(dayInput.length() == 1){
            dayInput = "0"+dayInput;
        }
        String monthInput = this.arrivalDate.substring(0, this.arrivalDate.lastIndexOf(" "));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.className("Order_MixedDatePicker__3qiay")));
        WebElement arrivalDateElem = driver.findElement(By.className("Order_MixedDatePicker__3qiay"));
        System.out.println("xsds:"+arrivalDateElem);
        arrivalDateElem.click();
        //  TO-DO: need create month management?
        String installedMonth = this.arrivalDate.substring(0, this.arrivalDate.lastIndexOf(" "));
        String cssClassDay = "react-datepicker__day--0"+dayInput;
        System.out.println("csssss:"+cssClassDay);
        driver.findElement(By.className(cssClassDay)).click();

        //Rent duration Handle
        WebElement rentDurationElem = driver.findElement(page.getRentDurationLocator());
        rentDurationElem.click();
        String xpathDay = "//*[contains(@class, 'Dropdown-option') and text() = '"+this.rentDuration+"']";
        System.out.println("sssx:"+xpathDay);
        driver.findElement(By.xpath(xpathDay)).click();

        String xpathColorLabel = "//*[contains(@class, 'Checkbox_Label__3wxSf')][contains(.,'"+this.color+"')]";
        driver.findElement(By.xpath(xpathColorLabel)).click();
        driver.findElement(page.getcourierCommentLocator()).sendKeys(this.courierComment);
        driver.findElement(By.xpath("//*[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']")).click();
        driver.findElement(By.xpath("//*[contains(@class, 'Button_Middle__1CSJM') and text() = 'Да']")).click();
    }

    @After
    public void teardown(){
        this.driver.quit();
    }
}
