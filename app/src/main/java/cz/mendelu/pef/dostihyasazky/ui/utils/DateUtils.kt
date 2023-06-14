package cz.mendelu.pef.dostihyasazky.ui.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        private val DATE_FORMAT_CS = "dd. MM. yyyy"
        private val DATETIME_FORMAT_CS = "dd. MM. yyyy HH:mm"
        private val DATE_FORMAT_EN = "yyyy/MM/dd"
        private val DATETIME_FORMAT_EN = "yyyy/MM/dd HH:mm"

        fun getDateString(unixTime: Long): String{
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = unixTime
            val format: SimpleDateFormat
            if (LanguageUtils.isLanguageCzech()){
                format = SimpleDateFormat(DATE_FORMAT_CS, Locale.GERMAN)
            } else {
                format = SimpleDateFormat(DATE_FORMAT_EN, Locale.ENGLISH)
            }
            return format.format(calendar.getTime()) // .time
        }

        fun getUnixTime(year: Int, month: Int, day: Int): Long {
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            return calendar.timeInMillis
        }

        fun getToday(withTime: Boolean = false): String {
//            val calendar = Calendar.getInstance()
//            calendar.timeInMillis = unixTime
//            val format: SimpleDateFormat = SimpleDateFormat(DATE_FORMAT_NOW);
            val time = Calendar.getInstance().time
            val format: SimpleDateFormat
            if (LanguageUtils.isLanguageCzech()){
                if(withTime) {
                    format = SimpleDateFormat(DATETIME_FORMAT_CS, Locale.GERMAN)
                }
                else {
                    format = SimpleDateFormat(DATE_FORMAT_CS, Locale.GERMAN)
                }
            } else {
                if(withTime) {
                    format = SimpleDateFormat(DATETIME_FORMAT_EN, Locale.ENGLISH)
                } else {
                    format = SimpleDateFormat(DATE_FORMAT_EN, Locale.ENGLISH)
                }
            }
//            val format = SimpleDateFormat("yyyy-MM-dd")
            return format.format(time)
        }
    }
}
