package modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class GestionParticipantes {

    Ayudante helper;
    SQLiteDatabase db;
    public GestionParticipantes(Context ctx){
        //Creación objeto ayudante
        helper=new Ayudante(ctx,"datos",1);
        db=helper.getWritableDatabase();
    }

    public void altaParticipante(Participante p){
        String sql="insert into participantes (nombre,descripcion,linkedin,email,telefono) ";
        sql+="values ('"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getLinkedin()+"','"+p.getEmail()+"',"+p.getTelefono()+")";
        db.execSQL(sql);
        //cerrar();
    }

    public void cerrar(){
        db.close();
    }

    public ArrayList<Participante> obtenerParticipantes(){
        String sql="select * from participantes";
        Cursor c= db.rawQuery(sql,null);
        ArrayList<Participante>parts=new ArrayList<>();
        while(c.moveToNext()){
            Participante p=new Participante(c.getString(1),c.getString(2),c.getString(3),c.getString(4),Integer.parseInt(c.getString(5)));
            parts.add(p);
        }
        //cerrar();
        return parts;
    }

    public Participante obtenerParticipante(String nombre){
        String sql="select * from participantes where nombre='"+nombre+"'";
        Cursor c= db.rawQuery(sql,null);
        Participante p=null;
        while(c.moveToNext()){
            p=new Participante(c.getString(1),c.getString(2),c.getString(3),c.getString(4),Integer.parseInt(c.getString(5)));
        }
        return p;
    }

    public int comprobarParticipantes(){
        String sql="select * from participantes";
        Cursor c=db.rawQuery(sql,null);
        int total=0;
        while(c.moveToNext()){
            total++;
        }
        //cerrar();
        return total;

    }
    public void eliminarParticipantes(){
        String sql="delete * from participantes";
        db.execSQL(sql);
        //cerrar();
    }

    public void altaProyecto(Proyecto p){
        String sql="insert into proyectos (nombre,descripcion,participante1,participante2,participante3,github) ";
        sql+="values ('"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getParticipante1()+"','"+p.getParticipante2()+"','"+p.getParticipante3()+"','"+p.getGithub()+"')";
        db.execSQL(sql);
        //cerrar();
    }

    public Proyecto obtenerProyecto(String nombre){
        String sql="select * from proyectos where nombre='"+nombre+"'";
        Cursor c= db.rawQuery(sql,null);
        Proyecto p=null;
        while(c.moveToNext()){
            p=new Proyecto(c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6));
        }
        //cerrar();
        return p;
    }

    public void eliminarProyectos(){
        String sql="delete * from proyectos";
        db.execSQL(sql);
        //cerrar();
    }

    public int comprobarProyectos(){
        String sql="select * from proyectos";
        Cursor c=db.rawQuery(sql,null);
        int total=0;
        while(c.moveToNext()){
            total++;
        }
        //cerrar();
        return total;

    }

}
