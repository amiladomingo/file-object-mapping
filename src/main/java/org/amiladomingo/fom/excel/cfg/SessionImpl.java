package org.amiladomingo.fom.excel.cfg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SessionImpl implements Session {

	private final Connection connection;

	private final SessionFactory factory;

	public SessionImpl(Connection connection, SessionFactory factory) {
		super();
		this.connection = connection;
		this.factory = factory;
	}

	public void save(PersistentObject object) throws SQLException {
		Configuration configuration = factory.getConfiguration(object
				.getTemplate());

		object.setConfiguration(configuration);

		connection.setAutoCommit(false);

		PreparedStatement statement = connection.prepareStatement(configuration
				.insertStatement());

		while (object.hasNext()) {

			Object[] params = object.next();

			for (int j = 0; j < params.length; j++) {

				statement.setObject(j + 1, params[j]);

			}

			statement.addBatch();
		}

		statement.executeBatch();

		connection.commit();
	}

	public void close() throws SQLException {
		connection.close();
	}
}