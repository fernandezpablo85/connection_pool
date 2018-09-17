package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.resources.Proxy;

public class ProxyApp extends Application<ProxyConfig>
{
    public static void main(final String[] args) throws Exception
    {
        new ProxyApp().run(args);
    }

    @Override
    public String getName()
    {
        return "pool";
    }

    @Override
    public void initialize(final Bootstrap<ProxyConfig> bootstrap)
    {
        // TODO: application initialization
    }

    @Override
    public void run(final ProxyConfig config, final Environment env)
    {
        final Proxy p = new Proxy(config.getPoolSize());
        env.jersey().register(p);
    }

}
