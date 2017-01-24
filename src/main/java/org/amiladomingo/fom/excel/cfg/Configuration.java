package org.amiladomingo.fom.excel.cfg;

import java.util.List;

public class Configuration {

	public String insertStatement() {
		return "INSERT INTO DBUSER"
				+ "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES"
				+ "(?,?,?,?)";
	}

	public List<Column> columns() {
		return null;
		
	}
}
