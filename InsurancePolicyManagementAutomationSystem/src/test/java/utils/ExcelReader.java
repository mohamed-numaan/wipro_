package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public Object[][] getSheetData(String sheetName) {
        Object[][] data = null;
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new RuntimeException(" Excel file not found at: " + file.getAbsolutePath());
            }

            try (FileInputStream fis = new FileInputStream(file);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file!");
                }

                int rowCount = sheet.getPhysicalNumberOfRows();
                int colCount = sheet.getRow(0).getLastCellNum();

                data = new Object[rowCount - 1][colCount];

                for (int i = 1; i < rowCount; i++) {
                    Row row = sheet.getRow(i);
                    for (int j = 0; j < colCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell == null) {
                            data[i - 1][j] = "";
                        } else if (cell.getCellType() == CellType.STRING) {
                            data[i - 1][j] = cell.getStringCellValue();
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                        } else if (cell.getCellType() == CellType.BOOLEAN) {
                            data[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                        } else {
                            data[i - 1][j] = "";
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
