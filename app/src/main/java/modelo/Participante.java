package modelo;

import java.io.Serializable;


public class Participante implements Serializable {

    private String nombre,descripcion,linkedin,email;
    private int telefono;

    public Participante(String nombre, String descripcion, String linkedin, String email, int telefono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.linkedin = linkedin;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombre+"|"+descripcion+"|"+linkedin+"|"+email+"|"+telefono;
    }
}
