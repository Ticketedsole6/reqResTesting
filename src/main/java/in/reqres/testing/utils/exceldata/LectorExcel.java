package in.reqres.testing.utils.exceldata;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LectorExcel {
    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        System.out.println("Reading data from the sheet: " + sheetName + " in file: " + excelFilePath);
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        if (sheet == null) {
            throw new RuntimeException("The sheet " + sheetName + " not found in the file: " + excelFilePath);
        }
        return readSheet(sheet);
    }

    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
            throws InvalidFormatException, IOException {
        System.out.println("Reading data from the sheet: " + sheetNumber + " in file: " + excelFilePath);
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        if (sheet == null) {
            throw new RuntimeException("The sheet " + sheetNumber + " not found in the file " + excelFilePath);
        }
        return readSheet(sheet);
    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Workbook workbook = getWorkBook(excelFilePath);
        if (workbook == null) {
            throw new RuntimeException("The workbook could not be initialized for the file: " + excelFilePath);
        }
        return workbook.getSheet(sheetName);
    }

    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Workbook workbook = getWorkBook(excelFilePath);
        if (workbook == null) {
            throw new RuntimeException("The workbook could not be initialized for the file: " + excelFilePath);
        }
        return workbook.getSheetAt(sheetNumber);
    }

    private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
        File file = new File(excelFilePath);
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException("The specified Excel file does not exist or is a directory: " + excelFilePath);
        }
        System.out.println("Initializing workbook for file: " + excelFilePath);
        return WorkbookFactory.create(file);
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList<>();

        int headerRowNumber = getHeaderRowNumber(sheet);
        System.out.println("Header row number: " + headerRowNumber);

        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
                row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapdata);
            }
        } else {
            System.out.println("No header row found on the sheet");
        }
        return excelRows;
    }

    private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() != CellType.BLANK || cell.getCellType() != CellType.FORMULA
                            || cell.getCellType() != CellType._NONE) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
        Cell cell;

        if (row == null) {
            if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType() != CellType.BLANK) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            Cell indexCell = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(),
                    Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

            if (indexCell.getCellType() != CellType.BLANK) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                        .getStringCellValue();
                if (cell.getCellType() == CellType.STRING) {
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                } else if (cell.getCellType() == CellType.BLANK) {
                    columnMapdata.put(columnHeaderName, "");
                } else if (cell.getCellType() == CellType.BOOLEAN) {
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                } else if (cell.getCellType() == CellType.ERROR) {
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }
}
