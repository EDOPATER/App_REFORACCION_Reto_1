package com.edopater.app_reforaccion_reto_1.modelos;

import android.app.Application;
import android.util.Log;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Usuario extends Application {

    public String   nombre;
    public String   apellidos;
    public String   imageProfile;
    public String   correo;
    public String   contrasena;
    public String   repetirContrasena;
    public Object   recyclings;

    // Constructor sin argumentos
public Usuario() {}

public Usuario(String nombre, String apellidos, String correo, String contrasena, String confirmPassword) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.correo = correo;
    this.contrasena = contrasena;
    this.repetirContrasena = confirmPassword;
    }

public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getApellidos() {
        return apellidos;
    }
public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

public String getCorreo() {
    return correo;
}
public void setCorreo(String correo) {
    this.correo = correo;
}

public String getContrasena() {
    return contrasena;
}
public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
}

public String getConfirmContrasena() {
        return repetirContrasena;
    }
public void setConfirmContrasena(String confirmPassword) { this.repetirContrasena = confirmPassword; }

    public String objectToJSON (){

        String jsonData = new Gson().toJson(this);
        Log.e("msg", "User to json: " + jsonData);

        return jsonData;
    }

    public void setDefaultData(){
        this.nombre           = "";
        this.apellidos        = "";
        this.imageProfile   = "";
        this.correo          = "";
        this.contrasena       = "";
        this.repetirContrasena = "";
        this.recyclings     = new ArrayList<Recycling>();
    }

    public void copyData(Usuario newData){
        this.nombre           = newData.nombre;
        this.apellidos        = newData.apellidos;
        this.imageProfile   = newData.imageProfile;
        this.correo          = newData.correo;
        this.contrasena       = newData.contrasena;
        this.repetirContrasena = newData.repetirContrasena;
        this.recyclings     = newData.recyclings;
    }

}
