/**
 * 
 */
package org.amiladomingo.fom.excel.annotation;

import java.lang.reflect.Field;

import org.amiladomingo.fom.excel.ExcelMappedClass;
import org.amiladomingo.fom.excel.ExcelMappedColumn;
import org.amiladomingo.fom.excel.MappingNotFoundException;

/**
 * @author Amila Domingo
 * 
 */
public class ExcelAnnotationParser implements AnnotationParser {

	public ExcelMappedClass parseExcelAnnotation(Class<?> ae) {
		Mapped mapped = ae.getAnnotation(Mapped.class);
		if (mapped != null) {

			ExcelMappedClass attribute = new ExcelMappedClass();

			for (Field field : ae.getDeclaredFields()) {
				Column column = field.getAnnotation(Column.class);
				if (column != null) {
					attribute.addColumn(new ExcelMappedColumn(column, field
							.getName()));
				}
			}

			return attribute;

		} else {
			throw new MappingNotFoundException();
		}
	}

}
