package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	public  XSSFWorkbook wb;
	File f;
	public ExcelDataProvider(){
		try {
			f=new File("/Users/my_appie_pie/Documents/Selenium/data/excelData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			System.out.println("Error details: "+e.getMessage());
		}		
	}
	
	public  String getSheetData(int sheetIndex, int row, int column) {
		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public  String getData(String sheetName, int row, int column) {
		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
		
}
