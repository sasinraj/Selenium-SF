

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* 15 SFDC test cases to be automated and Run as testSuit
 * 
 * 
 */

public class DriverScript {
	static int reportFlag = 0;
	public static void main(String[] args) throws IOException, InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String testDataPath = "C:/SeleniumDriver/TestSuit.xls";
		String[][] recData = ReUsableMethods.readXL(testDataPath, "Sheet1",true);
	
		for(int i = 1; i< recData.length; i++){
			reportFlag = 0;
			if(recData[i][1].equalsIgnoreCase("Y")){
				String scriptName = recData[i][2];
				ReUsableMethods.startReport(scriptName, "C:/SeleniumDriver/Framework/Report/");
				/*Java Reflection or Reflexive API*/
				Method tc = AutomationScripts.class.getMethod(scriptName);
				tc.invoke(tc);
				ReUsableMethods.bw.close();
				
				if(reportFlag == 0){
					ReUsableMethods.writeXl(testDataPath, "Sheet1", i, 3, "Pass");
				}else{
					ReUsableMethods.writeXl(testDataPath, "Sheet1", i, 3, "Fail");
				}
			}else{
				ReUsableMethods.writeXl(testDataPath, "Sheet1", i, 3, "Not Executed");
			}
			
		}
		
	
		
		
		
		
		/*Method testCase = AutomationScripts.class.getMethod(TestCaseName, null);
		testCase.invoke(testCase, args); */

	}

}
