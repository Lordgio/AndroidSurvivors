package modelo;

/**
 * Created by Jorge on 13/05/2017.
 */

public class Proyecto {

    String nombre,descripcion,participante1,participante2,participante3,github;

    public Proyecto(String nombre, String descripcion, String participante1, String participante2, String participante3, String github) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.participante1 = participante1;
        this.participante2 = participante2;
        this.participante3 = participante3;
        this.github = github;
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

    public String getParticipante1() {
        return participante1;
    }

    public void setParticipante1(String participante1) {
        this.participante1 = participante1;
    }

    public String getParticipante2() {
        return participante2;
    }

    public void setParticipante2(String participante2) {
        this.participante2 = participante2;
    }

    public String getParticipante3() {
        return participante3;
    }

    public void setParticipante3(String participante3) {
        this.participante3 = participante3;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
