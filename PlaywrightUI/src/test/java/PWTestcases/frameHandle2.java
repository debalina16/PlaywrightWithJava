package PWTestcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class frameHandle2 {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		page.locator("//img[@title='Vehicle-Registration-Forms-and-Examples']").click();
		
		page.frameLocator("//iframe[contains(@id,'frame-one')]")
		            .locator("#RESULT_TextField-8").fill("Debalina");
		
		page.frameLocator("//iframe[contains(@id,'frame-one')]")
        			.locator("#RESULT_TextField-9").fill("Das");
		
		page.frameLocator("//iframe[contains(@id,'frame-one')]")
		            .locator("#RESULT_TextField-10").fill("Patalnagar");

		//page.frameLocator("//iframe[contains(@id,'frame-one')]")
        //           .locator("//*[@id='RESULT_RadioButton-13']").selectOption(new SelectOption().setLabel("Iowa"));

		page.frameLocator("//iframe[contains(@id,'frame-one')]")
                   .locator("//*[@id='RESULT_RadioButton-13']").selectOption(new SelectOption().setIndex(5));

		page.close();
		playwright.close();

	}
}
