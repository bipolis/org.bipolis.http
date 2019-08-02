package org.bipolis.http.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomAuthenticator.
 */
public class CustomAuthenticator extends Authenticator {

	/**
	 * Authenticator.
	 *
	 * @param serverBasicAuthEnabled  the server basic auth enabled
	 * @param serverBasicAuthUsername the server basic auth username
	 * @param serverBasicAuthPassword the server basic auth password
	 * @param proxyBasicAuthEnabled   the proxy basic auth enabled
	 * @param proxyBasicAuthUsername  the proxy basic auth username
	 * @param proxyBasicAuthPassword  the proxy basic auth password
	 * @return the authenticator
	 */
	public static Authenticator authenticator(boolean serverBasicAuthEnabled,
			String serverBasicAuthUsername, char[] serverBasicAuthPassword, boolean proxyBasicAuthEnabled,
			String proxyBasicAuthUsername, char[] proxyBasicAuthPassword) {
		return new CustomAuthenticator(true, serverBasicAuthUsername, serverBasicAuthPassword,
				proxyBasicAuthEnabled, proxyBasicAuthUsername, proxyBasicAuthPassword);
	}

	/**
	 * Authenticator.
	 *
	 * @param serverBasicAuthEnabled  the server basic auth enabled
	 * @param serverBasicAuthUsername the server basic auth username
	 * @param serverBasicAuthPassword the server basic auth password
	 * @param proxyBasicAuthEnabled   the proxy basic auth enabled
	 * @param proxyBasicAuthUsername  the proxy basic auth username
	 * @param proxyBasicAuthPassword  the proxy basic auth password
	 * @return the authenticator
	 */
	public static Authenticator authenticator(boolean serverBasicAuthEnabled,
			String serverBasicAuthUsername, String serverBasicAuthPassword, boolean proxyBasicAuthEnabled,
			String proxyBasicAuthUsername, String proxyBasicAuthPassword) {
		return new CustomAuthenticator(true, serverBasicAuthUsername,
				serverBasicAuthPassword == null ? null : serverBasicAuthPassword.toCharArray(),
				proxyBasicAuthEnabled, proxyBasicAuthUsername,
				proxyBasicAuthPassword == null ? null : proxyBasicAuthPassword.toCharArray());
	}

	/**
	 * Authenticator.
	 *
	 * @param serverBasicAuthUsername the server basic auth username
	 * @param serverBasicAuthPassword the server basic auth password
	 * @param proxyBasicAuthUsername  the proxy basic auth username
	 * @param proxyBasicAuthPassword  the proxy basic auth password
	 * @return the authenticator
	 */
	public static Authenticator authenticator(String serverBasicAuthUsername,
			char[] serverBasicAuthPassword, String proxyBasicAuthUsername,
			char[] proxyBasicAuthPassword) {
		return authenticator(true, serverBasicAuthUsername, serverBasicAuthPassword, true,
				proxyBasicAuthUsername, proxyBasicAuthPassword);
	}

	/**
	 * Proxy authenticator.
	 *
	 * @param proxyBasicAuthUsername the proxy basic auth username
	 * @param proxyBasicAuthPassword the proxy basic auth password
	 * @return the authenticator
	 */
	public static Authenticator proxyAuthenticator(String proxyBasicAuthUsername,
			char[] proxyBasicAuthPassword) {
		return authenticator(false, null, null, true, proxyBasicAuthUsername, proxyBasicAuthPassword);
	}

	/**
	 * Server authenticator.
	 *
	 * @param serverBasicAuthUsername the server basic auth username
	 * @param serverBasicAuthPassword the server basic auth password
	 * @return the authenticator
	 */
	public static Authenticator serverAuthenticator(String serverBasicAuthUsername,
			char[] serverBasicAuthPassword) {
		return authenticator(true, serverBasicAuthUsername, serverBasicAuthPassword, false, null, null);
	}

	/** The server basic auth enable. */
	private boolean serverBasicAuthEnable = false;

	/** The server basic auth username. */
	private String serverBasicAuthUsername = null;

	/** The server basic auth password. */
	private char[] serverBasicAuthPassword = null;

	/** The proxy basic auth enable. */
	private boolean proxyBasicAuthEnable = false;

	/** The proxy basic auth username. */
	private String proxyBasicAuthUsername = null;

	/** The proxy basic auth password. */
	private char[] proxyBasicAuthPassword = null;

	/**
	 * Instantiates a new custom authenticator.
	 */
	private CustomAuthenticator() {

		super();
	}

	/**
	 * Instantiates a new default authenticator.
	 *
	 * @param serverBasicAuthEnable   the server basic auth enable
	 * @param serverBasicAuthUsername the server basic auth username
	 * @param serverBasicAuthPassword the server basic auth password
	 * @param proxyBasicAuthEnable    the proxy basic auth enable
	 * @param proxyBasicAuthUsername  the proxy basic auth username
	 * @param proxyBasicAuthPassword  the proxy basic auth password
	 */
	private CustomAuthenticator(boolean serverBasicAuthEnable, String serverBasicAuthUsername,
			char[] serverBasicAuthPassword, boolean proxyBasicAuthEnable, String proxyBasicAuthUsername,
			char[] proxyBasicAuthPassword) {
		this();
		this.serverBasicAuthEnable = serverBasicAuthEnable;
		this.serverBasicAuthUsername = serverBasicAuthUsername;
		this.serverBasicAuthPassword = serverBasicAuthPassword;
		this.proxyBasicAuthEnable = proxyBasicAuthEnable;
		this.proxyBasicAuthUsername = proxyBasicAuthUsername;
		this.proxyBasicAuthPassword = proxyBasicAuthPassword;
	}

	/**
	 * Gets the password authentication.
	 *
	 * @return the password authentication
	 */
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		System.out.println("scheme: " + getRequestingScheme());

		switch (getRequestorType()) {
			case PROXY:
				if (proxyBasicAuthEnable) {
					return new PasswordAuthentication(proxyBasicAuthUsername, proxyBasicAuthPassword);
				}
				break;
			case SERVER:
				if (serverBasicAuthEnable) {
					return new PasswordAuthentication(serverBasicAuthUsername, serverBasicAuthPassword);
				}
				break;
			default:
				break;

		}
		return null;

	}
}