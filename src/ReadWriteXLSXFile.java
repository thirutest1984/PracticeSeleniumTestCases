import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteXLSXFile {
	
	public void writeXLSX() throws IOException {
		String fileName = "D:\\tempexcel.xlsx";
		String sheetName = "sheet1";
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName);
		
		for(int r=0;r<5;r++) {
			XSSFRow rows = sheet.createRow(r);
			for(int c=0;c<5;c++) {
				XSSFCell cell = rows.createCell(c);
				cell.setCellValue(r+","+c);
			}
		}
		
		FileOutputStream fos = new FileOutputStream(fileName);
		wb.write(fos);
		fos.flush();
		fos.close();	
		wb.close();
	}
	
	public void readXLSX() throws Exception {
		
		InputStream xlsToRead = new FileInputStream("D:\\tempexcel.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(xlsToRead);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		XSSFRow row;
		XSSFCell cell;
		
		Iterator<Row> rows = sheet.iterator();
		while(rows.hasNext()) {
			row = (XSSFRow) rows.next();
			
			Iterator<Cell> cells = row.iterator();
			while(cells.hasNext()) {
				cell = (XSSFCell) cells.next();
				
				if(cell.getCellTypeEnum() == CellType.STRING) {
					System.out.print(cell.getStringCellValue()+" ");
				}
			}
			System.out.println();
		}
		wb.close();
		
	}

	public static void main(String[] args) throws Exception {

		ReadWriteXLSXFile rwx = new ReadWriteXLSXFile();
		rwx.writeXLSX();
		rwx.readXLSX();
	}

}
