package functionalTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {


	static String HomeDir = System.getProperty("user.dir");
	static XSSFWorkbook excelWorkbookInput = null;

	static XSSFSheet excelSheetInput = null;
	static XSSFRow row = null;
	static XSSFCell cell = null;
	static String InputFilePath = HomeDir + "/files/Input_Data.xlsx";
	static String LoginSheetName = "LoginCredentials";
	static String LoanApplicationSheetName = "LoanApplication";
	static String SignUpSheetName = "SignUp";
	static String ResetPinSheetName = "ResetPIN";

	@DataProvider(name = "LoginCredentials")
	// supplying data for a login test method.
	public static Object[][] LoginCredentials() throws IOException {
		FileInputStream fis = new FileInputStream(InputFilePath);

		excelWorkbookInput = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		excelSheetInput = excelWorkbookInput.getSheet(LoginSheetName); // Your
																		// sheet
																		// name

		// Find number of rows in excel file
		System.out.println("First Row Number/index:"
				+ excelSheetInput.getFirstRowNum()
				+ " *** Last Row Number/index:"
				+ excelSheetInput.getLastRowNum());
		int rowCount = excelSheetInput.getLastRowNum()
				- excelSheetInput.getFirstRowNum() + 1;
		int colCount = excelSheetInput.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount
				+ " *** Column count is: " + colCount);
		System.out.println("The following login details will be used:");
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) {
			for (int cNum = 0; cNum < colCount; cNum++) {
				System.out.print(getCellData(LoginSheetName, cNum, rNum) + " ");
				data[rNum - 2][cNum] = getCellData(LoginSheetName, cNum, rNum);

			}
			System.out.println();
		}
		return data;
	}
	
	@DataProvider(name = "LoanApplication")
	// supplying data for a loan application test method.
	public static Object[][] LoginApplication() throws IOException {
		FileInputStream fis = new FileInputStream(InputFilePath);

		excelWorkbookInput = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		excelSheetInput = excelWorkbookInput.getSheet(LoanApplicationSheetName); 
		
		// Find number of rows in excel file
		System.out.println("First Row Number/index:"
				+ excelSheetInput.getFirstRowNum()
				+ " *** Last Row Number/index:"
				+ excelSheetInput.getLastRowNum());
		int rowCount = excelSheetInput.getLastRowNum()
				- excelSheetInput.getFirstRowNum() + 1;
		int colCount = excelSheetInput.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount
				+ " *** Column count is: " + colCount);
		System.out.println("The following loan application details will be used:");
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) {
			for (int cNum = 0; cNum < colCount; cNum++) {
				System.out.print(getCellData(LoanApplicationSheetName, cNum, rNum) + " ");
				data[rNum - 2][cNum] = getCellData(LoanApplicationSheetName, cNum, rNum);

			}
			System.out.println();
		}
		return data;
	}
	
	
	@DataProvider(name = "SignUp")
	// supplying data for a loan application test method.
	public static Object[][] SignUp() throws IOException {
		FileInputStream fis = new FileInputStream(InputFilePath);

		excelWorkbookInput = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		excelSheetInput = excelWorkbookInput.getSheet(SignUpSheetName); 
		
		// Find number of rows in excel file
		System.out.println("First Row Number/index:"
				+ excelSheetInput.getFirstRowNum()
				+ " *** Last Row Number/index:"
				+ excelSheetInput.getLastRowNum());
		int rowCount = excelSheetInput.getLastRowNum()
				- excelSheetInput.getFirstRowNum() + 1;
		int colCount = excelSheetInput.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount
				+ " *** Column count is: " + colCount);
		System.out.println("The following sign up details will be used:");
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) {
			for (int cNum = 0; cNum < colCount; cNum++) {
				System.out.print(getCellData(SignUpSheetName, cNum, rNum) + " ");
				data[rNum - 2][cNum] = getCellData(SignUpSheetName, cNum, rNum);

			}
			System.out.println();
		}
		return data;
	}
	
	@DataProvider(name = "ResetPIN")
	// supplying data for a Forgot PIN test method.
	public static Object[][] ResetPIN() throws IOException {
		FileInputStream fis = new FileInputStream(InputFilePath);

		excelWorkbookInput = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		excelSheetInput = excelWorkbookInput.getSheet(ResetPinSheetName); 
		
		// Find number of rows in excel file
		System.out.println("First Row Number/index:"
				+ excelSheetInput.getFirstRowNum()
				+ " *** Last Row Number/index:"
				+ excelSheetInput.getLastRowNum());
		int rowCount = excelSheetInput.getLastRowNum()
				- excelSheetInput.getFirstRowNum() + 1;
		int colCount = excelSheetInput.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount
				+ " *** Column count is: " + colCount);
		System.out.println("The following sign up details will be used:");
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) {
			for (int cNum = 0; cNum < colCount; cNum++) {
				System.out.print(getCellData(ResetPinSheetName, cNum, rNum) + " ");
				data[rNum - 2][cNum] = getCellData(ResetPinSheetName, cNum, rNum);

			}
			System.out.println();
		}
		return data;
	}

	// Function will always used as below. It returns the data from a cell - No
	// need to make any changes
	public static String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";
			int index = excelWorkbookInput.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			excelSheetInput = excelWorkbookInput.getSheetAt(index);
			row = excelSheetInput.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum
					+ " does not exist in xls";
		}

	}

}
