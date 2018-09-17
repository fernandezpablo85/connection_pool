package org.example.services;

import java.io.IOException;

public class HttpBin implements RemotePing
{
    private static final String URL = "http://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
    private final Http client;

    public HttpBin(int poolsize)
    {
        this.client = new NoPool(poolsize);
    }

    @Override
    public boolean pingRemote()
    {
        try
        {
            return this.client.getStatus(URL) == 200;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
