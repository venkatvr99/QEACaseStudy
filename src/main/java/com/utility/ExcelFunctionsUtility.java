package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctionsUtility {

	Object[][] obj = null;

	public Object[][] readDataFromExcel() {

		File file = new File("./src/test/resources/UserLoginDetails.xlsx");
		try {
			InputStream stream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(stream);
			XSSFSheet sheet = workbook.getSheet("RegistrationDetails");
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
			for (int i = 1; i < rowCount; i++) {
				obj = new Object[rowCount][columnCount];
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j <= columnCount; j++) {
					System.out.println(row.getCell(j).getStringCellValue());

					obj[i - 1][j] = row.getCell(j).getStringCellValue();
				}
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

}
