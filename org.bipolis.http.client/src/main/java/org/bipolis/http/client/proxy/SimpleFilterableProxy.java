/**
 *
 */
package org.bipolis.http.client.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;

import org.bipolis.http.client.proxy.SimpleFilterableProxy.SimpleFilterableProxyConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Designate(factory = true, ocd = SimpleFilterableProxyConfig.class)
@Component(service = UriProxyProvider.class)
public class SimpleFilterableProxy implements UriProxyProvider
{
    URI uri;
    private SimpleFilterableProxyConfig proxySelectorConfig;
    private Proxy proxy;

    @ObjectClassDefinition(description = "Configuration of a Proxy")
    @interface SimpleFilterableProxyConfig
    {
        @AttributeDefinition(description = "type of proxy")
        Type proxyType();

        @AttributeDefinition(description = "hostname of the proxy")
        String proxyHostname();

        @AttributeDefinition(description = "proxy port")
        int proxyPort();

        @AttributeDefinition(description = "Filter (regex) of the scheme")
        String filterUriScheme() default "*";

        @AttributeDefinition(description = "Filter (regex) of the host")
        String filterUriHost() default "*";

        @AttributeDefinition(description = "Filter (regex) of the port")
        String filterUriPort() default "*";

        int setrvice_ranking();
    }

    @Activate()
    private void activate(SimpleFilterableProxyConfig simpleFilterableProxyConfig)
    {
        changeProxy(proxySelectorConfig);
    }

    @Modified()
    private void modified(SimpleFilterableProxyConfig simpleFilterableProxyConfig)
    {
        changeProxy(proxySelectorConfig);
    }

    private void changeProxy(SimpleFilterableProxyConfig simpleFilterableProxyConfig)
    {

        proxy = new Proxy(simpleFilterableProxyConfig.proxyType(),
            new InetSocketAddress(simpleFilterableProxyConfig.proxyHostname(),
                simpleFilterableProxyConfig.proxyPort()));

    }

    @Override
    public boolean matches(URI uri)
    {
        if (uri.getHost().matches(proxySelectorConfig.filterUriHost()))
        {
            if (Integer.valueOf(uri.getPort()).toString().matches(
                proxySelectorConfig.filterUriPort()))
            {
                if (uri.getScheme().matches(proxySelectorConfig.filterUriScheme()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Proxy getProxy()
    {
        return proxy;
    }
}
