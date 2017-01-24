package org.amiladomingo.fom.excel.cfg;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelObject implements PersistentObject {

	private final Workbook workbook;

	private final String template;

	private Configuration configuration;

	public ExcelObject(Workbook workbook, String template) {
		super();
		this.workbook = workbook;
		this.template = template;
	}

	public boolean hasNext() {
		return workbook.getSheetAt(0).rowIterator().hasNext();
	}

	public Object[] next() {

		if (configuration == null) {
			throw new RuntimeException();
		}

		Row row = workbook.getSheetAt(0).rowIterator().next();

		List<Column> columns = configuration.columns();
		
		for (Column column : columns) {
			
			int index = column.getIndex();
			
			Cell cell = row.getCell(index);
			
			String dataType = column.getDataType();
		}
		
		return null;
	}

	public void remove() {
		throw new RuntimeException();
	}

	public String getTemplate() {
		return template;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public String getInsertStatement() {
		return null;
	}

}
