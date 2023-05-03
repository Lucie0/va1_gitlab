package cz.mendelu.pef.cv1.extensions

fun Double.round(): String {
    return String.format("%.2f", this)
}