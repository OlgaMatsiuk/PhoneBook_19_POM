package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactTests extends AppiumConfig {

    int i = new Random().nextInt(1000) + 1000;

    @BeforeMethod
    public void precondition() {
        new AuthenticationScreen(driver)
                .login(Auth.builder()
                        .email("abc_1203@mail.com")
                        .password("$Abcdef12345")
                        .build());
    }

    @Test(invocationCount = 5)
    public void addNewContactPositive() {

        Contact contact = Contact.builder()

                .name("Add_" + i)
                .lastName("Positive")
                .email("add_" + i + "@mail.com")
                .phone("1234567" + i)
                .address("Haifa")
                .description("Add_" + i + "_NewPositive")
                .build();

        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContact()
                .isContactAdded(contact);

    }

}
