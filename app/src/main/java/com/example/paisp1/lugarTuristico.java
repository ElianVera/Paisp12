// lugarTuristico.java
package com.example.paisp1;

import org.json.JSONException;
import org.json.JSONObject;

public class lugarTuristico {
    private String nombre;
    private String capital;
    private String urlLogo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public lugarTuristico(String nombre, String capital, String urlLogo) {
        this.nombre = nombre;
        this.capital = capital;
        this.urlLogo = urlLogo;
    }

    public lugarTuristico(JSONObject jsonObject) throws JSONException {
        nombre = jsonObject.getString("Name");
        capital = jsonObject.getJSONObject("Capital").getString("Name");
        urlLogo = "http://www.geognos.com/api/en/countries/flag/" +
                jsonObject.getJSONObject("CountryCodes").getString("iso2");
    }
}
