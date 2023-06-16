package pe.com.test.ui.util

import java.text.SimpleDateFormat
import java.util.*


/**
 * DateUtil
 *
 * @author Bryam Soto
 * @since 15/06/23
 */

fun String.toDate(): Date {
    return SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(this) as Date
}

fun notReleasedYet(releaseDate: String, currentDate: Date = Date()): Boolean {
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(releaseDate) as Date
    return date.after(currentDate)
}

fun getShortDate(releaseDate: String): String {
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(releaseDate) as Date
    val day = SimpleDateFormat("dd", Locale.ENGLISH)
    val month = SimpleDateFormat("MMMM", Locale.ENGLISH)
    return "${day.format(date)} ${month.format(date)}"
}