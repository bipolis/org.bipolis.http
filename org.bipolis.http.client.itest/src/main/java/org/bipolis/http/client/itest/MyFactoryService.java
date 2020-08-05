/**
 *
 */
package org.bipolis.http.client.itest;

import java.util.Map;

import org.bipolis.http.client.itest.MyFactoryService.ConfigExSeMe;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(configurationPid = MyFactoryService.CONFIGURATION_PID, service = MyFactoryService.class, immediate = true)
@Designate(factory = true, ocd = ConfigExSeMe.class)
public class MyFactoryService
{
    public static final String CONFIGURATION_PID = "my.factory.configuration.pid";

    @ObjectClassDefinition
    @interface ConfigExSeMe
    {
        String my() default "1";
    }

    private ConfigExSeMe config;

    @Activate
    public void activate(ConfigExSeMe config, Map<String, Object> props)
    {
        this.config = config;
        System.out.println(props);
        System.out.println(config.my());
    }

    String my()
    {
        return config.my();
    }
}