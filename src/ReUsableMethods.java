//package salesforce;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ReUsableMethods {
	
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	public static WebDriver driver;
	public static void launchApplication(String URL){
		driver = new FirefoxDriver();
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.quit();
	}
	
	/* Name of the method: Enter Text
	 * Brief Description: Enter text to text field
	 * Arguments:  obj --> Object webelement, textName --> text value to be entered
	 * objName --> Object name
	 * Creation Date: Sept 30 2016
	 * Last Modified: Sept 30 2016
	 * Created by: Apple Automation Team 
	 * */
	public static void enterText(WebElement obj, String textName, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.sendKeys(textName);
			Update_Report("Pass", "enterText", textName+ " is entered in " + objName + " field.");
			//System.out.println("Pass: " + );
		}else{
			Update_Report("Fail", "enterText", objName + " field is not displyed please check the application.");
//			System.out.println("Fail: "  + objName + " field is not displyed please check the application.");
		}
	}
	
	/* Name of the method: clickButton
	 * Brief Description: Clcik on object or button
	 * Arguments:  obj --> Object webelement, objName --> Object name
	 * Creation Date: Sept 30 2016
	 * Last Modified: Sept 30 2016
	 * Created by: Infosys Automation Team 
	 * */
	public static void clickButton(WebElement obj, String objName) throws IOException{
		if(obj.isDisplayed()){
			obj.click();
			Update_Report("Pass", "clickButton", objName+ " is clicked .");
			System.out.println("Pass: " + objName+ " is clicked .");
		}else{
			Update_Report("Fail", "clickButton", objName + " field is not displyed please check the application.");
			System.out.println("Fail: "  + objName + " field is not displyed please check the application.");
		}
		
		
	}
	

	/*Name of the method:Enter text
	 * Brief Description:Enter text to text field
	 * Arguments: obj --->Object webelement , textName-->text value to be entered
	 * objName-->Object name 
	 * Creation Date:October 08 2016 
	 * Last Modified:October 08 2016
	 * Created by :Apple Automation Team (name of the company)
	 * */

	public static void clearText(WebElement obj, String str){

		if(obj.isDisplayed())
		{
			obj.clear();
			System.out.println("Pass:"+objName + " " +" is cleared in"+ objName+"field");

		}
		else
		{
			System.out.println("Fail: "+ objName+"field not is displayed please check the application.");
		}

	}
	
	/*
	 * 
	 * */
	
	public static void selectCheckBox(WebElement obj,String objName ){
		
		if(obj.isDisplayed()){
			if(obj.isSelected()){
				System.out.println("Pass: Check box "+ objName + " is already selected.");
			}else{
				obj.click();
				System.out.println("Pass: Check box " + objName+ " is selected.");
			}
		}else{
			System.out.println("Fail: Check box " + objName + " is not displayed.");
		}
		
	}
	
	/*
	 * 
	 * */
	public static void deselectCheckBox(WebElement obj,String objName){
		if(obj.isDisplayed()){
			if(obj.isSelected()){
				obj.click();
				System.out.println("Pass: Check box "+ objName + " is  de-selected.");
			}else{
				System.out.println("Pass: Check box " + objName+ " is alredy de-selected.");
			}
		}else{
			System.out.println("Fail: Check box " + objName + " is not displayed.");
		}
	}

	public static void webLink(WebElement obj, String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("Pass : Link"+ objName+"is clicked");
		}
		else
		{
			System.out.println("Fail : Link"+ objName+"is clicked");
		}
	}
	
	/* Method Name : clickSelect
	 * Brief Desc: select the item from the drop down box 
	 * Arguments: testDataPath --> Test Data path, sheetName --> Name of the Sheet
	 * Created By: Automation team
	 * Creation Date: Oct 5th 2016
	 * Last Modified: Oct 5th 2016
	 * */
	
	public static void clickSelect(){
		
		
	}
	
	/* Method Name : readSheet
	 * Brief Desc: Read XL content
	 * Arguments: testDataPath --> Test Data path, sheetName --> Name of the Sheet
	 * Created By: Automation team
	 * Creation Date: Oct 5th 2016
	 * Last Modified: Oct 5th 2016
	 * */
	public static String[][] readXL(String testDataPath, String sheetName, boolean slno_flag) throws IOException{
		

		/*Step 1: Get the XL Path*/
		File xlFile = new File(testDataPath);

		/*step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);


		/*Step3: Access the work book (POI jar file) */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();

		//System.out.println("Rows = " + iRowCount);
		//System.out.println("Col = " + iColCount);

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i = 1; i < iRowCount; i++){
			for(int j = (slno_flag==true)?1:0; j < iColCount; j++){
				xlData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				//xlData[i][j] = sheet.getRow(i).getCell(j).getNumericCellValue();
								System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
			}

			//			System.out.println();
		}
		//System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
		
		return xlData;
	}

	
	public static void writeXl(String testDataPath, String sheetName, int iRow, int iCol, String XlData) throws IOException{
		/*Step 1: Get the XL Path*/
		File xlFile = new File(testDataPath);

		/*step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);
		

		/*Step3: Access the work book (POI jar file) */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);
		
		/*Access Row*/
		HSSFRow row = sheet.getRow(iRow);
		
		/*Access cell*/
		HSSFCell cell = row.getCell(iCol);
		
		//cell.setCellValue(XlData);
		
		if(XlData=="Pass"){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.LIGHT_GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
			cell.setCellValue("Pass");
		}else if(XlData=="Fail"){
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
			cell.setCellValue("Fail");
		}
		
		
		
		xlDoc.close();
		FileOutputStream fout = new FileOutputStream(xlFile);
		wb.write(fout);
		fout.flush();
		fout.close();
	}
	
	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
	
}
