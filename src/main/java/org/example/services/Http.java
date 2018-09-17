package org.example.services;

import java.io.IOException;

abstract public class Http
{
    protected final int poolsize;

    public Http(int poolsize)
    {
        this.poolsize = poolsize;
    }

    public abstract int getStatus(String url) throws Exception;
}
