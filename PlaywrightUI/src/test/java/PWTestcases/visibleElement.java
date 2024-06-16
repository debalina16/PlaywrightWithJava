package PWTestcases;
import java.util.List;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class visibleElement {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.amazon.in/");
		List <String> allStringText=page.locator("a:visible").allInnerTexts();
		for(int i=0;i<allStringText.size();i++) {
			System.out.println(allStringText.get(i));
		}
		
		int allImgCount=page.locator("//img>>visible=true").count();
		System.out.println(allImgCount);
			
		page.close();
		playwright.close();
	}
}
