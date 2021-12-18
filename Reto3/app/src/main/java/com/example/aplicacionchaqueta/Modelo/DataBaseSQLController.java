package com.example.aplicacionchaqueta.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseSQLController extends SQLiteOpenHelper {

    public DataBaseSQLController(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        //******************************* TABLA PRODUCTOS***************************
        //Creacion de la tabla
        database.execSQL("CREATE TABLE productos (img INT, titulo TEXT, descripcion TEXT)");

        //llenar la tabla con datos
        database.execSQL("INSERT INTO productos VALUES (0,'Chaqueta de Cuero','Precio: $256.000')");
        database.execSQL("INSERT INTO productos VALUES (1,'Chaqueta de Pana','Precio: $85.000')");
        database.execSQL("INSERT INTO productos VALUES (2,'Chaqueta Impermeable','Precio: $120.000')");
        database.execSQL("INSERT INTO productos VALUES (3,'Chaqueta Capucha','Precio: $95.000')");

        //******************************* TABLA SERVICIOS***************************
        //Creacion de la tabla

        database.execSQL("CREATE TABLE servicios (img INT, titulo TEXT)");

        //llenar la tabla con datos
        database.execSQL("INSERT INTO servicios VALUES (0,'Compra y adquiere de forma inmediata varios productos.')");
        database.execSQL("INSERT INTO servicios VALUES (1,'Tráenos tus chaquetas y te las lavamos.')");
        database.execSQL("INSERT INTO servicios VALUES (2,'¿Cansado de usar lo mismo? trae tu chaqueta y cámbiala.')");

        //******************************* TABLA COMPRA ******************************
        database.execSQL("CREATE TABLE compra (img INT, titulo TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
       database.execSQL("DROP TABLE productos");
       database.execSQL("DROP TABLE servicios");
       database.execSQL("DROP TABLE compra");
       onCreate(database);

    }
}
