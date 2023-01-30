package org.example;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class assignment_1 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        callAPI();
    }
    public static void callAPI() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder("https://api.chucknorris.io/jokes/categories");
        builder.setParameter("contentType", "json");
        HttpGet getData = new HttpGet(builder.build());
        CloseableHttpClient httpClient = HttpClients.createDefault(); //creating httpclient
        CloseableHttpResponse responce = httpClient.execute(getData);
        HttpEntity responceEntity = responce.getEntity();
        String result = EntityUtils.toString(responceEntity);
        System.out.println(result);
        httpClient.close();
    }
}
