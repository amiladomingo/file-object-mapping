package org.amiladomingo.fom.excel.cfg;

import java.util.Iterator;

public interface PersistentObject extends Iterator<Object[]> {

	public String getTemplate();

	public void setConfiguration(Configuration configuration);

	public String getInsertStatement();

}
