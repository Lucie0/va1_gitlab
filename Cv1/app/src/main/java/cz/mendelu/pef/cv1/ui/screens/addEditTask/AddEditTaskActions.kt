package cz.mendelu.pef.cv1.ui.screens.addEditTask

interface AddEditTaskActions { // actions vyuzivame ke komunikaci mezi contentem a VM

    fun saveTask()
    fun onTextChange(text: String)
    fun onDateChange(date: Long?)
    fun onLocationChanged(latitude: Double?, longitude: Double?) // pro ukladani, otazniky pro mazani
}