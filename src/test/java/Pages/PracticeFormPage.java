package Pages;

import Base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BaseTest {

    Select select;


    public PracticeFormPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(css = "label[for='gender-radio-1']")
    public WebElement genderMale;

    @FindBy(css = "label[for='gender-radio-2']")
    public WebElement genderFemale;

    @FindBy(css = "label[for='gender-radio-3']")
    public WebElement genderOther;

    @FindBy(id = "userNumber")
    public WebElement mobile;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirth;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement monthButton;

    @FindBy(className = "react-datepicker__year-select")
    public WebElement yearButton;

    public WebElement DayButton(String day) {
        return driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day react-datepicker__day--')][text()='" + day + "']"));
    }

    @FindBy(id = "subjectsContainer")
    public WebElement subjectField;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    public WebElement sportBox;

    @FindBy(css = "label[for='hobbies-checkbox-2']")
    public WebElement readingBox;

    @FindBy(css = "label[for='hobbies-checkbox-3']")
    public WebElement musicBox;

    @FindBy(id = "uploadPicture")
    public WebElement pictureButton;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "react-select-3-input")
    public WebElement state;

    @FindBy(id = "react-select-4-input")
    public WebElement city;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "closeLargeModal")
    public WebElement closeButton;


    // Assertation elements from table

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement message;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")
    public WebElement confirmFullName;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")
    public WebElement confirmEmail;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")
    public WebElement confirmGender;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")
    public WebElement confirmPhoneNumber;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")
    public WebElement confirmDateOfBirth;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")
    public WebElement confirmSubject;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")
    public WebElement confirmHobbies;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[8]/td[2]")
    public WebElement confirmPicture;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")
    public WebElement confirmAddress;

    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")
    public WebElement confirmStateAndCity;


    public void inputFirstName(String name) {
        firstName.clear();
        firstName.sendKeys(name);
    }

    public void inputLastName(String lName) {
        lastName.clear();
        lastName.sendKeys(lName);
    }

    public void inputEmail(String mail) {
        email.clear();
        email.sendKeys(mail);
    }

    public void clickOnGenderMale() {
        genderMale.click();
    }

    public void clickOnGenderFemale() {
        genderFemale.click();
    }

    public void clickOnGenderOther() {
        genderOther.click();
    }

    public void inputMobile(String phone) {
        mobile.clear();
        mobile.sendKeys(phone);
    }

    public void clickOnDateOfBirth() {
        dateOfBirth.click();
    }

    public void selectMonth(String month) {
        select = new Select(monthButton);
        select.selectByVisibleText(month);
    }

    public void selectYear(String year) {
        select = new Select(yearButton);
        select.selectByVisibleText(year);
    }

    public void clickOnDay(String day) {
        DayButton(day).click();

    }

    public void inputSubject(String subject) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        subjectField = wait.until(ExpectedConditions.elementToBeClickable(By.id("subjectsInput")));
        subjectField.click();
        subjectField.clear();
        subjectField.sendKeys(subject);
        subjectField.sendKeys(Keys.ENTER);
    }

    public void clickOnSportBox() {
        sportBox.click();
    }

    public void clickOnReadingBox() {
        readingBox.click();
    }

    public void clickOnMusicBox() {
        musicBox.click();
    }

    public void uploadPhoto() {
        WebElement inputPicture = pictureButton;
        String picLocation = "C:\\Users\\Test\\Desktop\\IMAGES\\funny.jpg";
        inputPicture.sendKeys(picLocation);
    }

    public void inputAddress(String address) {
        currentAddress.clear();
        currentAddress.sendKeys(address);
    }

    public void inputState(String stateName) {
        state.clear();
        state.sendKeys(stateName);
        state.sendKeys(Keys.ENTER);
    }

    public void inputCity(String cityName) {
        city.clear();
        city.sendKeys(cityName);
        city.sendKeys(Keys.ENTER);
    }

    public void clickOnSubmitButton() {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitButton);
    }

    public void displayMessage() {
        System.out.println(message.getText());
    }

    public void clickOnCloseButton() {
        closeButton.click();
    }

}
