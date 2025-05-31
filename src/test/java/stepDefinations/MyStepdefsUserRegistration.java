package stepDefinations;

import common.ExplicitWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MyStepdefsUserRegistration {
    WebDriver driver;

    @Given("I am using {string} browser")
    public void iAmUsingBrowser(String browser) {
          if (browser.equals("firefox")){
            driver = new FirefoxDriver();
        }else {
            driver = new ChromeDriver();
        }
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {

        driver.findElement(By.id("titleText1")).getText();
    }

    @When("I enter {string} as the date of birth")
    public void iEnterDateOfBirth(String dob) {
        WebElement dateOfBD = driver.findElement(By.name("DateOfBirth"));
        dateOfBD.clear();
        dateOfBD.sendKeys(dob);
        dateOfBD.sendKeys(Keys.ENTER);
    }

    @And("I enter {string} as the first name")
    public void iEnterAsTheFirstName(String firstName) {
         driver.findElement(By.id("member_firstname")).sendKeys(firstName);

    }

    @And("I enter {string} as the last name")
    public void iEnterAsTheLastName(String lastName) {
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);

    }

    @And("I enter {string} as the email")
    public void iEnterAsTheEmail(String email) {
         driver.findElement(By.id("member_emailaddress")).sendKeys(email);

    }

    @And("I confirm the email with {string}")
    public void iConfirmTheEmailWith(String confirmEmail) {
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);

    }

    @And("I enter {string} as the password")
    public void iEnterAsThePassword(String password) {
         driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);

    }

    @And("I confirm the password with {string}")
    public void iConfirmThePasswordWith(String confirmPassword) {
         driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);

    }

    @And("I select my basketball role")
    public void iSelectMyBasketballRole() {
        driver.findElement(By.cssSelector("label[for='signup_basketballrole_18'] span.box")).click();

    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        WebElement joinBtn = driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']"));
        joinBtn.getAttribute("value");
        joinBtn.click();
    }

    @Then("I should see a confirmation message {string}")
    public void iShouldSeeAConfirmationMessage(String expected) {
        WebElement succesfulRegistration = driver.findElement(By.cssSelector("h2.bold"));
        String actual = succesfulRegistration.getText();
        assertEquals(expected,actual);
    }

    @And("I {string} the terms and conditions")
    public void iTheTermsAndConditions(String acceptTerms) {
        if (acceptTerms.equalsIgnoreCase("accept")){
            driver.findElement(By.cssSelector("label[for='sign_up_25'] span.box")).click();
        }
    }

    @And("I accept the age over Eighteen")
    public void iAcceptTheAgeOverEighteen() {
        driver.findElement(By.cssSelector("label[for='sign_up_26'] span.box")).click();
    }
    @And("I accept the Code of Ethics")
    public void iAcceptTheCodeOfEthics() {
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span.box")).click();
    }

    @Then("I should see an error message for {string} saying {string}")
    public void iShouldSeeAnErrorMessageForSaying(String field, String expected) {
        WebElement message;

        if (field.equals("ConfirmationMessage")) {
            message = waitUntilFieldVisible(By.cssSelector("h2.bold"));
        } else {
            message = ExplicitWait.waitForVisible(driver, By.cssSelector(".field-validation-error span[for='" + field + "']")
            );
        }

        String actual = message.getText();
        assertEquals(expected.trim(), actual.trim());

         driver.close();
    }
    private WebElement waitUntilFieldVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
