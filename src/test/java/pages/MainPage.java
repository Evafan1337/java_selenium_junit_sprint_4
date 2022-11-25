package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class MainPage extends BasePage{

    WebDriver driver;
    private By questionsAndAnswersBlock = By.className("Home_FourPart__1uthg");
    private int questionsCount = 0;
    private String questionsAndAnswersElem = "accordion__heading-";
    private String questionsAndAnswersElemAnswer = "accordion__panel-";



    private HashMap<String, String> questionsAndAnswersValues= new HashMap<>();


    public String getQuestionsAndAnswersElem(){
        return this.questionsAndAnswersElem;
    }

    public String getQuestionsAndAnswersElemAnswer(){
        return this.questionsAndAnswersElemAnswer;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public By getquestionsAndAnswersBlock(){
        return this.questionsAndAnswersBlock;
    }

    public MainPage(){
        super();
        this.initialQuestionsAndAnswersValues();
        this.setQuestionsCount();
    }
    private void initialQuestionsAndAnswersValues(){
        questionsAndAnswersValues.put("Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        questionsAndAnswersValues.put("Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        questionsAndAnswersValues.put("Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        questionsAndAnswersValues.put("Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        questionsAndAnswersValues.put("Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        questionsAndAnswersValues.put("Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        questionsAndAnswersValues.put("Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        questionsAndAnswersValues.put("Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    public String getQuestionElem(String key){
        return questionsAndAnswersValues.get(key);
    }

    private void setQuestionsCount(){
        this.questionsCount = questionsAndAnswersValues.size();
    }

    public int getQuestionsCount(){
        return this.questionsCount;
    }

}
