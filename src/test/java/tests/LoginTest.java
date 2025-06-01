package tests;

import com.google.j2objc.annotations.Property;
import enums.DepartmentNaming;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserFactory;

import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Epic("Модуль логина интернет магазина")
    @Feature("Юридические лица")
    @Story("MMM")
    @Severity(SeverityLevel.BLOCKER)
    @Property("Приоритетность исправления")
    @Owner("Natalia Vasileva, adxomyak13@yandex.ru")
    @TmsLink("IFAT4")
    @Issue("1")
    @Test(description = "проверка верной авторизации")
    public void correctLogin() {
        loginPage.open()
                .login(UserFactory.withAdminPermission());
        assertTrue(productsPage.titleIsDisplayed());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }


    @DataProvider(name = "incorrectLoginDate")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "123", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Модуль логина интернет магазина")
    @Feature("Юридические лица")
    @Story("MMM")
    @Severity(SeverityLevel.BLOCKER)
    @Property("Приоритетность исправления")
    @Owner("Natalia Vasileva, adxomyak13@yandex.ru")
    @TmsLink("IFAT4")
    @Issue("1")
    @Test(dataProvider = "incorrectLoginDate", description = "проверка невалидных данных входа")
    public void incorrectLoginDate(String user, String pass, String errorMsg) {
        loginPage
                .open()
                .fillLoginInput(user)
                .fillPasswordInput(pass)
                .clickSubmitBtn();
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}