package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AuthenticationScreen extends BaseScreen{


    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement editTextEmail;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement editTextPassword;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement registrationButton;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
    MobileElement loginButton;
    @FindBy(id = "android:id/message")
    MobileElement errorTextView;
    @FindBy(id = "android:id/button1")
    MobileElement okBtn;


    public AuthenticationScreen fillEmail(String email){
        waitElement(editTextEmail, 5);
        type(editTextEmail, email);
        return this;
    }
    public AuthenticationScreen fillPassword(String password){
        type(editTextPassword, password);
        return this;
    }

    public ContactListScreen registration(Auth auth){
        fillEmail(auth.getEmail());
        fillPassword(auth.getPassword());
        submitRegistration();
        return new ContactListScreen(driver);
    }
    public ContactListScreen login(Auth auth){
        fillEmail(auth.getEmail());
        fillPassword(auth.getPassword());
        submitLogin();
        return new ContactListScreen(driver);
    }

    public ContactListScreen submitLogin(){
        loginButton.click();
        pause(3000);
        return new ContactListScreen(driver);
    }
    public ContactListScreen submitRegistration(){
        registrationButton.click();
        pause(3000);
        return new ContactListScreen(driver);
    }
    public AuthenticationScreen submitRegistrationNegative(){
        registrationButton.click();
        pause(3000);
        return this;
    }

    public AuthenticationScreen isErrorMessageHasText(String text){
        Assert.assertTrue(isErrorMessageContainsText(text));
        return this;
    }

}
