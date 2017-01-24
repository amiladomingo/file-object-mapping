package org.amiladomingo.fom.excel.annotation;

import org.amiladomingo.fom.excel.ExcelMappedClass;

public interface AnnotationParser {

	public ExcelMappedClass parseExcelAnnotation(Class<?> ae);
}
