/**
 * 
 */
package org.amiladomingo.frm.excel;

import org.amiladomingo.frm.excel.annotation.Column;

/**
 * @author Amila Domingo
 * 
 */
public class ExcelMappedColumn {

	private String name;

	private int order;

	public ExcelMappedColumn(Column column, String string) {
		name = string;
		order = column.order();
	}

	public int getOrder() {
		return order;
	}

	public String getName() {
		return name;
	}
}
