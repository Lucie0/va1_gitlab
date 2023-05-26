package cz.mendelu.pef.midterm2.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.midterm2.architecture.BaseViewModel
import cz.mendelu.pef.midterm2.database.IRepository
import cz.mendelu.pef.midterm2.model.Player
import kotlinx.coroutines.launch

class AddPlayerVM (private val repository: IRepository) : BaseViewModel() {

    var dataPlayer: Player = Player("")

    var addPlayerUIState: MutableState<AddPlayerUIState> =
            mutableStateOf(AddPlayerUIState.Loading)

    fun save() {
        if (dataPlayer.name.isEmpty()) {
            // error IsEmpty
            println("name is empty")
            addPlayerUIState.value = AddPlayerUIState.Changed
        } else {
            println("SAVING>>>")
            launch {
                repository.insert(dataPlayer)
                addPlayerUIState.value = AddPlayerUIState.Saved
            }
        }
    }

    fun onValueChange(name: String){
        dataPlayer.name = name
        addPlayerUIState.value = AddPlayerUIState.Changed
        println("$name == ${dataPlayer.name}")
    }

    fun initItem(){
        if(dataPlayer.id != null){
            launch {
                dataPlayer = repository.getItemById(dataPlayer.id!!)
                // hlaska o zmene stavu
                addPlayerUIState.value = AddPlayerUIState.Changed
            }
        } else {
            // hlaska o zmene stavu
            addPlayerUIState.value = AddPlayerUIState.Changed
        }
    }

}
