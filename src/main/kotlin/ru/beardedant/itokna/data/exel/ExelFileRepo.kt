package ru.beardedant.itokna.data.exel

import org.apache.poi.hssf.usermodel.HSSFWorkbook

interface ExelFileRepo {
    fun openBook(path: String): HSSFWorkbook
    fun getExelData(book: HSSFWorkbook, sheetName: String):List<List<String>>
    fun writeBook(changePrice: MutableList<MutableList<String>>, filePath: String)
    fun closeBook(book: HSSFWorkbook)
}