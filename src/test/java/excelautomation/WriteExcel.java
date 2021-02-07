package excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
	/*
	Create a new class: WriteExcel
Create a new method: writeExcel()
Store the path of the file as string and open the file
Open the workbook
Open the first worksheet
Go to the first row
Create a cell on the 3rd index on the first row
Write “POPULATION” on that cell
Create a cell on the 2nd row 4th cell(index3), and write 150000
Create a cell on the 3rd row 4th cell(index3), and write 250000
Create a cell on the 4th row 4th cell(index3), and write 54000
Write and save the workbook
Close the file
Close the workbook
	 */
	@Test
	public void writeExcel() throws IOException {
		String path = "./src/test/java/resources/Capitals.xlsx";
		FileInputStream fileInputStream = new FileInputStream(path);

		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheetAt(0);

		// 1 Way
		Row row = sheet.getRow(0);
		Cell cell4 = row.createCell(3);
		cell4.setCellValue("POPULATION");

		//2 Way
		sheet.getRow(1).createCell(3).setCellValue("150");
		sheet.getRow(2).createCell(3).setCellValue("250");
		sheet.getRow(3).createCell(3).setCellValue("54");
		sheet.getRow(8).createCell(3).setCellValue("18");

	// Write
		FileOutputStream fileOutputStream = new FileOutputStream(path);
		workbook.write(fileOutputStream);

		//closing the workbook
		fileInputStream.close();
		fileOutputStream.close();
		workbook.close();
	}
}
