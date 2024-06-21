package PWTestcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowHandler {
	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext bx1=browser.newContext();
		Page page=bx1.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Page popup=page.waitForPopup(()->{
			page.click("//a[contains(@href,'twitter')]");
		});
	//	System.out.println(popup.title());
		popup.close();
		System.out.println(page.url());
		page.close();
	}	

}
