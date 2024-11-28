package handlingexelsheets;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelDemo1 {

	public static void main(String[] args)throws Throwable {
		
		String input = ".\\exels\\Sample1.xlsx";
		//read path of excel file
//				FileInputStream fi = new FileInputStream(input);
//				//get work book
//				XSSFWorkbook wb = new XSSFWorkbook(fi);
//				//get sheet from work book
//				XSSFSheet ws =wb.getSheet("Emp");
//				//get first row from Emp sheet
//				XSSFRow row =ws.getRow(0);
//				//count no of rows in Emp sheet
//				int rc =ws.getLastRowNum();
//				System.out.println("No of rows are::"+rc);
//				//count no of cells in first row
//				int cc =row.getLastCellNum();
//				System.out.println("No of cells are::"+cc);
//				fi.close();
//				wb.close();
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		Row row3 = sheet.getRow(1);
		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);

	}

}
