package org.amiladomingo.fom.excel.cfg;

import java.sql.SQLException;

public interface SessionFactory {

	public Session openSession() throws SQLException;
	
	public Configuration getConfiguration(String template);
	
	public void addResource(String resource);
}
