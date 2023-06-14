package cz.mendelu.pef.dostihyasazky.ui.elements

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    label: String,
    value: String,
    enabled: Boolean,
    onValueChange: (newValue: String) -> Unit,
    error: Int? = null
){

    TextField(
        label = { Text(text = label) },
        value = value,
        enabled = enabled,
        onValueChange = onValueChange,
        singleLine = true,
        isError = error != null,
        supportingText = {
            if (error != null) {
                Text(text = stringResource(id = error))
            }
        }
    )

}
