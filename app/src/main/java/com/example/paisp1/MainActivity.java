// MainActivity.java
package com.example.paisp1;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<>();
        WebService ws = new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos, this, this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Log.d("RESPUESTA_API",result);
        ArrayList<lugarTuristico> listaLugaresTuristicos = new ArrayList<>();

        JSONObject lista = new JSONObject(result);
        Log.d("PARTE_ESPECIFICA", lista.toString());
        JSONObject results = lista.getJSONObject("Results");

        for (Iterator<String> keys = results.keys(); keys.hasNext();) {
            String key = keys.next();
            JSONObject country = results.getJSONObject(key);

            String countryName = country.getString("Name");
            JSONObject capital = country.getJSONObject("Capital");
            String capitalName = capital.getString("Name");
            String flagURL = "http://www.geognos.com/api/en/countries/flag/" + country.getJSONObject("CountryCodes").getString("iso2");

            lugarTuristico lugar = new lugarTuristico(countryName, capitalName, flagURL);
            listaLugaresTuristicos.add(lugar);
        }

        AdaptadorLugaresTuristico adaptadorLugares = new AdaptadorLugaresTuristico(this, listaLugaresTuristicos);

        ListView lstOpciones = findViewById(R.id.Lugar);
        lstOpciones.setAdapter(adaptadorLugares);
    }
}
