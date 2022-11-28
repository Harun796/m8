package com.m9.myapplication.DB

    object SeleccionEspContract {
        val TABLE_NAME = "jugadores"
        val COLUMN_NAME_EQUIPO = "equipo"
        val COLUMN_NAME_NOMBRE = "nombre"

        val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${TABLE_NAME} (" +
                    "id INTEGER PRIMARY KEY," +
                    "${COLUMN_NAME_EQUIPO} TEXT," +
                    "${COLUMN_NAME_NOMBRE} TEXT)"

        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"

    }

