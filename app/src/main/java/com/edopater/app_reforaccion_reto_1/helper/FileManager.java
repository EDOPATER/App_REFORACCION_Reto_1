package com.edopater.app_reforaccion_reto_1.helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.edopater.app_reforaccion_reto_1.modelos.Usuario;
import com.edopater.app_reforaccion_reto_1.helper.Advice;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private Context context;
    public File userFile; // Almacenar la información de los usuarios
    public File advicesFile; // Almacenar los consejos

    public FileManager(Context context) {
        this.context = context;
        userFile = loadFileOrCreate("db_user");
        advicesFile = loadFileOrCreate("db_advices");
    }

    private File loadFileOrCreate(String fileName) {
        File file = new File(context.getFilesDir(), fileName + ".txt");
        if (file.exists()) {
            Log.e("msg", "El archivo " + file.getName() + " ya existe en: " + file.getAbsolutePath());
        } else {
            try {
                file.createNewFile();
                Log.e("msg", "El archivo " + file.getName() + " fue creado exitosamente en: " + file.getAbsolutePath());
            } catch (IOException e) {
                Log.e("msg", "Error al crear el archivo " + file.getName(), e);
            }
        }
        return file;
    }

    public boolean insertNewUser(Usuario user) {
        if (userFile == null) {
            Toast.makeText(context, "Archivo de usuarios no disponible", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            // Si el email no existe en el archivo, entonces lo insertamos en db_user
            if (!validateIfUserExist(user)) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true));
                writer.write(user.objectToJSON());
                writer.newLine();
                writer.close();
                Toast.makeText(context, "Registro exitoso", Toast.LENGTH_LONG).show();
                Log.e("msg", "Se ha insertado el nuevo usuario en " + userFile.getName() + " exitosamente");
                return true;
            } else {
                Toast.makeText(context, "El usuario " + user.correo + " ya está registrado", Toast.LENGTH_LONG).show();
            }
        } catch (IOException e) {
            Toast.makeText(context, "Error al escribir en el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public boolean validateIfUserExist(Usuario user) {
        if (userFile == null) {
            Toast.makeText(context, "Archivo de usuarios no disponible", Toast.LENGTH_LONG).show();
            return false;
        }

        if (user.correo == null) {
            Toast.makeText(context, "Correo del usuario no puede ser null", Toast.LENGTH_LONG).show();
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String data;
            while ((data = reader.readLine()) != null) {
                // Convertimos el dato leído en un objeto de tipo User
                Usuario dbUser = new Gson().fromJson(data, Usuario.class);
                // Verificamos si el correo es null antes de llamar equals
                // Si el email ya existe retornamos true
                if (dbUser.correo != null && dbUser.correo.equals(user.correo)) {
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            Toast.makeText(context, "Error al leer el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        // Si llega hasta acá es porque el email no existe en la base de datos
        return false;
    }

    public Usuario findUserByEmailAndPassword(Usuario user) {
        if (userFile == null) {
            Toast.makeText(context, "Archivo de usuarios no disponible", Toast.LENGTH_LONG).show();
            return null;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String data;
            while ((data = reader.readLine()) != null) {
                // Convertimos el dato leído en un objeto de tipo User
                Usuario dbUser = new Gson().fromJson(data, Usuario.class);
                Log.e("msg", "Email: " + dbUser.correo + ", Password: " + dbUser.contrasena);
                Log.e("msg", "Email: " + user.correo + ", Password: " + user.contrasena);
                // Si las credenciales coinciden con los registros en la base de datos retornamos true
                if (dbUser.correo.equals(user.correo) && dbUser.contrasena.equals(user.contrasena)) {
                    Log.e("msg", "Email: " + user.correo + ", Password: " + user.contrasena + " <- Correct!");
                    return dbUser;
                }
            }
            reader.close();
        } catch (IOException e) {
            Toast.makeText(context, "Error al leer el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        // Si llega hasta acá es porque los datos del usuario no coinciden con los registros de la base de datos
        return null;
    }

    public void insertNewRecycling(Usuario user) {
        if (userFile == null) {
            Toast.makeText(context, "Archivo de usuarios no disponible", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            ArrayList<String> newFileData = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String data;
            while ((data = reader.readLine()) != null) {
                // Convertimos el dato leído en un objeto de tipo User
                Usuario dbUser = new Gson().fromJson(data, Usuario.class);
                // Buscamos el usuario actual en la base de datos
                if (dbUser.correo.equals(user.correo)) {
                    // Actualizamos sus registros de reciclaje de la base de datos
                    dbUser.recyclings = user.recyclings;
                }
                newFileData.add(new Gson().toJson(dbUser));
            }
            reader.close();
            // Guardamos los datos en la base de datos
            BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, false)); // false para sobreescribir el archivo
            // Insertamos los nuevos datos en el archivo
            for (String newData : newFileData) {
                writer.write(newData);
                writer.newLine();
            }
            writer.close();
            Toast.makeText(context, "El reciclaje se ha registrado con éxito", Toast.LENGTH_LONG).show();
            Log.e("msg", "Se ha insertado el nuevo reciclaje en " + userFile.getName() + " exitosamente");
        } catch (IOException e) {
            Toast.makeText(context, "Error al escribir en el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean readRecyclingsFromUser(Usuario user) {
        if (userFile == null) {
            Toast.makeText(context, "Archivo de usuarios no disponible", Toast.LENGTH_LONG).show();
            return false;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(userFile));
            String data;
            while ((data = reader.readLine()) != null) {
                // Convertimos el dato leído en un objeto de tipo User
                Usuario dbUser = new Gson().fromJson(data, Usuario.class);
                // Si encontramos los registros del usuario, los almacenamos en el objeto user
                if (dbUser.correo.equals(user.correo)) {
                    user.recyclings = dbUser.recyclings;
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            Toast.makeText(context, "Error al leer el archivo " + userFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        // Si llega hasta acá es porque el usuario no tiene ningún registro de reciclaje
        return false;
    }

    public void insertAdvices(ArrayList<Advice> adviceList) {
        if (advicesFile == null) {
            Toast.makeText(context, "Archivo de consejos no disponible", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            // Guardamos los consejos en la base de datos
            BufferedWriter writer = new BufferedWriter(new FileWriter(advicesFile, false)); // false para sobreescribir el archivo
            for (Advice a : adviceList) {
                writer.write(a.objectToJSON()); // Insertamos el consejo en formato JSON dentro del archivo de texto
                writer.newLine();
            }
            writer.close();
            Log.e("msg", "Los consejos se han insertado en " + advicesFile.getName() + " exitosamente");
        } catch (IOException e) {
            Toast.makeText(context, "Error al escribir en el archivo " + advicesFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public ArrayList<Advice> loadDevicesFromDatabase() {
        ArrayList<Advice> adviceList = new ArrayList<>();
        if (advicesFile == null) {
            Toast.makeText(context, "Archivo de consejos no disponible", Toast.LENGTH_LONG).show();
            return adviceList;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(advicesFile));
            String data;
            while ((data = reader.readLine()) != null) {
                Log.e("msg", data);
                // Convertimos el dato leído en un objeto de tipo Advice
                Advice dbAdvice = new Gson().fromJson(data, Advice.class);
                adviceList.add(dbAdvice);
            }
            reader.close();
            Log.e("msg", "Se han cargado los consejos desde " + advicesFile.getName() + " exitosamente");
        } catch (IOException e) {
            Toast.makeText(context, "Error al leer los consejos en el archivo " + advicesFile.getName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return adviceList;
    }
}
