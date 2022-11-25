package pages;

import org.openqa.selenium.By;

public class OrderPage {


    private By nameInputLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    private By secondNameInputLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    private By locationInputLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    private By locationSubwayLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    private By phoneLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    private By confirmationButtonLocator = By.className("Button_Middle__1CSJM");


    private By arrivalDateLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input");
    private By rentDurationLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]");
    private By colorChoiseLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]");
    private By courierComment = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");

    //  /html/body/div/div/div[2]/div[3]/button[2]

    public By getNameInputLocator(){
        return nameInputLocator;
    }

    public By getSecondNameInputLocator(){
        return secondNameInputLocator;
    }

    public By getLocationSubwayLocator(){
        return locationSubwayLocator;
    }

    public By getLocationInputLocator(){
        return locationInputLocator;
    }

    public By getPhoneLocator(){
        return phoneLocator;
    }

    public By getConfirmationButtonLocator(){
        return confirmationButtonLocator;
    }

    public By getArrivalDateLocator(){
        return arrivalDateLocator;
    }

    public By getRentDurationLocator(){
        return rentDurationLocator;
    }

    public By getColorChoiseLocator(){
        return colorChoiseLocator;
    }

    public By getcourierCommentLocator(){
        return courierComment;
    }




}
