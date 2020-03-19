import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public static void main(String[] args) throws IOException {
		// Print Array Data
		try {
			String fileName="c:\\Users\\nitinp\\Downloads\\ExcelDataDriven.xlsx";
			String sheetName="TestCaseSheet1";
			String testcaseName="Sony";			
			ExcelDataDriven obj = new ExcelDataDriven();
			ArrayList<String> returned_arraylist = new ArrayList<String>();
			returned_arraylist = obj.getExcelData(fileName, sheetName, testcaseName);
			Iterator<String> it = returned_arraylist.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		//263534582
	}

	public ArrayList<String> getExcelData(String FileName, String SheetName, String TestCaseName) throws IOException {
		// Creating a workbook object
		InputStream is = new FileInputStream(FileName);
		XSSFWorkbook workbook = new XSSFWorkbook(is);

		// Getting Exact Test Case Sheet
		XSSFSheet tc_sheet = null;
		int sheets_count = workbook.getNumberOfSheets();
		// System.out.println(sheets_count);
		for (int i = 0; i < sheets_count; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(SheetName)) {
				tc_sheet = workbook.getSheetAt(i);
			}
		}

		// Reading the title of each column from first row
		XSSFRow rows = tc_sheet.getRow(0);
		Iterator<Cell> first_row_it = rows.cellIterator();
		int c = 0;
		String cellData = null;
		while (first_row_it.hasNext()) {
			cellData = first_row_it.next().getStringCellValue();
			if (cellData.equalsIgnoreCase("TestCases")) {
				break;
			}
			c++;
		}

		// Get cell data from test cases column
		String desired_testcase_name = null;
		int row_count = tc_sheet.getLastRowNum();
		Iterator<Cell> scanned_row_it = null;
		ArrayList<String> cellDataList = new ArrayList<String>();
		
		// Here searching the test case name in test case column which was found above
		for (int i = 0; i <= row_count; i++) {
			rows = tc_sheet.getRow(i);
			scanned_row_it = rows.cellIterator();
			for (int j = 0; j < c; j++) {
				scanned_row_it.next();
			}
			desired_testcase_name = scanned_row_it.next().getStringCellValue();
			if (desired_testcase_name.equalsIgnoreCase(TestCaseName)) {
				// Here we are reading the each cell from current row who contain the desired test case
				Iterator<Cell> print_cell_it = rows.cellIterator();
				while (print_cell_it.hasNext()) {
					// System.out.println(print_cell_it.next().getStringCellValue());
					cellDataList.add(print_cell_it.next().getStringCellValue());
				}
				break;
			}			
		}
		workbook.close();
		return cellDataList;
	}

}
