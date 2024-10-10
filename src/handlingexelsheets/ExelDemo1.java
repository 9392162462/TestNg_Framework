package handlingexelsheets;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelDemo1 {

	public static void main(String[] args)throws Throwable {
		
		String input = ".\\exels\\Sample1.xlsx";
		//read path of excel file
				FileInputStream fi = new FileInputStream(input);
				//get work book
				XSSFWorkbook wb = new XSSFWorkbook(fi);
				//get sheet from work book
				XSSFSheet ws =wb.getSheet("Emp");
				//get first row from Emp sheet
				XSSFRow row =ws.getRow(0);
				//count no of rows in Emp sheet
				int rc =ws.getLastRowNum();
				System.out.println("No of rows are::"+rc);
				//count no of cells in first row
				int cc =row.getLastCellNum();
				System.out.println("No of cells are::"+cc);
				fi.close();
				wb.close();

	}

}
