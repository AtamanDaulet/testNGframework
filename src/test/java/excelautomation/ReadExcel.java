package excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
	@Test
	public void readExcel() throws Exception {
		String path ="./src/test/java/resources/Capitals.xlsx";
		FileInputStream fileInputStream =new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fileInputStream);

		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);

		System.out.println(cell);      //COUNTRY

		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(0);

		System.out.println(cell1);     //USA

		String cell2 = sheet.getRow(1).getCell(1).toString();
		System.out.println(cell2);     //DC

		int lastRowNumber = sheet.getLastRowNum(); // last row number ; like size  //8. index start from 0.
		System.out.println("Row number "+ ++lastRowNumber);   //9 rows

		int physicalNumOfRow = sheet.getPhysicalNumberOfRows();  // index start from 1.
		System.out.println(physicalNumOfRow);

		Map<String,String> worldCapital = new HashMap<>();

		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			worldCapital.put(sheet.getRow(i).getCell(0).toString(), sheet.getRow(i).getCell(1).toString());
		}
		System.out.println(worldCapital);

		//closing the workbook
		fileInputStream.close();
		workbook.close();


	}
}
