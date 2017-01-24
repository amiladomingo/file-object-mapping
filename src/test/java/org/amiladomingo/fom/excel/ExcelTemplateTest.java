package org.amiladomingo.fom.excel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import junit.framework.Assert;

import org.amiladomingo.fom.excel.ExcelTemplate;
import org.junit.Before;
import org.junit.Test;

public class ExcelTemplateTest {

	private ExcelTemplate excelTemplate;

	@Before
	public void setUp() throws Exception {
		excelTemplate = new ExcelTemplate();
	}

	@Test
	public void testFromExcel2007() throws SecurityException, IOException, NoSuchFieldException, InstantiationException,
			IllegalAccessException {
		URL resource = this.getClass().getResource("students.xlsx");

		List<Student> students = excelTemplate.fromExcel2007(new File(resource.getFile()), Student.class);

		Assert.assertEquals(3, students.size());
	}
}
