package com.moisesmuar.alquiler.Clases;

import com.moisesmuar.alquiler.Models.UserModel;

/**
 * Clase que contiene objeto UserModel y un mensaje.
 * Si inicio sesión es exitoso, se devuelve objeto UserModel
 * Si credenciales son inválidas, se devuelve mensaje error
 */
public class LoginResponse {
    private UserModel user;
    private String message;

    public LoginResponse() {

    }
    public LoginResponse(UserModel user, String message) {
        this.user = user;
        this.message = message;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
