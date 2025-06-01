package user;

import utils.PropertyReader;

public class UserFactory {

    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemmmo.user"),
                PropertyReader.getProperty("saucedemmmo.password"));
    }

    public static User withUserPermission() {
        return new User(PropertyReader.getProperty(""),
                PropertyReader.getProperty(""));
    }

    public static User withHRPermission() {
        return new User(PropertyReader.getProperty("hr-link.email.as.employeeHR"),
                PropertyReader.getProperty("hr-link.password.as.employeeHR"));
    }
}
