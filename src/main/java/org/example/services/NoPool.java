package org.example.services;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharStreams;
import org.eclipse.jetty.util.IO;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class NoPool extends Http
{
    public NoPool(int poolsize)
    {
        super(poolsize);
    }

    @Override
    public synchronized int getStatus(String url) throws Exception
    {
        URI uri = new URI(url);
        System.out.println(uri.getHost());
        Socket s = new Socket(uri.getHost(), 80);
        assert s.isConnected();
        System.out.println("socket connected");
        s.getOutputStream().write(getHttpRequest(uri));
        System.out.println("response written");
        String response = CharStreams.toString(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
        System.out.println("response read");
        System.out.println(response);
        s.close();
        System.out.println("socket closed");
        return 200;
    }

    private byte[] getHttpRequest(URI uri)
    {
        String path = uri.getPath();
        String host = uri.getHost();
        String request = "GET " + path + " HTTP/1.1\n"
                + "Host: " + host + "\n"
                + "User-Agent: homemade/1.0.0\n"
                + "Connection: close\n"
                + "Accept: */*\n\n";

        return request.getBytes(StandardCharsets.UTF_8);
    }
}
