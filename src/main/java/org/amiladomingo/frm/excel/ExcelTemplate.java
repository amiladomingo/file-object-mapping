/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.amiladomingo.frm.excel;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.amiladomingo.frm.excel.annotation.AnnotationParser;
import org.amiladomingo.frm.excel.annotation.ExcelAnnotationParser;

/**
 * Contains the excel related operations
 * 
 * @author Amila Domingo
 * @since 1.0
 */
public class ExcelTemplate {

	final private Map<ExcelMapperType, ExcelMapper> excelMappers;

	final private AnnotationParser parser;

	final private Map<Object, ExcelMappedClass> cache;

	/**
	 * Mapper types
	 */
	enum ExcelMapperType {
		EXCEL_2007, EXCEL_2003;
	}

	public ExcelTemplate() {
		cache = new ConcurrentHashMap<Object, ExcelMappedClass>();

		parser = new ExcelAnnotationParser();

		excelMappers = new ConcurrentHashMap<ExcelMapperType, ExcelMapper>();

		excelMappers.put(ExcelMapperType.EXCEL_2003, new Excel2003Mapper());
		excelMappers.put(ExcelMapperType.EXCEL_2007, new Excel2007Mapper());
	}

	/**
	 * 
	 * @param file
	 * @param clazz
	 * @return
	 * @throws IOException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public <T> List<T> fromExcel2007(final File file, Class<T> clazz)
			throws IOException, SecurityException, NoSuchFieldException,
			InstantiationException, IllegalAccessException {

		ExcelMappedClass excelMappedClass = findExcelMappedClass(clazz);

		ExcelMapper mapper = excelMappers.get(ExcelMapperType.EXCEL_2007);

		return mapper.toBeans(file, excelMappedClass, clazz);
	}

	private ExcelMappedClass findExcelMappedClass(Class<?> clazz) {
		// First, see if we have a cached value.
		Object cacheKey = getCacheKey(clazz);
		ExcelMappedClass excelMappedClass = this.cache.get(cacheKey);

		if (excelMappedClass == null) {
			excelMappedClass = computeExcelAttribute(clazz);
			// Put it in the cache.
			this.cache.put(cacheKey, excelMappedClass);
		}

		return excelMappedClass;

	}

	private ExcelMappedClass computeExcelAttribute(Class<?> targetClass) {
		return parser.parseExcelAnnotation(targetClass);
	}

	protected Object getCacheKey(Class<?> targetClass) {
		return new DefaultCacheKey(targetClass);
	}

	/**
	 * Default cache key.
	 */
	@SuppressWarnings("rawtypes")
	private static class DefaultCacheKey {

		private final Class targetClass;

		public DefaultCacheKey(Class targetClass) {
			this.targetClass = targetClass;
		}

		@Override
		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof DefaultCacheKey)) {
				return false;
			}
			DefaultCacheKey otherKey = (DefaultCacheKey) other;
			return this.targetClass.getCanonicalName().equals(
					otherKey.targetClass.getCanonicalName());
		}

		@Override
		public int hashCode() {
			return this.targetClass != null ? this.targetClass.hashCode() : 0;
		}
	}
}
