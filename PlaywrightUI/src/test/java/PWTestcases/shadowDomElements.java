package PWTestcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class shadowDomElements {
	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		Browser browser=pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
//		page.navigate("https://books-pwakit.appspot.com/");
//		page.locator("book-app[apptitle='BOOKS'] #input").fill("Feluda");
//		String text=page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
//		System.out.println(text);
//		page.locator("book-app[apptitle='BOOKS'] .icon").click();
		
		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Black Tea Without Sugar");
	}
}
