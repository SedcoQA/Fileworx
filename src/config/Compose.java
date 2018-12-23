package config;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Compose {
	WebDriver driver = ActionKeywords.driver;
	
	public static void click_Compose () {
		ActionKeywords.driver.findElement(By.cssSelector("i.fa.fa-pencil.fa-lg")).click();
	}
	
	public static void fill_Title (String title) {
		ActionKeywords.driver.findElement(By.id("txtTitle")).sendKeys(title);
	}
	
	public static void select_Tag_1 () {
		Select tag1 = new Select (ActionKeywords.driver.findElement(By.id("Classifications_FirstLevel")));
		//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
		List <WebElement> tag1Options = tag1.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(tag1Options.size());
		///////////////////
		tag1.selectByIndex(r);
	}
	
	public static void select_Tag_2 () {
		//The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
		if (ActionKeywords.driver.findElement(By.id("Classifications_SecondLevel")).isDisplayed()) {
			//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
			Select tag2 = new Select (ActionKeywords.driver.findElement(By.id("Classifications_SecondLevel")));
			List <WebElement> tag2Options = tag2.getOptions();
			Random rand = new Random();
			int r = rand.nextInt(tag2Options.size());
			/////////////////////
			tag2.selectByIndex(r);
		}
	}

	public static void select_tag_3 () {
		//The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
		if (ActionKeywords.driver.findElement(By.id("Classifications_ThirdLevel")).isDisplayed()) {
			Select tag2 = new Select (ActionKeywords.driver.findElement(By.id("Classifications_ThirdLevel")));
			//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
			List <WebElement> tag2Options = tag2.getOptions();
			Random rand = new Random();
			int r = rand.nextInt(tag2Options.size());
			/////////////////
			tag2.selectByIndex(r);
		}
	}
	
	public static void select_Tag_4 () {
		//The if statement to check if Tag 4 is available since not all tags contain multiple Tag levels
		if (ActionKeywords.driver.findElement(By.id("Classifications_FourthLevel")).isDisplayed()) {
			Select tag2 = new Select (ActionKeywords.driver.findElement(By.id("Classifications_FourthLevel")));
			//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
			List <WebElement> tag2Options = tag2.getOptions();
			Random rand = new Random();
			int r = rand.nextInt(tag2Options.size());
			/////////////////////////
			tag2.selectByIndex(r);
		}
	}
	
	public static void select_Category () {
		//Click on category field to open the list
		ActionKeywords.driver.findElement(By.cssSelector("div.chosen-container.chosen-container-multi")).click();
		//Save all <li> options in the <ul> tag and find it length then select an option randomly.
		WebElement ul = ActionKeywords.driver.findElement(By.cssSelector("#ddlCategory_chosen > div > ul"));
		List <WebElement> li = ul.findElements(By.tagName("li"));
		Random rand = new Random();
		int r = rand.nextInt(li.size());
		li.get(r).click();

	}
	
	public static void select_Event () {
		Select Event = new Select (ActionKeywords.driver.findElement(By.id("ddlEvent")));
		//We used List class to save all the options in the <Select> tag and find it length then select an option randomly
		List <WebElement> eventOptions = Event.getOptions();
		Random rand = new Random();
		int r = rand.nextInt(eventOptions.size());
		/////////////////////
		Event.selectByIndex(r);
	}
	
	public static void select_Task () {
		Select Task = new Select (ActionKeywords.driver.findElement(By.id("ddlEventTask")));
		//We used List class to save all the options in the <Select> tag and find it length then select an option randomly 
		List <WebElement> taskOptions = Task.getOptions();
		if (taskOptions.size()!= 0) {
		Random rand = new Random();
		int r = rand.nextInt(taskOptions.size());
		/////////////////
		Task.selectByIndex(r);
		}
	}
	
	public static void fill_Body (String body) {
		//We used action class to focus on the Body since its not a normal textbox 
		Actions action = new Actions(ActionKeywords.driver);
		action.moveToElement(ActionKeywords.driver.findElement(By.id("cke_1_contents")));
		action.click();
		action.sendKeys(body);
		action.build().perform();
	}

	public static void upload_Attachment (String filePath) throws AWTException{
		//Click on attachment button to display attachment box.
		ActionKeywords.driver.findElement(By.id("btnAttachments")).click();
		//click on attachment box to open brows window.
		ActionKeywords.driver.findElement(By.id("dropzoneForm")).click();;
		
		//put the path of you file in clipboard.
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//Use Robot class to simulate keyboard actions
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public static void send_News (String Contact){
		//click on send button to open contacts list
		ActionKeywords.driver.findElement(By.id("btn-toggle-tasks-list")).click();
		//select the contact by sending its name.
		ActionKeywords.driver.findElement(By.linkText(Contact)).click();
	}
	
	public static void fill_Note(String note){
		//click on Note button to open note text box.
		ActionKeywords.driver.findElement(By.id("btnNotes")).click();
		//fill the note by passing note parameter.
		ActionKeywords.driver.findElement(By.id("Notes")).sendKeys(note);
	}
	
	public static void save_News () {
		ActionKeywords.driver.findElement(By.id("btnSaveHeader")).click();
	}
	
	public static void discard_News () {
		ActionKeywords.driver.findElement(By.id("btnDiscardHeader")).click();
	}
	
	public static void selectAll () {
		ActionKeywords.driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__selectall_icon")).click();
	}
	
	public static void cut () {
		ActionKeywords.driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__cut_icon")).click();
	}
	
	public static void copy() {
		ActionKeywords.driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__copy_icon")).click();
	}
	
	public static void paste() throws AWTException{
		//Click on Paste button in Editing bar
		ActionKeywords.driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__pastetext_icon")).click();
		
		//Use Robot class to simulate keyboard actions to paste the copied text (CTRL+V)
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//Click on OK button
		ActionKeywords.driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_ok")).click();
	}
	
	public static void undo() {
		ActionKeywords.driver.findElement(By.className("span.cke_button_icon.cke_button__undo_icon")).click();
	}
	
	public static void redo() {
		ActionKeywords.driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__redo_icon")).click();
	}
	
	public static void find(String findWhat) {
		//click on Find button in Editing bar
		ActionKeywords.driver.findElement(By.cssSelector("span.cke_button_icon.cke_button__find_icon")).click();
		//fill find textbox with required value
		ActionKeywords.driver.findElement(By.cssSelector("input.cke_dialog_ui_input_text")).sendKeys(findWhat);
		//click on Find button
		ActionKeywords.driver.findElement(By.cssSelector("a.cke_dialog_ui_button[title=Find]")).click();
		//Close Find window
		ActionKeywords.driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_cancel[title=Close]")).click();
	}
	
	public static void leftAlign () {
		ActionKeywords.driver.findElement(By.id("cke_25")).click();
	}
	
	public static void rightAlign () {
		ActionKeywords.driver.findElement(By.id("cke_26")).click();
	}
	
	public static void insertSeparator () {
		ActionKeywords.driver.findElement(By.id("cke_29")).click();
	}
	
	public static void replace (String find, String replace) {
		//click on replace button from Editing bar.
		ActionKeywords.driver.findElement(By.id("cke_21")).click();
		//fill find and replace text fields with required values
		ActionKeywords.driver.findElement(By.id("cke_76_textInput")).sendKeys(find);
		ActionKeywords.driver.findElement(By.id("cke_85_textInput")).sendKeys(replace);
		//click on replace all button
		ActionKeywords.driver.findElement(By.id("cke_91_label")).click();
		//wait until alert window is displayed then accept it
		WebDriverWait wait = new WebDriverWait (ActionKeywords.driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = ActionKeywords.driver.switchTo().alert();
		alert.accept();
		//close replace window
		ActionKeywords.driver.findElement(By.cssSelector("a.cke_dialog_ui_button.cke_dialog_ui_button_cancel[title=Close]")).click();
	}

	public static void publishToTwitter (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		ActionKeywords.driver.findElement(By.cssSelector("label.onoffswitch-label[for=TwitterEnable]")).click();
		//Fill the required text to be published
		ActionKeywords.driver.findElement(By.id("TwitterSummary")).sendKeys(whatToShare);
	}
	
	public static void publishToFacebook (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		ActionKeywords.driver.findElement(By.cssSelector("label.onoffswitch-label[for=FacebookEnable]")).click();
		//Fill the required text to be published
		ActionKeywords.driver.findElement(By.id("facebooksummary")).sendKeys(whatToShare);
	}
	
	public static void publishToYoutube (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		ActionKeywords.driver.findElement(By.cssSelector("label.onoffswitch-label[for=YoutubeEnable")).click();
		//Fill the required text to be published
		ActionKeywords.driver.findElement(By.id("youtubeSummary")).sendKeys(whatToShare);
	}
	
	public static void publishToInstagram (String whatToShare) {
		//Click on the switch button to turn publishing on/off
		ActionKeywords.driver.findElement(By.cssSelector("label.onoffswitch-label[for=InstagramEnable")).click();
		//Fill the required text to be published
		ActionKeywords.driver.findElement(By.id("InstagramSummary")).sendKeys(whatToShare);
	}
	

}
