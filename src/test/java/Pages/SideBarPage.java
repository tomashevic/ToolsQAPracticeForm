package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBarPage extends BaseTest {

    public SideBarPage() {
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "span[class='text']")
    public List<WebElement> sidebarElement;

    public void clickOnSidebarElement(String login) {
        for (int i = 0; i < sidebarElement.size(); i++) {
            if (sidebarElement.get(i).getText().equals(login)) {
                sidebarElement.get(i).click();
            }
        }
    }
}

