package cz.mendelu.pef.hw2.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import cz.mendelu.pef.hw2.R
import cz.mendelu.pef.hw2.architecture.BaseViewModel
import cz.mendelu.pef.hw2.database.IRepository
import cz.mendelu.pef.hw2.model.Contact
import kotlinx.coroutines.launch

// data -- cely ten kontakt + errory

class AddContactVM(private val repository: IRepository) : BaseViewModel() {

    var addContactUIState: MutableState<AddContactUIState> =
        mutableStateOf(AddContactUIState.Loading)

    var data: Contact = Contact(
        "",
        "",
        "",
        ""
    )

    var error_fname: Int? = null
    var error_lname: Int? = null
    var error_phone: Int? = null
    var error_type: Int? = null

    fun onFNameChanged(value: String) {
        data.fname = value
        print("VALUE:$value")
        addContactUIState.value = AddContactUIState.Changed
    }

    fun onLNameChanged(value: String) {
        data.lname = value
        addContactUIState.value = AddContactUIState.Changed
    }

    fun onPhoneChanged(value: String) {
        data.phone_number = value
        addContactUIState.value = AddContactUIState.Changed
    }

    fun onTypeChanged(value: String) {
        data.type = value
        print("Data:" + data.type)
        addContactUIState.value = AddContactUIState.Changed
    }

    fun onEmailChanged(value: String) {
        data.email = value
        addContactUIState.value = AddContactUIState.Changed
    }

    fun save() {
        print("Save fce")
        var isValid = isValid()

        if (isValid) {
            launch {
                repository.insert(data)
                addContactUIState.value = AddContactUIState.Saved
            }
        } else {
            addContactUIState.value = AddContactUIState.Changed
        }

    }

    private fun isValid(): Boolean {
        var isValid = true

        error_fname = null
        error_type = null
        error_lname = null
        error_phone = null

        print("ISVALID:$isValid")

        if (data.fname.isEmpty()) {
            isValid = false
            error_fname = R.string.mandatory_field
        }
        if (data.lname.isEmpty()) {
            isValid = false
            error_lname = R.string.mandatory_field
        }

        if (data.phone_number.isEmpty()) {
            isValid = false
            error_phone = R.string.mandatory_field
        }
        if (data.type.isEmpty()) {
            isValid = false
            error_type = R.string.mandatory_field
        }

        return isValid
    }
}