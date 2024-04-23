package com.cursosalura.convertidormonedas.calculation;

import com.cursosalura.convertidormonedas.models.UserInput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteRequests {
    public void saveJson(ArrayList<UserInput> data) throws IOException {

        Gson gson  = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("currencyData.json");
        escritura.write(gson.toJson(data));
        escritura.close();
    }
}
