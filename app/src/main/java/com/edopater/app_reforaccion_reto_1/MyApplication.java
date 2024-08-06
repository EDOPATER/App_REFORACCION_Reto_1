package com.edopater.app_reforaccion_reto_1;

import android.app.Application;
import com.edopater.app_reforaccion_reto_1.modelos.Usuario;

public class MyApplication extends Application {
    private Usuario user;

    @Override
    public void onCreate() {
        super.onCreate();
        user = new Usuario();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
