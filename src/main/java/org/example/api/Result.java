package org.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result
{
    private String ok;

    public Result()
    {
        this.ok = "yes";
    }

    public Result(String result)
    {
        this.ok = result;
    }

    @JsonProperty
    public String getOk()
    {
        return ok;
    }
}
