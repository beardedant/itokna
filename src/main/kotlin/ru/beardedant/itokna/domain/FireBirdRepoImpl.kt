package ru.beardedant.itokna.domain


import ru.beardedant.itokna.data.firebird.DBStructure
import ru.beardedant.itokna.data.firebird.FirebirdRepo
import data.firebird.SQLQueries
import ru.beardedant.itokna.data.firebird.FireBirdData
import java.sql.Connection
import java.sql.Driver
import java.sql.DriverManager
import java.util.*

class FireBirdRepoImpl : FirebirdRepo {
    private val db = DBStructure

    override fun connectDB(): Connection {
        val url: String = db.DB_URL
        var connect: Connection? = null

        try {
            DriverManager.registerDriver(
                Class.forName(db.DB_JDBC_DRIVER_URL).newInstance() as Driver
            )
            val driver = DriverManager.getDriver(url)
            println("myLogs driver version: ${driver.majorVersion}")
            val props = Properties()
            props.setProperty("user", db.DB_USER_NAME)
            props.setProperty("password", db.DB_PASSWORD)
            props.setProperty("encoding", db.DB_ENCODING)

            connect = driver.connect(url, props)

        } catch (e: Throwable) {
            // A call to Class.forName() forces us to consider this exception :-)...
            println("myLogs Driver not found in class path: ${e.message}")
        }
        return connect!!
    }

    override fun getDataFromDB(): List<FireBirdData> {
        val connect = connectDB()
        val resultPrice = mutableListOf<FireBirdData>()
        val statement = connect.createStatement()

        val result = statement.executeQuery(SQLQueries.SQL_SELECT)

        while (result.next()) {
            val stringPrice = FireBirdData(result.getString(db.DB_FIELD_ART), result.getString(db.DB_FIELD_COST) ?: "0")
            resultPrice.add(stringPrice)
        }

        closeConnect(connect)

        return resultPrice
    }

    override fun closeConnect(connect: Connection) {
        connect.close()
    }
}