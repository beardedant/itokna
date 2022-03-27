import data.firebird.SQLQueries
import ru.beardedant.itokna.domain.ExelFileRepoImpl
import ru.beardedant.itokna.domain.FireBirdRepoImpl
import java.text.DecimalFormat


//const val PATH_FILE: String = "/home/ant/price4.xls"
//const val PATH_FILE: String = "/home/ant/price_reze.xls"
//const val SHEET_NAME: String = "№7"
//const val RESULT_PATH_FILE: String = "/home/ant/resultBook$SHEET_NAME.xls"
//
//fun main(args: Array<String>) {
//
//    val dbPrice = FireBirdRepoImpl().getDataFromDB()
//    val exelPrice = readPriceToArray()
//    val changePrice = mutableListOf<MutableList<String>>()
//
//
//    var counter: Int = 0
//    for (i in 0..exelPrice.lastIndex) {
//        for (j in 0..dbPrice.lastIndex) {
//
//            if (exelPrice[i][0] == dbPrice[j][0]) {
//
//                val decFormat = DecimalFormat("#.##")
//
//                if (decFormat.format(exelPrice[i][4].toFloat()) != decFormat.format(dbPrice[j][1].toFloat())) {
//                    changePrice.add(dbPrice[j].toMutableList())
////                changePrice[counter][1] = decFormat.format(exelPrice[i][4].toFloat())
//                    changePrice[counter].add(decFormat.format(exelPrice[i][4].toFloat()))
//                    changePrice[counter].add(exelPrice[i][3].trim())
//                    counter++
//                }
//            }
//        }
//    }
//
//    println("совпадение $counter \n$changePrice")
//
//    ExelFileRepoImpl().writeBook(changePrice, RESULT_PATH_FILE)
//
//
////    updateDB(changePrice)
//
//
//}
//
//private fun updateDB(changePrice: MutableList<MutableList<String>>) {
//    val dbConnect = FireBirdRepoImpl().connectDB()
//    val str = SQLQueries.SQL_UPDATE_VAL_ID
//    val stat = dbConnect.prepareStatement(str)
//    for (i in 0..changePrice.lastIndex) {
//        if (changePrice[i][3] == "EUR") {
//            stat.setString(1, changePrice[i][0])
//            stat.executeUpdate()
//        }
//    }
//    stat.close()
//}
//
//private fun readPriceToArray(): List<List<String>> {
//    val newBook = ExelFileRepoImpl().openBook(PATH_FILE)
//    return ExelFileRepoImpl().getExelData(newBook, SHEET_NAME)
//}
