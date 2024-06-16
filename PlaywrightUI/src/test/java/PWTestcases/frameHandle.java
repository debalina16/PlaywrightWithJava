package PWTestcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class frameHandle {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
		
		String text=page.frameLocator("frame[name='main']").locator("h2").textContent();
		System.out.println(text);
		
		String text2=page.frame("main").locator("h2").textContent();
		System.out.println(text2);
		
		page.close();
		playwright.close();
	}
}
