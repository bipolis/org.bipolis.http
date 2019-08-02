package org.bipolis.http.client;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.Locale.Category;

import org.bipolis.http.client.OsgiHttpClientBuilder.HttpClientConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

// TODO: Auto-generated Javadoc
/**
 * The Class OsgiHttpClientBuilder.
 */
@Designate(factory = true, ocd = HttpClientConfig.class)
@Component(service = Builder.class)
public class OsgiHttpClientBuilder extends AbstractHttpClientBuilder {

	/**
	 * The Interface HttpClientConfig.
	 */
	@ObjectClassDefinition
	public static @interface HttpClientConfig {

		/**
		 * Basic auth enable.
		 *
		 * @return true, if successful
		 */
		boolean basicAuth_enable() default false;

		/**
		 * Basic auth password.
		 *
		 * @return the string
		 */
		String basicAuth_password() default "";

		/**
		 * Basic auth user.
		 *
		 * @return the string
		 */
		String basicAuth_user();

		/**
		 * C.
		 *
		 * @return the category
		 */
		Category c() default Category.DISPLAY;

		/**
		 * Follow redirects.
		 *
		 * @return the redirect
		 */
		Redirect followRedirects() default Redirect.NORMAL;

		/**
		 * Proxy basic auth enable.
		 *
		 * @return true, if successful
		 */
		boolean proxy_basicAuth_enable() default false;

		/**
		 * Proxy enable.
		 *
		 * @return true, if successful
		 */
		boolean proxy_enable() default false;

		/**
		 * Proxy password.
		 *
		 * @return the string
		 */
		String proxy_password();

		/**
		 * Proxy port.
		 *
		 * @return the int
		 */
		int proxy_port();

		/**
		 * Proxy server.
		 *
		 * @return the string
		 */
		String proxy_server();

		/**
		 * Proxy user.
		 *
		 * @return the string
		 */
		String proxy_user();

		/**
		 * Timeout ms.
		 *
		 * @return the long
		 */
		long timeoutMs() default -1;

		/**
		 * Version.
		 *
		 * @return the version
		 */
		Version version() default Version.HTTP_2;
	}

	/**
	 * Activate.
	 *
	 * @param cfg the cfg
	 */
	@Activate
	private void activate(HttpClientConfig cfg) {

		if (cfg.basicAuth_enable()) {

			final Authenticator authenticator = CustomAuthenticator.authenticator(cfg.basicAuth_enable(),
					cfg.basicAuth_user(), cfg.basicAuth_password(), cfg.proxy_basicAuth_enable(),
					cfg.proxy_user(), cfg.proxy_password());
			builder.authenticator(authenticator);
			builder.followRedirects(Redirect.NORMAL);

		}

		if (cfg.proxy_enable()) {

			final ProxySelector proxySelector = ProxySelector
					.of(new InetSocketAddress(cfg.proxy_server(), cfg.proxy_port()));

			builder.proxy(proxySelector);
		}

		if (cfg.timeoutMs() > 0) {
			builder.connectTimeout(Duration.ofMillis(cfg.timeoutMs()));
		}

		if (cfg.followRedirects() != null) {

			builder.followRedirects(cfg.followRedirects());
		}

		if (cfg.followRedirects() != null) {

			builder.version(cfg.version());
		}
	}

	/**
	 * De activate.
	 */
	@Deactivate
	private void deActivate() {

	}

}
