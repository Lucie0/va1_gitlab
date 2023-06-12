package cz.pef.mendelu.exam.ui.utils

import java.text.SimpleDateFormat
import java.util.*


class DateUtils {
    companion object {
        private val DATE_FORMAT_EN = "yyyy/MM/dd"

        fun getDateString(unixTime: Long): String{
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = unixTime
            val format: SimpleDateFormat = SimpleDateFormat(DATE_FORMAT_EN, Locale.ENGLISH)
            return format.format(calendar.getTime()) // .time
        }

        fun getUnixTime(year: Int, month: Int, day: Int): Long {
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            return calendar.timeInMillis
        }
    }
}