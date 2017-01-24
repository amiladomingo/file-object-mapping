package org.amiladomingo.fom.excel;

import java.util.Date;

import org.amiladomingo.fom.excel.annotation.Column;
import org.amiladomingo.fom.excel.annotation.Mapped;

@Mapped
public class Student {

	@Column(order = 1)
	private int id;

	@Column(order = 0)
	private String name;

	@Column(order = 2)
	private Date birthDate;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}
}
