package org.amiladomingo.frm.excel;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ExcelMapper {

	<T> List<T> toBeans(File file, ExcelMappedClass excelMappedClass,
			Class<T> clazz) throws IOException, SecurityException,
			NoSuchFieldException, InstantiationException,
			IllegalAccessException;

}
