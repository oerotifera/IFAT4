package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test(enabled = true)
    public void correctLogin() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        /*loginPage.login("standard_user", "secret_sauce");
        productsPage.boo();*/
        assertTrue(productsPage.titleIsDisplayed());
        assertEquals(productsPage.getTitle(), "Products");
        //productsPage.addToCart("Sauce Labs Backpack");

    }

    @DataProvider(name = "incorrectLoginDate")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: You can only access '/cart.html' when you are logged in."},
                {"", "secret_sauce", "Epic sadface: You can only access '/cart.html' when you are logged in."},
                {"standard_user","", "Epic sadface: You can only access '/cart.html' when you are logged in."}
        };
    }

    @Test(dataProvider = "incorrectLoginDate")
    public void incorrectLogin(String user, String pass, String errorMsg) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}

  /*  @Test
    public void emptydLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMsg(), "Epic sadface: Username is required");
    }

    @Test
    public void emptyLoginPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMsg(), "Epic sadface: Password is required");

    }
}*/

