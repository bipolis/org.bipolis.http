package org.bipolis.http.client.itest;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(service = MyService.class, configurationPid = MyService.CONFIGURATION_PID, configurationPolicy = ConfigurationPolicy.REQUIRE, immediate = true)
public class MyService
{
    public static final String CONFIGURATION_PID = "my.configuration.pid";
    @interface ConfigExSe
    {
        String my() default "1";
    }

    private ConfigExSe config;

    @Activate
    private void activate(ConfigExSe config, Map<String, Object> props)
    {
        this.config = config;
        System.out.println(props);
        System.err.println(config.my());
    }

    public String my()
    {
        return config.my();
    }

}