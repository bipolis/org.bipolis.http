package org.bipolis.http.client;

import java.net.http.HttpClient.Builder;

import org.osgi.service.component.annotations.Component;

@Component(service = Builder.class, property = "osgi.http.client.name=.default")
public class DefaultOsgiHttpClientBuilder extends AbstractHttpClientBuilder {

}
