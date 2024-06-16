package PWTestcases;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class SelectOptions {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://letcode.in/dropdowns");
		//page.selectOption("#fruits", "3");
		//page.locator("#fruits").selectOption(new SelectOption().setLabel("Apple"));
		page.locator("#fruits").selectOption(new SelectOption().setIndex(3));
		String content=page.locator("p.subtitle").textContent();
		System.out.println(content);
		
		page.locator("#superheros").selectOption(new String[] {"am","aq"});
		
		int optionCount=page.locator("#lang").locator("option").count();
		System.out.println(optionCount);
		
		List <String> allInnerTexts=page.locator("#lang").locator("option").allInnerTexts();
		allInnerTexts.forEach(i->System.out.println(i));
		
		page.locator("#lang").selectOption(new SelectOption().setIndex(optionCount-1));
		
		//page.close();
		//playwright.close();
	}

}

