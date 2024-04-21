package com.report.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.report.model.Candidate;

public class Helper {
	
	public static String[] HEADERS= {
			"id",
			"email",
			"password",
			"fullName"
	};
	
	public static String SHEET_NAME = "candidate_data";
	
	public static ByteArrayInputStream dataToExcel(List<Candidate> candidates) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			
			Sheet sheet = workbook.createSheet(SHEET_NAME);
			//create Row Header Row
			Row row = sheet.createRow(0);
			for (int i = 0; i < HEADERS.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}
			//Values Row
			int rowIndex = 1;
			for (Candidate c : candidates) {
				Row dataRow = sheet.createRow(rowIndex);
				rowIndex++;
				dataRow.createCell(0).setCellValue(c.getId());
				dataRow.createCell(0).setCellValue(c.getEmail());
				dataRow.createCell(0).setCellValue(c.getPassword());
				dataRow.createCell(0).setCellValue(c.getFullName());
				workbook.write(outputStream);
			}
			return new ByteArrayInputStream(outputStream.toByteArray());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Data Import Failed");
			return null;
		}
		finally {
				workbook.close();
				outputStream.close();
		}
		
	}
	
}
