package ru.beardedant.itokna.domain

import org.apache.poi.EncryptedDocumentException
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory
import ru.beardedant.itokna.data.exel.ExelFileRepo
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class ExelFileRepoImpl : ExelFileRepo {

    override fun openBook(path: String): HSSFWorkbook {
        var book: HSSFWorkbook? = null

        try {
            val file = File(path)
            book = WorkbookFactory.create(file) as HSSFWorkbook

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: EncryptedDocumentException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return book!!
    }

    override fun getExelData(book: HSSFWorkbook, sheetName: String): List<List<String>> {

        val exelData = mutableListOf<MutableList<String>>()
        val sheet: HSSFSheet = book.getSheet(sheetName)
        val rowIterator: Iterator<Row> = sheet.rowIterator()

        while (rowIterator.hasNext()) {
            val row: HSSFRow = rowIterator.next() as HSSFRow
            val cellIterator: Iterator<Cell> = row.cellIterator()
            val string = mutableListOf<String>()
            while (cellIterator.hasNext()) {
                string.add(cellIterator.next().toString())
            }
            exelData.add(string)
        }
        closeBook(book)
        return exelData
    }


    override fun writeBook(changePrice: MutableList<MutableList<String>>, filePath: String) {

        val changeBook = HSSFWorkbook()
        val changeSheet = changeBook.createSheet()
        for (i in 0..changePrice.lastIndex) {
            val row = changeSheet.createRow(i)
            for (j in 0..changePrice[i].lastIndex) {
                val cell = row.createCell(j, CellType.STRING)
                cell.setCellValue(changePrice[i][j])
            }
        }

        val out = FileOutputStream(File(filePath))
        changeBook.write(out)
        out.close()

        closeBook(changeBook)
    }

    override fun closeBook(book: HSSFWorkbook) {
        book.close()
    }
}