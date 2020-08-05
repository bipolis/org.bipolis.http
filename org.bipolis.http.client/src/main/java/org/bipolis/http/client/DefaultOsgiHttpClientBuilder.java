package org.bipolis.http.client;

import java.net.CookieStore;
import java.net.http.HttpClient.Builder;
import java.util.Optional;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(service = Builder.class, property = "osgi.http.client.name=.default", immediate = true)
public class DefaultOsgiHttpClientBuilder extends AbstractHttpClientBuilder
{
    Optional<CookieStore> ocs = Optional.empty();

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    void setCookie(CookieStore store)
    {
        ocs = Optional.of(store);
    }

    @Activate
    void test()
    {
        System.out.println(ocs.isPresent());
    }
}
