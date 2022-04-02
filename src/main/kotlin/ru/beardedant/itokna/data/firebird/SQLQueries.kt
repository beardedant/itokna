package data.firebird

import ru.beardedant.itokna.data.firebird.DBStructure

object SQLQueries {
    private val db = DBStructure

    const val SQL_SELECT_STATUS: String =
        " select " +
                "z.${db.DB_FIELD_ID_DOC}, " +
                "z.${db.DB_FIELD_DOC_NUMBER}, " +
                "z.${db.DB_FIELD_DOC_DATE}, " +
                "z.${db.DB_FIELD_STATUS}, " +
                "f.${db.DB_FIELD_ORDER_SQRT} " +
                "from ${db.DB_TABLE_ORDER} z, ${db.DB_TABLE_CONSTRUCTIONS} f " +
                "where z.${db.DB_FIELD_ID_DOC} = f.${db.DB_FIELD_ID_DOC} AND z.${db.DB_FIELD_DOC_NUMBER} = ?"
}