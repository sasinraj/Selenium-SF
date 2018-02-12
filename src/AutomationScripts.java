

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class AutomationScripts extends ReUsableMethods  {
	public static void loginSalesForce() throws Exception{
        
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		launchApplication(url);
		Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
	}
	
	public static void LogintoSalesforce() throws IOException, InterruptedException{
		
		startReport("LogintoSalesforce", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		launchApplication(url);
		Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		driver.quit();
		
		bw.close();
	}

	
	public static void LoginErrorMessage() throws IOException{
		startReport("LoginErrorMessage", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		String url = recdata[1][0];
		launchApplication(url);
		
		//String expectedErrorMsg = "Please enter your password.";
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, "username", "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, "", "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		
		
		driver.quit(); // driver.close --> will close only active browser , driver.quit --> will close all instance of browser
		
		bw.close();
		
	}
	
	public static void checkRemeberMe() throws Exception
	{
		startReport("checkRemeberMe", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		launchApplication(url);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		WebElement un = driver.findElement(By.xpath(".//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath(".//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath(".//*[@id='Login']"));
		/*Enter username to user name field  */
		enterText(un,UN,"Username");
		/*Enter pwd to password field  */
		enterText(pwd,pd, "Password");
		/*click on login button  */
		clickButton(login, "Login");
		/*click on profile button  */
		WebElement log = driver.findElement(By.xpath(".//*[@id='userNavButton']"));
		clickButton(log, "userNavButton");
		/*click on menu button  */
		WebElement menu = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
		clickButton(menu, "Logout");
		WebElement rem = driver.findElement(By.xpath(".//*[@id='rememberUn']"));
		/*click on the remeberme button */
		selectCheckBox(rem, "Remember me");
		//deselectCheckBox(rem, "Remember me");
		/*click on remeber me chek box */
		clickButton(rem,"Remember me");
		
		driver.quit();
		

	}
	
	public static void forgotPassword4A() throws Exception
	{
		startReport("forgotPassword4A", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		launchApplication(url);
		
		WebElement forgetpwd = driver.findElement(By.xpath(".//*[@id='forgot_password_link']"));

		webLink(forgetpwd, "Forgot Your Password?");
		WebElement user = driver.findElement(By.xpath(".//*[@id='un']"));
		WebElement con_btn = driver.findElement(By.xpath(".//*[@id='continue']"));
		
		enterText(user,UN, "Username");
		clickButton(con_btn, "Continue");
		driver.quit();
	}
	
	public static void forgetPassword4B() throws Exception
	{
		startReport("forgotPassword4B", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		
		launchApplication(url);
		
		String errormsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		WebElement un = driver.findElement(By.xpath(".//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath(".//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath(".//*[@id='Login']"));
		/*Enter username to user name field  */
		enterText(un,UN,"Username");

		/*Enter pwd to password field  */
		enterText(pwd,"121121", "Password");
		clickButton(login, "Login");
		WebElement wemsg =driver.findElement(By.xpath(".//*[@id='error']"));
		String actualmsg=wemsg.getText();
		if(errormsg.equalsIgnoreCase(actualmsg))
		{
			System.out.println("Pass:Error message is displayd");
		}
		else
		{
			System.out.println("fail:Error message not displayd");
		}
		driver.quit();
	}
	

	public static void userMenuDropDown() throws Exception
	{
		startReport("userMenuDropDown", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		launchApplication(url);
		Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		//loginSalesForce();
		//Thread.sleep(4000);
		//WebElement log = driver.findElement(By.xpath(".//*[@id='userNavButton']"));
		//clickButton(log, "userNavButton");
		//WebElement unmenu = driver.findElement(By.xpath(".//*[@id='userNav-arrow']"));
		//clickButton(unmenu, "sasi naveen");
		Thread.sleep(4000);
		//WebElement profi = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
		
		WebElement unmenu1 = driver.findElement(By.id("userNavButton"));
		clickButton(unmenu1, "sasi n");
		//WebElement log = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
		
		
		//clickButton(profi, "My Profile");
		//clickButton(unmenu1, "Harri rangarajan");
		//clickButton(log, "Logout");
		//webLink(unmenu, "Hari rangarajan");
		//webLink(profi, "My Profile");
		//webLink(log, "Logout");
		driver.close();
	
	}

	public static void userMenuDropDownTC6() throws Exception
	{
		
		startReport("userMenuDropDownTC6", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		//for (int i = 0; i<10;i++)
		launchApplication(url);
		//Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		//loginSalesForce();
		Thread.sleep(4000);
		
		//WebElement unmenu = driver.findElement(By.xpath(".//*[@id='userNavButton']"));
		//WebElement unmenu = driver.findElement(By.xpath(".//*[@id='userNav-arrow']"));
		WebElement unmenu = driver.findElement(By.xpath(".//*[@id='userNavButton']"));
		//WebElement unmenu = driver.findElement(By.xpath(".//*[@id='userNav-arrow']"));
		//Thread.sleep(4000);
		WebElement profi = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[1]"));
				
		clickButton(unmenu, "sasi naveen");
		clickButton(profi, "My Profile");
		Thread.sleep(4000);
		/* Editing the profile*/
		 WebElement editimg = driver.findElement(By.xpath(".//*[@id='chatterTab']/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		 clickButton(editimg, "Edit Profile");
		Thread.sleep(4000);
		
		driver.switchTo().frame("contactInfoContentId");
		WebElement wframe = driver.findElement(By.xpath(".//*[@id='aboutTab']/a"));
		wframe.click();
		WebElement wlast = driver.findElement(By.id("lastName"));
		clearText(wlast,"lastName");
		
		enterText(wlast, "naveen ", "lastName");
		WebElement save2 = driver.findElement(By.xpath(".//*[@id='TabPanel']/div/div[2]/form/div/input[1]"));
		clickButton(save2, "Save All");
	
		//driver.findElement(By.xpath(".//*[@id='TabPanel']/div/div[2]/form/div/input[1]")).click();
		driver.switchTo().defaultContent();
		
		// Post the text and click on Share button
		 //WebElement webpost = driver.findElement(By.xpath(".//*[@id='publishereditablearea']"));
		WebElement webpost= driver.findElement(By.xpath(".//*[@id='publisherAttachTextPost']/span[1]"));
		WebElement share = driver.findElement(By.xpath(".//*[@id='publishersharebutton']"));
		clickButton(webpost, "Post");
		enterText(webpost, "Hello Everyone", "Post");
		clickButton(share, "Share");
		
		
		/* Share the file from Computer */
		
		 WebElement webfile = driver.findElement(By.xpath(".//*[@id='publisherAttachContentPost']/span[1]"));
		 clickButton(webfile, "file");
		// webfile .click();
		//WebElement share = driver.findElement(By.xpath(".//*[@id='publishersharebutton']"));
		String workingDir = System.getProperty("user.dir");
		String filepath = workingDir + "\\text12.txt";
		//driver.get(filepath);
		webfile = driver.findElement(By.xpath(".//*[@id='chatterUploadFileAction']"));
		webfile.click();
		webfile = driver.findElement(By.xpath(".//*[@id='chatterFile']"));
		webfile.sendKeys(filepath);
		WebElement share1 = driver.findElement(By.xpath(".//*[@id='publishersharebutton']"));
		share1.click();
		Thread.sleep(4000); 
		
		/* Upload profile picture */
		//WebElement tnail= driver.findElement(By.xpath(".//*[@id='photoSection']/span[2]/img[1]"));
		//tnail.click();
		WebElement photoLink = driver.findElement(By.xpath(".//*[@id='uploadLink']"));
		photoLink.click();
		/*click the browser */
		driver.switchTo().frame("uploadPhotoContentId");
		String workingDir1 = System.getProperty("user.dir");
		String filepath1 = workingDir1 + "\\green.png";
		WebElement photofile = driver.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadInputFile']"));
		photofile.sendKeys(filepath1);
		Thread.sleep(2000);
		//WebElement save = driver.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:save']"));.//*[@id='j_id0:uploadFileForm:save'] .//*[@id='j_id0:j_id7:save']
		WebElement save = driver.findElement(By.xpath(".//*[@id='j_id0:uploadFileForm:uploadBtn']"));
		clickButton(save, "save");
		
		//save.click();
		Thread.sleep(3000);
		WebElement save1 = driver.findElement(By.xpath(".//*[@id='j_id0:j_id7:save']"));		//WebElement save1 = driver.findElement(By.id("j_id0:j_id7:save"));
		clickButton(save1, "save1");
		driver.switchTo().defaultContent();
		
		driver.quit();
	}

	public static void userMenuTC07() throws Exception
	{
		
		startReport("userMenuTC07", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		//Create FireFox Profile object
				FirefoxProfile profile = new FirefoxProfile();
		 
				//Set Location to store files after downloading.
				profile.setPreference("browser.download.dir", "C:\\SeleniumDriver");
				profile.setPreference("browser.download.folderList", 2);
		 
				//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
			//	profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
				//    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
				
				  profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
						    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//MIME types Of MS Excel File.
						    + "application/pdf;" //MIME types Of PDF File.
						    + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //MIME types Of MS doc File.
						    + "text/plain;" //MIME types Of text File.
						    + "text/csv"); //MIME types Of CSV File.
		 
				profile.setPreference( "browser.download.manager.showWhenStarting", false );
				profile.setPreference( "pdfjs.disabled", true );
				profile.setPreference("browser.download.manager.focusWhenStarting", false);
				profile.setPreference("browser.download.manager.useWindow", false);
				
				FirefoxDriver driver = new FirefoxDriver(profile);
				driver.get(url);
		//launchApplication(url);
		//Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		/*Click on user profile  */
		 
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement umenu = driver.findElement(By.xpath(".//*[@id='userNavButton']"));
		//WebElement umenu = driver.findElement(By.xpath(".//*[@id='userNavLabel']"));
		clickButton(umenu, "sasi n");
		/* Click on the My Setting link*/
		WebElement setting = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
		clickButton(setting, "My Settings");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*Click on the personal link  */
		WebElement person = driver.findElement(By.xpath(".//*[@id='PersonalInfo']/a"));
		clickButton(person, "Personal");
		/*Click on the Log History link  */
		WebElement hist = driver.findElement(By.xpath(".//*[@id='LoginHistory_font']"));
		clickButton(hist, "Login History");
		/*Download the file */
		WebElement down = driver.findElement(By.xpath(".//*[@id='RelatedUserLoginHistoryList_body']/div/a"));
		//WebElement down = driver.findElement(By.linkText("Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file)"));
		clickButton(down, "link");
		
		driver.quit();	
	}
	
	public static void userMenuTc07A() throws Exception{
		startReport("userMenuTc07A", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		//for (int i = 0; i<10;i++)
		launchApplication(url);
		//Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		//loginSalesForce();
		Thread.sleep(4000);
		
		WebElement umenu = driver.findElement(By.xpath(".//*[@id='userNavLabel']"));
		clickButton(umenu, "sasi n");
		/* Click on the My Setting link*/
		WebElement setting = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[2]"));
		clickButton(setting, "My Settings");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*click on display and Layout */
		WebElement disp = driver.findElement(By.xpath(".//*[@id='DisplayAndLayout']/a"));
		clickButton(disp, "Diaplay & Layout");
		/*Click on Custom tag  */
		WebElement custom = driver.findElement(By.xpath(".//*[@id='CustomizeTabs_font']"));
		clickButton(custom, "Tag");

		/*Select the Chartter from the drop down */
		/*WebElement chat = driver.findElement(By.id("p4"));
		Select dd = new Select(chat);
		dd.selectByIndex(0);*/
		WebElement chatter = driver.findElement(By.xpath(".//*[@id='p4']"));
		Select dropdown = new Select(chatter);
		dropdown.selectByIndex(8);
		
		/*Report is selected from the list */
		WebElement droplist = driver.findElement(By.xpath(".//*[@id='duel_select_0']"));
		Select drop = new Select(droplist);
		drop.selectByValue("report");
		
		/*Click on the add button  */
		WebElement add = driver.findElement(By.xpath(".//*[@id='duel_select_0_right']/img"));
		clickButton(add, "Add");
		
		/*WebElement report = driver.findElement(By.xpath(".//*[@id='duel_select_1']/option[6]"));
		clickButton(tab, "Report");
		selectCheckBox(report, "Report");*/
		
		/*click on the save button */
		WebElement save= driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"));
		clickButton(save, "Save");
		

		
		/* click on the email tab*/
		
		WebElement email = driver.findElement(By.xpath(".//*[@id='EmailSetup']/a"));
		clickButton(email, "Email");
		//enterText(email, "sasiim04@gmail.com","Email Address");
		
		/* click on the My EmailSettings */
		 
		
		WebElement myemail = driver.findElement(By.xpath(".//*[@id='EmailSettings_font']"));
		clickButton(myemail, "My Email Setting");
		
		
		 /*click on radio button */
		 WebElement radio = driver.findElement(By.xpath(".//*[@id='auto_bcc1']"));
		 selectCheckBox(radio, "Yes");
		 
		 /*Click on the Save button */
		 WebElement savebut = driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"));
		 clickButton(savebut, "Save");
		
		/*Click on the calender & Remainder tab */
			WebElement calender = driver.findElement(By.xpath(".//*[@id='CalendarAndReminders']/a"));
			clickButton(calender, "CalnderAndReminder");
			
			/*Click on Activity Remainder tab  */
		WebElement remain = driver.findElement(By.xpath(".//*[@id='Reminders_font']"));
		clickButton(remain, "Remainders");
		
		
		/*Click on perview button for popup button */
		WebElement testremainder = driver.findElement(By.xpath(".//*[@id='testbtn']"));
		clickButton(testremainder, "testbutton");
		
		driver.quit();
		
	}
	
	public static void developerConsoleTC08() throws Exception{
		
		startReport("developerConsoleTC08", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		//for (int i = 0; i<10;i++)
		launchApplication(url);
		//Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		//loginSalesForce();
		Thread.sleep(4000);
		
		WebElement umenu = driver.findElement(By.xpath(".//*[@id='userNavLabel']"));
		clickButton(umenu, "sasi n");

		/*Click on the consol  */
		WebElement Devconsole = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[3]"));
		clickButton(Devconsole, "Devloperconsole");
		/* Handling the window  */
		String WinHandleBefore = driver.getWindowHandle();
		driver.switchTo().window(WinHandleBefore);
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		driver.close();
		driver.quit();
	}
	
	
public static void logoutUserTC09() throws Exception{
		
		startReport("logoutUserTC09", "C:/SeleniumDriver/Framework/Report/");
		String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
		
		String url = recdata[1][0];
		String UN = recdata[1][1];
		String pd = recdata[1][2];
		
		//for (int i = 0; i<10;i++)
		launchApplication(url);
		//Thread.sleep(7000);
		
		WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
		WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
		
		/*Enter user name to user name field*/
		enterText(un, UN, "userName");
		
		/*Enter Pwd to password field*/
		enterText(pwd, pd, "password");
				
		/*Click login button*/
		clickButton(login, "Login");
		//loginSalesForce();
		Thread.sleep(4000);
		/*Click on Usermenu */
		WebElement umenu = driver.findElement(By.xpath(".//*[@id='userNavLabel']"));
		clickButton(umenu, "sasi n");
		/* Click on logout*/
		WebElement logout = driver.findElement(By.xpath(".//*[@id='userNav-menuItems']/a[5]"));
		clickButton(logout, "Logout");
		
		driver.quit();
		
}
	
/**
 * Method to create a new account in the application
 * @throws InterruptedException 
 * @throws IOException 
 * */
public static void createAccountTC10() throws InterruptedException, IOException
{
	startReport("createAccountTC10", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*click on the Account Link */
	WebElement AccLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
	clickButton(AccLink, "Account");
	
	/*Click on the new button to create a new account  */
	WebElement account = driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
	clickButton(account, "Create Account");
	
	/*click on the sub menu Account  
	WebElement createacc = driver.findElement(By.xpath(".//*[@id='createNewMenu']/a[4]"));
	clickButton(createacc, "Account");*/

	/* Enter the account name  */
	WebElement accnew = driver.findElement(By.xpath(".//*[@id='acc2']"));
	enterText(accnew, "Rangarajan", "Account Name");
	
	/*Click on the Save button */
	WebElement save = driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"));
	clickButton(save, "Save");
	driver.quit();
}



public static void createNewViewTC11()throws InterruptedException, Exception
{
	startReport("createNewViewTC11", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	Thread.sleep(2000);
	/*click on the Account Link */
	WebElement AccLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
	clickButton(AccLink, "Account");
	 Thread.sleep(2000);
	 
	/*Click on create new view link */
	WebElement view = driver.findElement(By.xpath(".//*[@id='filter_element']/div/span/span[2]/a[2]"));
	clickButton(view, "Create view");
	
	/*Enter the unique view name */
	WebElement Vname = driver.findElement(By.xpath(".//*[@id='fname']"));
	enterText(Vname, "Sasinave", "View name is added");
	
	/* enter  the unique view namen*/
	WebElement unqName = driver.findElement(By.xpath(".//*[@id='devname']"));
	enterText(unqName, "Sasinav1", "Unique nmae");
	
	/*Click on save button */
	WebElement save = driver.findElement(By.xpath(".//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]"));
	clickButton(save, "Save");
	
	
	Thread.sleep(5000);
	driver.quit();
	
}
	
public static void editViewTC12() throws Exception{
	startReport("editViewTC12", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*click on the Account Link */
	WebElement AccLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
	clickButton(AccLink, "Account");
	/*click on the view list  */
	WebElement selectview = driver.findElement(By.xpath(".//*[@id='fcf']"));
	Select dpview = new Select(selectview);
	dpview.selectByVisibleText("Sasinave");
	/*click on the edit view */
	//WebElement edit_link = driver.findElement(By.xpath(".//*[@id='00B460000040IvA_filterLinks']/a[1]")); //.//*[@id='00B460000040IvA_filterLinks']/a[1]
	WebElement edit_link = driver.findElement(By.linkText("Edit"));
	clickButton(edit_link, "edit");
	/*enter the new view name */
	WebElement new_view = driver.findElement(By.xpath(".//*[@id='fname']"));
	clearText(new_view,"fname");
	enterText(new_view, "Sasinaveen", "new view");
	
	/*click on the Fliter criteria */
	/*click on the Account */
	WebElement field = driver.findElement(By.xpath(".//*[@id='fcol1']"));
	Select dpfiled = new Select(field);
	dpfiled.selectByVisibleText("Account Name");
	/*click on the operator */
	WebElement operator = driver.findElement(By.xpath(".//*[@id='fop1']"));
	Select dpop = new Select(operator);
	dpop.selectByVisibleText("contains");
	
	/*click on the Value*/
	WebElement value = driver.findElement(By.xpath(".//*[@id='fval1']"));
	clearText(value,"fval1");
	Thread.sleep(1000);
	enterText(value,"ac", "value");
	
	/*click on the field display */
	WebElement display = driver.findElement(By.xpath(".//*[@id='colselector_select_0']"));
	Select dpdisp = new Select(display);
	//dpdisp.selectByIndex(29);
	dpdisp.selectByVisibleText("Last Activity");
	
	/*click on the add button */
	WebElement addbt = driver.findElement(By.xpath(".//*[@id='colselector_select_0_right']/img"));
	clickButton(addbt, "Add");
	
	/*Click on save button */
	WebElement save = driver.findElement(By.xpath(".//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]"));
	clickButton(save, "Save");
	driver.quit();
	
	
}
	
public static void mergeAccountTC13() throws IOException, InterruptedException{
	
	startReport("mergeAccountTC13", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*click on the Account Link */
	WebElement AccLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
	clickButton(AccLink, "Account");
	
	/*Click on merge link */
	WebElement mergelink = driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
	clickButton(mergelink, "merge");
	
	/*WebElement merge = driver.findElement(By.linkText("Merge Accounts"));
	clickButton(merge, "Merge link");*/
	
	WebElement findAcc = driver.findElement(By.xpath(".//*[@id='srch']"));
	enterText(findAcc, "Rangarajan", "Find Account");
	
	WebElement findbt = driver.findElement(By.xpath(".//*[@id='stageForm']/div/div[2]/div[4]/input[2]"));
	clickButton(findbt, "Find account ");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*Click on the check box  */
	WebElement chkbox = driver.findElement(By.xpath(".//*[@id='cid0']"));
	//clickButton(chkbox, "Check box1");
	selectCheckBox(chkbox, "Account1");
	
	WebElement chkbox1 = driver.findElement(By.xpath(".//*[@id='cid1']"));
	//clickButton(chkbox1, "Check box1");
	selectCheckBox(chkbox1, "Account2");
	/*click on next button */
	WebElement nextbt = driver.findElement(By.xpath(".//*[@id='stageForm']/div/div[2]/div[5]/div/input[1]"));
	clickButton(nextbt, "Next");
	
	/*Click on the merge  */
	WebElement mergebt = driver.findElement(By.xpath(".//*[@id='stageForm']/div/div[2]/div[1]/div/input[2]"));
	clickButton(mergebt, "Merge");
	/*seitching to Alert window  */
	
	Alert alert = driver.switchTo().alert();
	
	String msg = driver.switchTo().alert().getText();
	System.out.println(msg);
	alert.accept();
	driver.quit();
	
}
	
public static void 	createAccountReportTC14() throws IOException, InterruptedException{
	
	startReport("mergeAccountTC13", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*click on the Account Link */
	WebElement AccLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
	clickButton(AccLink, "Account");
	
	/*Click on Report Last 30days */
	WebElement reportactive = driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[1]/div/div/div[1]/ul/li[2]/a"));
	clickButton(reportactive, "activity report");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*Click on Date image */
	WebElement date = driver.findElement(By.xpath(".//*[@id='ext-gen152']"));
	clickButton(date, "Date img");
	
	/*Click on the find date*/
	WebElement date_click = driver.findElement(By.xpath(".//*[@id='ext-comp-1042']"));
	clearText(date_click, "Clear_fromcalender");
	enterText(date_click, "05/04/17", "From Calender");
	
	//WebElement date_click = driver.findElement(By.xpath(".//*[@id='ext-gen252']"));
	//clickButton(date_click, "Today");
	
	/*Click on Date image */
	WebElement date1 = driver.findElement(By.xpath(".//*[@id='ext-gen154']"));
	clickButton(date1, "Date img");
	
	/*Clcik on To date */
	WebElement dateto = driver.findElement(By.xpath(".//*[@id='ext-comp-1045']"));
	clearText(dateto, "clear_tocalender");
	enterText(dateto, "05/05/17", "To Calender");
	clickButton(dateto, "To Date img");
	
	/* Click on To Date*/
	//WebElement date_to = driver.findElement(By.xpath(".//*[@id='ext-gen350']"));
	//clickButton(date_to, "Today");
	
	/*Click on Save button */
	WebElement savebt = driver.findElement(By.xpath(".//*[@id='saveReportBtn']/tbody/tr[2]/td[2]/em"));
	clickButton(savebt, "Save");
	
	/*Enter the Report name */
	WebElement report_name = driver.findElement(By.xpath(".//*[@id='saveReportDlg_reportNameField']"));
	enterText(report_name, "snrajv"," Reportnmae");
	
	/*Enter the unique Report name */
	WebElement reportuq = driver.findElement(By.xpath(".//*[@id='saveReportDlg_DeveloperName']"));
	clearText(reportuq, "Report");
	enterText(reportuq, "snrajv","Unique name");
	
	/*.//*[@id='dlgSaveReport']/tbody/tr[2]/td[2] */
	
	/*Click on Save button */ //.//*[@id='dlgSaveReport']
	//WebElement savebtrepo = driver.findElement(By.xpath(".//*[@id='saveReportBtn']/tbody/tr[2]/td[2]"));
	//clickButton(savebtrepo, "Save");
	//.//*[@id='dlgSaveAndRun']
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*Click on Runreport button */ //.//*[@id='ext-gen313']
	WebElement reportbt = driver.findElement(By.xpath(".//*[@id='dlgSaveReport']"));
	clickButton(reportbt, "Save");
	
	driver.quit();
}
	
public static void userMenuTC15() throws IOException, InterruptedException{
	
	startReport("userMenuTC15", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a/img"));
	clickButton(acc_link, "Link");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*Click on Opperunity */
	WebElement oppLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[4]/td[2]/a"));
	clickButton(oppLink, "Oppertunitylink");
	
	WebElement oppdp = driver.findElement(By.xpath(".//*[@id='fcf']"));
	clickButton(oppdp, "Dropdown list is ");
	Select oselect = new Select(driver.findElement(By.xpath(".//*[@id='fcf']")));
	List<WebElement> elelist = oselect.getOptions();
	int size = elelist.size();
	
	/*for(int i=0;i<size;i++){
		WebElement optionelement = elelist.get(i);
		String value = optionelement.getAttribute("value");
		oselect.selectByValue(value);
		System.out.println("option are "+oselect);
	}*/
	
	
	//Select oppclick = new Select(oppdp);
    //oppclick.getOptions();
	//clickButton(oppdp, "Dropdown");
driver.quit();	

	
}
	
public static void createNewOptyTC16() throws IOException, Exception{
	
	startReport("createNewOptyTC16", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	Thread.sleep(2000);
	
	/*Click on Opperunity */
	WebElement oppLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[4]/td[2]/a"));
	clickButton(oppLink, "Oppertunitylink");
	Thread.sleep(2000);
	
	/*Click on New button  */
	//WebElement newbt = driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
	WebElement newbt = driver.findElement(By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
	clickButton(newbt, "New");
	
	/*enter the Qpp nmae */
	WebElement opp_name = driver.findElement(By.xpath(".//*[@id='opp3']"));
	//clearText(opp_name, "OppName");
	enterText(opp_name, "srini", "OppName");
	
	/*enter the Account nmae */
	WebElement acc_name = driver.findElement(By.xpath(".//*[@id='opp4']"));
	clearText(acc_name, "Account Name");
	enterText(acc_name, "Rangarajan", "OppName");
	
	/*Enter the close date */
	WebElement closedate = driver.findElement(By.xpath(".//*[@id='opp9']"));
	clearText(closedate, "close date");
	enterText(closedate, "5/4/18", "OppName");
	//WebElement cdate = driver.findElement(By.xpath(".//*[@id='calRow1']/td[6]"));
	//clickButton(cdate, "date");
	
	WebElement stage = driver.findElement(By.xpath(".//*[@id='opp11']"));
	Select stagedp = new Select(stage);
	stagedp.selectByValue("Needs Analysis");
	
	/*Click on Save button */
	WebElement savebtn = driver.findElement(By.xpath(".//*[@id='bottomButtonRow']/input[1]"));
	clickButton(savebtn, "save");
	
	driver.close();
	
}
		
public static void opportunitiesReportTC17() throws IOException, InterruptedException{
	startReport("opportunitiesReportTC17", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	
	/*Click on Opperunity */
	WebElement oppLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[4]/td[2]/a"));
	clickButton(oppLink, "Oppertunitylink");
	
	/*click on Oppertunity pipeline link */
	WebElement opppipeline = driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
	clickButton(opppipeline, "Oppertunitypipeline link");
	Thread.sleep(2000);
	driver.quit();
	
}
	
public static void stuck_opportunitiesTC18() throws IOException, InterruptedException{
	startReport("stuck_opportunitiestTC18", "C:/SeleniumDriver/Framework/Report/");
	String[][] recdata = readXL("C:/SeleniumDriver/Testdata.xls", "TC1",false);
	
	String url = recdata[1][0];
	String UN = recdata[1][1];
	String pd = recdata[1][2];
	
	//for (int i = 0; i<10;i++)
	launchApplication(url);
	//Thread.sleep(7000);
	
	WebElement un = driver.findElement(By.xpath("//*[@id='username']"));
	WebElement pwd = driver.findElement(By.xpath("//*[@id='password']"));
	WebElement login = driver.findElement(By.xpath("//*[@id='Login']"));
	
	/*Enter user name to user name field*/
	enterText(un, UN, "userName");
	
	/*Enter Pwd to password field*/
	enterText(pwd, pd, "password");
			
	/*Click login button*/
	clickButton(login, "Login");
	//loginSalesForce();
	
	Thread.sleep(4000);
	/*Click on the AccountLink '+' symbol */
	WebElement acc_link = driver.findElement(By.xpath(".//*[@id='AllTab_Tab']/a"));
	clickButton(acc_link, "Link");
	
	/*Click on Opperunity */
	WebElement oppLink = driver.findElement(By.xpath(".//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[4]/td[2]/a"));
	clickButton(oppLink, "Oppertunitylink");
	
	/*Click on Stuck Oppertunity link */
	Thread.sleep(1000);
	WebElement stuckOpp = driver.findElement(By.xpath(".//*[@id='toolsContent']/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
	clickButton(stuckOpp, "Stuck Oppertunities");
	Thread.sleep(2000);
	
	driver.quit();
	
	System.out.println("Press any key to exit... ");
    // Read the char
    char ch = (char) System.in.read();
    
	
}
	
	
}
