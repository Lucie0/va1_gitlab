package cz.mendelu.pef.cv1.ui.screens.map

import cz.mendelu.pef.cv1.architecture.BaseViewModel
import cz.mendelu.pef.cv1.database.ITasksRepository
import cz.mendelu.pef.cv1.ui.screens.addEditTask.AddEditTaskActions


class MapViewModel(private val repository: ITasksRepository)
    : BaseViewModel(), MapScreenActions{
    var latitude: Double? = null
    var longitude: Double? = null
    var locationChanged = false

    override fun onLocationChanged(latitude: Double, longitude: Double) {
        locationChanged = true
        this.latitude = latitude
        this.longitude = longitude
    }

}