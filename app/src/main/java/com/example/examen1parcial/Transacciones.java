package com.example.examen1parcial;

public class Transacciones {

    public  static  final String tablacontacto = "contacto";

    public static final String id = "id";
    public static final String pais = "pais";
    public static final String nombre = "nombre";
    public static final String telefono = "telefono";
    public static final String nota = "nota";

    public static final String CreateTablecontacto = "CREATE TABLE contacto( id INTEGER PRIMARY KEY AUTOINCREMENT, pais TEXT, nombre TEXT, telefon TEXT, nota TEXT)";

    public static final String DropTablecontacto = "DROP TABLE IF EXISTS contacto";


    public static final String NameDataBase = "DBCurso";
}
