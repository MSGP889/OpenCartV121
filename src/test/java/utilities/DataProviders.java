package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\myexcelforloginPage.xlsx";// taking Xl file from testData
		
		ExcelUtilities xlutil= new ExcelUtilities(path); // creating Object for XUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		System.out.println(totalrows);
		System.out.println(totalcols);
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store
		
		for(int i=1;i<4;i++)
		{
			for(int j=0;j<3;j++)//0 i is rows j is cols
			{
				logindata[i][j]=xlutil.getCellData("Sheet1",i,j); //1,1
			}
		}
		return logindata;// returning two dimension array
	}
}
