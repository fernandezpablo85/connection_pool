package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProxyConfig extends Configuration
{
    @NotNull @Min(1)
    private int poolSize;

    @JsonProperty
    public int getPoolSize()
    {
        return poolSize;
    }

    @JsonProperty
    public void setPoolSize(int poolSize)
    {
        this.poolSize = poolSize;
    }
}
