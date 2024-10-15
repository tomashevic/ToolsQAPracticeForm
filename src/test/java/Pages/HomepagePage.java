package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomepagePage extends BaseTest {

    public HomepagePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> formsButton;


    public void clickOnCard(String cardName) {
        for (int i = 0; i < formsButton.size(); i++) {
            if(formsButton.get(i).getText().equals(cardName)) {
                formsButton.get(i).click();
            }
        }
    }

}
