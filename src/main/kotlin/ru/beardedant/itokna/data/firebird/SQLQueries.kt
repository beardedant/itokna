package data.firebird

import ru.beardedant.itokna.data.firebird.DBStructure

object SQLQueries {
    private val db = DBStructure
    const val SQL_SELECT: String =
        "select ${db.DB_TABLE_MATERIALS}.${db.DB_FIELD_ART}, " +
                "${db.DB_TABLE_MATERIAL_COST}.${db.DB_FIELD_COST} " +
                "from ${db.DB_TABLE_MATERIAL_COST},${db.DB_TABLE_MATERIALS} " +
                "where ${db.DB_TABLE_MATERIAL_COST}.${db.DB_FIELD_MATERIAL_ID} = ${db.DB_TABLE_MATERIALS}.${db.DB_FIELD_MATERIAL_ID}"

    const val SQL_UPDATE_VAL_ID: String =
        "update ${db.DB_TABLE_MATERIALS} " +
                "set ${db.DB_TABLE_MATERIALS}.${db.DB_FIELD_VAL_ID} = '2' " +
                "where ${db.DB_TABLE_MATERIALS}.${db.DB_FIELD_ART} = ?"
}