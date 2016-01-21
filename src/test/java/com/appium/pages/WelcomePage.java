package com.appium.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.appium.config.CommonAppiumTest;
import com.appium.config.DeviceInterface;
import com.appium.config.ViewFactory;
import com.appium.page.objects.WelcomePageObjects;
import com.report.factory.ExtentTestManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage extends CommonAppiumTest {
	public ViewFactory viewFactory = new ViewFactory(driver);
	public DeviceInterface runnerInfo;
	WelcomePageObjects welcomePageObjects = new WelcomePageObjects();

	public WelcomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), welcomePageObjects);
		runnerInfo = viewFactory.getMobilePlatform(System.getenv("PLATFORM"));
	}

	public WelcomePage waitForWelcomePage() {
		runnerInfo.waitForHomePage(this);
		ExtentTestManager.logOutPut("WelcomePage is displayed");
		return new WelcomePage(driver);

	}

	public PublishPage writePost() {
		welcomePageObjects.WRITE_POST.click();
		return new PublishPage(driver);
	}

	public PostPage clickPostPage() {
		welcomePageObjects.BLOG_POST.click();
		return new PostPage(driver);
	}

	public CommentPage clickComments() {
		welcomePageObjects.COMMENT.click();
		waitForElement(welcomePageObjects.SELECT_BLOG.get(0));
		List<MobileElement> el = welcomePageObjects.SELECT_BLOG;
		el.get(0).click();		
		return new CommentPage(driver);

	}

	public String verifyUserIsLoggedIn() {
		return welcomePageObjects.LOGGED_IN_USER.getText();
	}

	public void waitForHomePageToLoad() {
		waitForElement(welcomePageObjects.WELCOME_PAGE);
	}

	public void acceptEditorToolTip() {
		waitForElement(welcomePageObjects.ACCEPT_TIP).click();
	}

	public void selectBlog() {
		welcomePageObjects.SELECT_BLOG.get(0).click();
	}

	public AccountsPage clickOnMe() {
		welcomePageObjects.SELECT_ME.click();
		return new AccountsPage(driver);
	}

	public AccountsPage moveToDisconnect() {
		runnerInfo.moveToLogOutScreen(this);
		return new AccountsPage(driver);
	}

}
