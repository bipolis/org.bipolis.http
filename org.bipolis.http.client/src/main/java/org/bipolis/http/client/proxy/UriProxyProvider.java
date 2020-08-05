package org.bipolis.http.client.proxy;

import java.net.Proxy;
import java.net.URI;

public interface UriProxyProvider
{
    boolean matches(URI uri);

    Proxy getProxy();
}
