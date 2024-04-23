package com.cursosalura.convertidormonedas.calculation;


import com.cursosalura.convertidormonedas.models.ExchangeRateInput;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestData {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public ExchangeRateInput requestDataFromExchange(String currentCurrency) {
        ExchangeRateInput currencyData = null;

        try {

            URI url = URI.create( "https://v6.exchangerate-api.com/v6/5c50d776b9ab394a7c25f3b9/latest/"+currentCurrency);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();


            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
             String json = response.body();

             currencyData = gson.fromJson(json, ExchangeRateInput.class);



        } catch (IllegalArgumentException e) {
            System.out.println("Error en la url, verifique la dirección");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


        return  currencyData;

    }

}
