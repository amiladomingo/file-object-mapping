/**
 * 
 */
package org.amiladomingo.frm.excel;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import junit.framework.Assert;

import org.amiladomingo.frm.excel.ExcelTemplate;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Amila Domingo
 * 
 */
public class ExcelTemplateTest {

	private ExcelTemplate excelTemplate;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		excelTemplate = new ExcelTemplate();
	}

	/**
	 * Test method for
	 * {@link org.amiladomingo.frm.excel.ExcelTemplate#fromExcel2007(byte[], java.lang.Class)}
	 * .
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws NoSuchFieldException
	 * @throws IOException
	 * @throws SecurityException
	 */
	@Test
	public void testFromExcel2007() throws SecurityException, IOException, NoSuchFieldException, InstantiationException,
			IllegalAccessException {
		URL resource = this.getClass().getResource("students.xlsx");

		List<Student> students = excelTemplate.fromExcel2007(new File(resource.getFile()), Student.class);

		Assert.assertEquals(3, students.size());
	}
}
