package com.h33kz.APIConnectionDemo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class RequestHandler {
    private HttpRequest request;
    private HttpClient client;
    private HttpResponse<String> response;

    public RequestHandler() {
        client = HttpClient.newHttpClient();
    }

    public void createRequest(String baseURI, String filterString) throws Exception {
        filterString = filterString.replace(' ', '+');
        String uriString = baseURI + filterString;
        System.out.println(uriString);
        request = HttpRequest.newBuilder().uri(new URI(uriString)).GET().build();
    }

    public HttpResponse<String> sendRequest() throws Exception {
        response = client.send(request, BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("Connection to API was succesful\n\n");
        } else {
            System.out.println("Error while trying to connect with API\n\n");
        }
        return response;
    }
}
