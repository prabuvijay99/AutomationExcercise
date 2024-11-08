package Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="UserData")
	public String[][] sendData() throws IOException {
		
		String Path="./testData/Register_user.xlsx";
		
		ReadData rd= new ReadData(Path);
		int rowCount = rd.getRowCount("Sheet1");
		int columnCount = rd.getColumnCount("Sheet1", 1);
		
		String[][] data=new String[rowCount][columnCount];
		for(int r=1;r<=rowCount;r++) {
			for(int c=0;c<columnCount;c++)
			{
				data[r-1][c]=rd.getCellData("Sheet1", r, c);
				
			}
		}
			
		return data;
		
	}

	
}
