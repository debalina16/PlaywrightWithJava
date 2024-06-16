package PWTestcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		//lp.setChannel("chrome");
		lp.setChannel("msedge");
		lp.setHeadless(false);
		Browser browser=playwright.chromium().launch(lp);
		//Browser browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.amazon.in");
		System.out.println(page.url());
		System.out.println(page.title());
		page.close();
		playwright.close();
	}

}
