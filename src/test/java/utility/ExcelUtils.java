package utility;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import automationFramework.TestCases;

public class ExcelUtils {

	public static XSSFWorkbook ExcelWBook;

	public static XSSFSheet ExcelWSheet;

	public static XSSFCell Cell;

	public static XSSFRow Row;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	/**
	 * 
	 * @param Path
	 * @param SheetName
	 * @throws Exception
	 */
	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {

			// Open the Excel file
			TestCases.log.info("Reading file from path" + Path);
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	/**
	 * 
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * @throws Exception
	 */
	public static String getCellDataasString(int RowNum, int ColNum) throws Exception {

		try {
			String CellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
			System.out.println("The value of CellData " + CellData);
			return CellData;
		} catch (Exception e) {
			return "Errors in Getting Cell Data";
		}

	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters
	/**
	 * 
	 * @param Result
	 * @param RowNum
	 * @param ColNum
	 * @throws Exception
	 */
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {
			System.out.println("row " + RowNum + " cell " + ColNum);
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);
				System.out.println(Cell);
			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelWBook.write(fileOut);
			Row.getCell(ColNum);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	/**
	 * @author dkeshav
	 * @param sheetName
	 * @param colName
	 * @return col_num of matching Column Name
	 */
	public static int getCellNum(String sheetName, String colName) {
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		Row = ExcelWSheet.getRow(0);
		int col_num = -1;
		for (int i = 0; i < Row.getLastCellNum(); i++) {
			if (Row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_num = i;
			}
		}
		return col_num;
	}

}