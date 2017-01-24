/**
 * 
 */
package org.amiladomingo.fom.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amila Domingo
 * 
 */
public class ExcelMappedClass {

	private List<ExcelMappedColumn> columns = new ArrayList<ExcelMappedColumn>();

	public void addColumn(ExcelMappedColumn excelMappedColumn) {
		getColumns().add(excelMappedColumn);
	}

	public List<ExcelMappedColumn> getColumns() {
		return columns;
	}
}
