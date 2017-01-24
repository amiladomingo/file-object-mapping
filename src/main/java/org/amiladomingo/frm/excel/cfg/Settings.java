package org.amiladomingo.frm.excel.cfg;

public class Settings {

	private final String url;

	private final String username;

	private final String password;

	public Settings(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

}
