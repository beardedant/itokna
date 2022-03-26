package ru.beardedant.itokna.data.firebird

import java.sql.Connection

interface FirebirdRepo {
    fun connectDB(): Connection
    fun getDataFromDB():List<List<String>>
    fun closeConnect(connect: Connection)
}