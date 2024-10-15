package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.PracticeFormPage;
import Pages.SideBarPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubmitFormTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homepagePage = new HomepagePage();
        sideBarPage = new SideBarPage();
        submitFormTest = new SubmitFormTest();
        practiceFormPage = new PracticeFormPage();
    }


    @Test(priority = 10)
    public void submitFormWithAllFieldFilledAndVerifyOutput() {

        String firstName = "Pera";
        String lastName = "Petrovic";
        String email = "pera@example.com";
        String gender = "Male";
        String mobile10digits = "1234555844";
        String month = "April";
        String year = "1970";
        String day = "20";
        String subject = "English";
        String address = "Any Address 12";
        String state = "NCR";
        String city = "Noida";
        String hobbies = "Sports, Reading, Music";
        String homepagedURL = "https://demoqa.com/";
        String formsURL = "https://demoqa.com/forms";
        String practiceFormURL = "https://demoqa.com/automation-practice-form";

        Assert.assertEquals(driver.getCurrentUrl(), homepagedURL);
        homepagePage.clickOnCard("Forms");
        Assert.assertEquals(driver.getCurrentUrl(), formsURL);
        sideBarPage.clickOnSidebarElement("Practice Form");
        Assert.assertEquals(driver.getCurrentUrl(), practiceFormURL);

        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputEmail(email);
        practiceFormPage.clickOnGenderMale();
        practiceFormPage.inputMobile(mobile10digits);
        practiceFormPage.clickOnDateOfBirth();
        practiceFormPage.selectMonth(month);
        practiceFormPage.selectYear(year);
        practiceFormPage.clickOnDay(day);
        practiceFormPage.inputSubject(subject);
        practiceFormPage.uploadPhoto();
        practiceFormPage.clickOnSportBox();
        practiceFormPage.clickOnReadingBox();
        practiceFormPage.clickOnMusicBox();
        practiceFormPage.inputAddress(address);
        practiceFormPage.inputState(state);
        practiceFormPage.inputCity(city);
        practiceFormPage.clickOnSubmitButton();


        practiceFormPage.displayMessage();
        Assert.assertEquals(practiceFormPage.confirmFullName.getText(), firstName + " " + lastName);
        Assert.assertEquals(practiceFormPage.confirmEmail.getText(), email);
        Assert.assertEquals(practiceFormPage.confirmGender.getText(), gender);
        Assert.assertEquals(practiceFormPage.confirmPhoneNumber.getText(), mobile10digits);
        Assert.assertEquals(practiceFormPage.confirmDateOfBirth.getText(), day + " " + month + "," + year);
        Assert.assertEquals(practiceFormPage.confirmSubject.getText(), subject);
        Assert.assertEquals(practiceFormPage.confirmHobbies.getText(), hobbies);
        Assert.assertTrue(practiceFormPage.confirmPicture.isDisplayed());
        Assert.assertEquals(practiceFormPage.confirmAddress.getText(), address);
        Assert.assertEquals(practiceFormPage.confirmStateAndCity.getText(), state + " " + city);
        practiceFormPage.clickOnCloseButton();

        driver.quit();

    }

    @Test(priority = 20)
    public void submitFormWithMandatoryFieldsFilledAndVerifyThatDobIsPresent() {

        String firstName = "Marija";
        String lastName = "Markovic";
        String gender = "Female";
        String mobile10digits = "1234555844";
        String homepagedURL = "https://demoqa.com/";
        String formsURL = "https://demoqa.com/forms";
        String practiceFormURL = "https://demoqa.com/automation-practice-form";

        Assert.assertEquals(driver.getCurrentUrl(), homepagedURL);
        homepagePage.clickOnCard("Forms");
        Assert.assertEquals(driver.getCurrentUrl(), formsURL);
        sideBarPage.clickOnSidebarElement("Practice Form");
        Assert.assertEquals(driver.getCurrentUrl(), practiceFormURL);

        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.clickOnGenderFemale();
        practiceFormPage.inputMobile(mobile10digits);
        practiceFormPage.clickOnSubmitButton();

        practiceFormPage.displayMessage();
        Assert.assertEquals(practiceFormPage.confirmFullName.getText(), firstName + " " + lastName);
        Assert.assertEquals(practiceFormPage.confirmGender.getText(), gender);
        Assert.assertEquals(practiceFormPage.confirmPhoneNumber.getText(), mobile10digits);
        Assert.assertTrue(practiceFormPage.confirmDateOfBirth.isDisplayed());
        System.out.println(practiceFormPage.confirmDateOfBirth.getText());
        practiceFormPage.clickOnCloseButton();

    }

}
