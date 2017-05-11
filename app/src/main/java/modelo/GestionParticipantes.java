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
        cerrar();
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
        cerrar();
        return parts;
    }

    public int comprobarParticipantes(){
        String sql="select * from participantes";
        Cursor c=db.rawQuery(sql,null);
        int total=0;
        while(c.moveToNext()){
            total++;
        }
        cerrar();
        return total;

    }
    public void eliminarTodos(){
        String sql="delete * from participantes";
        db.execSQL(sql);
        cerrar();
    }
}
