package org.amiladomingo.fom.excel.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SessionFactoryImpl implements SessionFactory {

	private final Map<String, Configuration> configuration = new HashMap<String, Configuration>();

	private final Settings settings;

	public SessionFactoryImpl(Settings settings) {
		super();
		this.settings = settings;
	}

	public Session openSession() throws SQLException {
		return new SessionImpl(getConnection(), this);
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(settings.getUrl(),
				settings.getUsername(), settings.getPassword());
	}

	public Configuration getConfiguration(String template) {
		return configuration.get(template);
	}

	public Settings getSettings() {
		return settings;
	}

	public void addResource(String resource) {

	}

}
