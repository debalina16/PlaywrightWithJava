package PWTestcases;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SelectElement {
	public static void main(String[] args) {
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=screensize.width;
		int height=screensize.height;
		System.out.println(width+" "+height);
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		BrowserContext context=browser
//				.newContext(new Browser.NewContextOptions().setViewportSize(780,500));
		browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		Page page=browser.newPage();
		//	page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
		//	Locator loc=page.locator("select#Form_getForm_Country:has(option[value='India'])");
		//	loc.allInnerTexts().forEach(e->{System.out.println(e);});
		page.navigate("https://www.amazon.com");
		Locator locator=page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		locator.allInnerTexts().forEach(e->{System.out.println(e);});
		page.close();
		playwright.close();
	}

}
