package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Ayudante extends SQLiteOpenHelper {

    public Ayudante(Context ctx, String nombre, int version){
        //Recibimos los datos y los envía a SQLiteOpenHelper para empezar el proceso de creación de la BD
        super(ctx,nombre,null,version);
    }

    public Ayudante(Context ctx, String nombre){
        //Recibimos los datos y los envía a SQLiteOpenHelper para empezar el proceso de creación de la BD
        super(ctx,nombre,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se le llama para construir las tablas de la base de datos.
        //Instruccion SQL de creacion de una tabla.
        String sqlCreaTabla="create table participantes (_id integer primary key autoincrement,";
        sqlCreaTabla+="nombre text,descripcion text,linkedin text,email text,telefono integer)";
        //Ejecutamos la instrucción.
        db.execSQL(sqlCreaTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Instrucciones sobre qué hacer cuando se actualice la version de la base de datos.

    }
}
