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
        //Instruccion SQL de creacion de la tabla de participantes.
        String sqlCrearTabla1="create table participantes (_id integer primary key autoincrement,";
        sqlCrearTabla1+="nombre text,descripcion text,linkedin text,email text,telefono integer)";
        //Ejecutar la instrucción 1.
        db.execSQL(sqlCrearTabla1);
        //Instruccion SQL de creacion de la tabla de proyectos.
        String sqlCrearTabla2="create table proyectos (_id integer primary key autoincrement,";
        sqlCrearTabla2+="nombre text,descripcion text,participante1 text,participante2 text,participante3 text,github text)";
        //Ejecutar instruccion 2.
        db.execSQL(sqlCrearTabla2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Instrucciones sobre qué hacer cuando se actualice la version de la base de datos.

    }
}
