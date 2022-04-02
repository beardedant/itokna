package data.firebird

import ru.beardedant.itokna.data.firebird.DBStructure

object SQLQueries {
    private val db = DBStructure

    const val SQL_SELECT_STATUS: String =
        "select " +
                "f.${db.DB_FIELD_DOC_NUMBER}, " +
                "f.${db.DB_FIELD_DOC_DATE}," +
                "z.${db.DB_FIELD_ORDER_SQRT}, " +
                "s.${db.DB_FIELD_STATUS_NAME} " +
                "from ${db.DB_TABLE_SERVICE} s, ${db.DB_TABLE_ORDER} f, ${db.DB_TABLE_CONSTRUCTIONS} z " +
                "where s.${db.DB_FIELD_VID} = 7 " +
                "and f.${db.DB_FIELD_STATUS} = s.${db.DB_FIELD_VID_ID} " +
                "and f.${db.DB_FIELD_DOC_NUMBER} = ? " +
                "and f.${db.DB_FIELD_ID_DOC} = z.${db.DB_FIELD_ID_DOC}"
}