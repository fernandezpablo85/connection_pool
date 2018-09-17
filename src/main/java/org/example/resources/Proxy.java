package org.example.resources;

import org.example.api.Result;
import org.example.services.HttpBin;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/proxy")
@Produces(MediaType.APPLICATION_JSON)
public class Proxy
{
    private final HttpBin service;

    public Proxy(int poolsize)
    {
        this.service = new HttpBin(poolsize);
    }

    @GET
    public Result getResult()
    {
        boolean result = this.service.pingRemote();
        String msg = result ? "OK": "NOT_OK";
        return new Result(msg);
    }
}
