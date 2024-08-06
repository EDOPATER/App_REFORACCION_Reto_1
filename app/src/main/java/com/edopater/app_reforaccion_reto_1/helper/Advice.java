package com.edopater.app_reforaccion_reto_1.helper;

import android.util.Log;
import com.google.gson.Gson;

public class Advice {

    // Campos de la clase
    public String title;         // Título del Consejo
    public String description;   // Descripción del Consejo
    public String image;         // Imagen a mostrar
    public String url;           // Video almacenado en la carpeta raw
    public boolean isLink;       // Por ejemplo, un video de YouTube

    // Constructor por defecto
    public Advice() {
        this.title = "";
        this.description = "";
        this.image = "";
        this.url = "";
        this.isLink = false;
    }

    // Constructor con parámetros
    public Advice(String title, String description, String image, String url, boolean isLink) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.url = url;
        this.isLink = isLink;
    }

    // Método para convertir el objeto a JSON
    public String objectToJSON() {
        String jsonData = new Gson().toJson(this);
        Log.e("msg", "User to json: " + jsonData);
        return jsonData;
    }
}
