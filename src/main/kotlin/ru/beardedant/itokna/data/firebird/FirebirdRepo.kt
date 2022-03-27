package ru.beardedant.itokna.data.firebird

import java.sql.Connection

interface FirebirdRepo {
    fun connectDB(): Connection
    fun getDataFromDB():List<FireBirdData>
    fun closeConnect(connect: Connection)
}