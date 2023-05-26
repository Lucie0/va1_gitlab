package cz.mendelu.pef.midterm2.ui.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    value: String, // hodnota
    hint: String, // co ma uzivatel psat
    onValueChange: (String) -> Unit, //  co se ma stat pri zmene
    error: String, // error
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = hint)},
        maxLines = 1,
        modifier = Modifier//.padding(paddingValues = paddingValues)
            .fillMaxWidth(),
    )

    if (error.isNotEmpty()) {
        Text(text = error)
    }
}
