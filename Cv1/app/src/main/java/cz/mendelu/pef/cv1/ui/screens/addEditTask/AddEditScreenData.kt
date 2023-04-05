package cz.mendelu.pef.cv1.ui.screens.addEditTask

import cz.mendelu.pef.cv1.model.Task

class AddEditScreenData {
    var task: Task = Task("") // prazdny task -- k cemu uzitecny
    var loading: Boolean = true // vim, ze budu na zacatku nacitat, ale je to jedno
    var taskTextError: Int? = null // na zacatku zadna chyba; budeme tam davat adresu stringu, ktery chci pak zobrazovat, ktery je ve Strings.xml

}