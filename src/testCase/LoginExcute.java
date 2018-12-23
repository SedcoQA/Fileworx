package testCase;

import config.ActionKeywords;
import config.Compose;
import config.Home;
import config.LoginPage;

public class LoginExcute {
	
	public static void main (String[] args)throws Exception{
		
		try {
		ActionKeywords.openBrowser("chrome");
		ActionKeywords.navigate("http://10.0.10.71/SEDCOWebServer");
		LoginPage.input_Username("root");
		LoginPage.input_Password("root");
		Home.click_Compose();
		Compose.select_Category();
		}
		finally {
			System.out.println("finally");
			ActionKeywords.driver.quit();
		}
		}
	}