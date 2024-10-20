package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
   @DataProvider(name ="LoginData")
	public String[][] getData() throws IOException
   {
		String path = ".\\testData\\Book1.xlsx";
		ExcelUtility xutil = new ExcelUtility(path);
		int totalrows = xutil.getrowcount("Sheet1");
		int totalcell = xutil.getcellcount("Sheet1", 1);
		
		String logindata[][] = new String[totalrows][totalcell];
		for(int i=1;i<=totalrows;i++) 
		{
			
			for(int j=0;j<totalcell;j++) {
				
				logindata[i-1][j] = xutil.getcelldata("Sheet1",i, j);
			}
		}
	return logindata;
		
	}
	
	
	
	
	
	
	
}
