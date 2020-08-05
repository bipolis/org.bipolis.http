package org.bipolis.http.client.auth;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.bipolis.http.client.auth.BasicAuthenticator.BasicAuthenticatorConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Designate(ocd = BasicAuthenticatorConfig.class, factory = true)
@Component(service = Authenticator.class)
public class BasicAuthenticator extends Authenticator
{

    @ObjectClassDefinition
    static @interface BasicAuthenticatorConfig
    {
        boolean serverBasicAuthEnable() default false;

        String serverBasicAuthUsername();

        char[] serverBasicAuthPassword();

        boolean proxyBasicAuthEnable() default false;

        String proxyBasicAuthUsername();

        char[] proxyBasicAuthPassword();
    }

    @Activate
    private BasicAuthenticatorConfig config;

    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        System.out.println("scheme: " + getRequestingScheme());

        switch (getRequestorType())
        {
            case PROXY:
                if (config.proxyBasicAuthEnable())
                {
                    return new PasswordAuthentication(config.proxyBasicAuthUsername(),
                        config.proxyBasicAuthPassword());
                }
                break;
            case SERVER:
                if (config.serverBasicAuthEnable())
                {
                    return new PasswordAuthentication(config.serverBasicAuthUsername(),
                        config.serverBasicAuthPassword());
                }
                break;
            default:
                break;
        }
        return null;
    }
}