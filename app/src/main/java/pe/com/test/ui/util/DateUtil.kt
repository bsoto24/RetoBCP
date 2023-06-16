package pe.com.test.ui.util

import java.text.SimpleDateFormat
import java.util.*


/**
 * DateUtil
 *
 * @author Bryam Soto
 * @since 15/06/23
 */

fun notReleasedYet(releaseDate: String, currentDate: Date = Date()): Boolean {
    val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(releaseDate) as Date
    return date.after(currentDate)
}
