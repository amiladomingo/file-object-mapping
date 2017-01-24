package org.amiladomingo.fom.excel.cfg;

import java.sql.SQLException;

public interface Session {

	public void save(final PersistentObject object) throws SQLException;

	public void close() throws SQLException;
}
