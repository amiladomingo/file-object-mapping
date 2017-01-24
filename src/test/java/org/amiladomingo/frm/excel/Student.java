package org.amiladomingo.frm.excel;

import java.util.Date;

import org.amiladomingo.frm.excel.annotation.Column;
import org.amiladomingo.frm.excel.annotation.Mapped;

@Mapped
public class Student {

	@Column(order = 1)
	private int id;

	@Column(order = 0)
	private String name;

	@Column(order = 2)
	private Date createdDate;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
}
