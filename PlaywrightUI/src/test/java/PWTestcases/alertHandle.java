package PWTestcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class alertHandle {
	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.onDialog(dialog ->{
			String message=dialog.message();
			System.out.println(message);
			dialog.accept("Hii,This is Debalina");
		});
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		page.click("//button[text()='Click for JS Alert']");
		String text=page.textContent("#result");
		System.out.println(text);

		page.click("//button[text()='Click for JS Confirm']");
		String text1=page.textContent("#result");
		System.out.println(text1);

		page.click("//button[text()='Click for JS Prompt']");
		String text2=page.textContent("#result");
		System.out.println(text2);

		page.close();
		browser.close();
		playwright.close();
	}
}
