package org.amiladomingo.frm.excel.annotation;

import org.amiladomingo.frm.excel.ExcelMappedClass;

public interface AnnotationParser {

	public ExcelMappedClass parseExcelAnnotation(Class<?> ae);
}
