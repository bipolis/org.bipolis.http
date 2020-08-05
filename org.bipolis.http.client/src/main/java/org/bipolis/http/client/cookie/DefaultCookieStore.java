package org.bipolis.http.client.cookie;

import java.net.CookieStore;

import org.osgi.service.component.annotations.Component;

@Component(service = CookieStore.class, immediate = true)
public class DefaultCookieStore extends AbstractCookieStore
{

}