package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class MyStepdefsUserRegistration {
    WebDriver driver;

    @Given("I am using {string} browser")
    public void iAmUsingBrowser(String browser) {
         /* if (browser.equals("firefox")){
            driver = new FirefoxDriver();
        }else {
            driver = new ChromeDriver();
        }*/
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
        WebElement pageTitle = driver.findElement(By.id("titleText1"));
        pageTitle.getText();
    }

    @When("I enter a valid date of birth")
    public void iEnterAValidDateOfBirth() {
        WebElement dateOfBD = driver.findElement(By.name("DateOfBirth"));
        dateOfBD.sendKeys("01/01/2001");
        dateOfBD.sendKeys(Keys.ENTER);
    }

    @And("I enter {string} as the first name")
    public void iEnterAsTheFirstName(String firstName) {
        WebElement userName = driver.findElement(By.id("member_firstname"));
        userName.sendKeys(firstName);
    }

    @And("I enter {string} as the last name")
    public void iEnterAsTheLastName(String lastName) {
        WebElement userLastName = driver.findElement(By.id("member_lastname"));
        userLastName.sendKeys(lastName);
    }

    @And("I enter {string} as the email")
    public void iEnterAsTheEmail(String email) {
        WebElement userEmail = driver.findElement(By.id("member_emailaddress"));
        userEmail.sendKeys(email);
    }

    @And("I confirm the email with {string}")
    public void iConfirmTheEmailWith(String confirmEmail) {
        WebElement userConfirmEmail = driver.findElement(By.id("member_confirmemailaddress"));
        userConfirmEmail.sendKeys(confirmEmail);
    }

    @And("I enter {string} as the password")
    public void iEnterAsThePassword(String password) {
        WebElement userPassWord = driver.findElement(By.id("signupunlicenced_password"));
        userPassWord.sendKeys(password);
    }

    @And("I confirm the password with {string}")
    public void iConfirmThePasswordWith(String confirmPassword) {
        WebElement userConfirmPass = driver.findElement(By.id("signupunlicenced_confirmpassword"));
        userConfirmPass.sendKeys(confirmPassword);
    }

    @And("I select my basketball role")
    public void iSelectMyBasketballRole() {
        WebElement checkRole = driver.findElement(By.cssSelector("label[for='signup_basketballrole_18'] span.box"));
        checkRole.click();
    }

    @And("I accept the Code of Ethics and Terms")
    public void iAcceptTheCodeOfEthicsAndTerms() {
        WebElement checkTerms = driver.findElement(By.cssSelector("label[for='sign_up_25'] span.box"));
        checkTerms.click();
        WebElement checkAge = driver.findElement(By.cssSelector("label[for='sign_up_26'] span.box"));
        checkAge.click();
        WebElement checkCodeOfEthics = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] span.box"));
        checkCodeOfEthics.click();
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
        driver.quit();
    }
}
