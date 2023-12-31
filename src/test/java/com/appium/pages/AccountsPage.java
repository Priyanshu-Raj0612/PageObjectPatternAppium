package com.appium.pages;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.AccountsPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage extends CommonAppiumTest {

    AccountsPageObject accountsPageObject = new AccountsPageObject();

    public AccountsPage(AppiumDriver driver) {
        super(driver);
        // loadPage();
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountsPageObject);
    }

    public LoginPage logOut() {
        accountsPageObject.LOGOUT.click();
        accountsPageObject.DISCONNECT.click();
        return new LoginPage(driver);
    }

}
