package com.practice.java;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ReadWriteExcelFile {

	public void writeXLSFile() throws IOException {
		String fileName = "D:\\temp.xls";
		String sheetName = "sheet1";

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);

		for (int r = 0; r < 5; r++) {
			HSSFRow row = sheet.createRow(r);
			for (int c = 0; c < 5; c++) {
				HSSFCell cell = row.createCell(c);
				cell.setCellValue("Cell " + r + " " + c);
			}
		}

		FileOutputStream fo = new FileOutputStream(fileName);

		wb.write(fo);
		fo.flush();
		fo.close();
		wb.close(); 
	}

	public void readXLSFile() throws IOException {

		InputStream excelFileToRead = new FileInputStream("D:\\temp.xls");

		HSSFWorkbook wb = new HSSFWorkbook(excelFileToRead);
		HSSFSheet sheet = wb.getSheetAt(0);
		
		HSSFRow row;
		HSSFCell cell;

		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext()) {
			row = (HSSFRow) rows.next();

			Iterator<Cell> cells = row.cellIterator();
			while (cells.hasNext()) {
				cell = (HSSFCell) cells.next();

				if (cell.getCellTypeEnum() == CellType.STRING) {
					System.out.print(cell.getStringCellValue() + " ");
				} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
					System.out.print(cell.getNumericCellValue());
				} else {
					System.out.println("None.");
				}
			}
			System.out.println();
		}
		wb.close();
	}

	public static void main(String[] args) throws IOException {

		ReadWriteExcelFile rwe = new ReadWriteExcelFile();
		rwe.writeXLSFile();
		rwe.readXLSFile();

	}
}
