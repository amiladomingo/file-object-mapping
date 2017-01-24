package org.amiladomingo.fom.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2007Mapper implements ExcelMapper {

	public <T> List<T> toBeans(File file, ExcelMappedClass excelMappedClass,
			Class<T> clazz) throws IOException, SecurityException,
			NoSuchFieldException, InstantiationException,
			IllegalAccessException {
		List<T> items = new ArrayList<T>();

		InputStream inputStream;
		XSSFWorkbook workbook;
		XSSFSheet sheet;

		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.rowIterator();

		while (rows.hasNext()) {
			XSSFRow row = ((XSSFRow) rows.next());

			T obj = clazz.newInstance();

			for (ExcelMappedColumn column : excelMappedClass.getColumns()) {
				Field field = obj.getClass().getDeclaredField(column.getName());

				XSSFCell cell = row.getCell(column.getOrder());

				field.setAccessible(true);

				Object value = getValue(cell, field.getType());

				field.set(obj, value);

				field.setAccessible(false);

			}

			items.add(obj);
		}

		return items;
	}

	private Object getValue(XSSFCell cell, Class<?> type) {
		if (type == Date.class) {
			return cell.getDateCellValue();
		} else if (type == int.class) {
			return (int) cell.getNumericCellValue();
		} else {
			return cell.getStringCellValue();
		}
	}

}
