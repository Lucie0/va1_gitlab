package cz.mendelu.pef.hw2.ui.elements

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spinner(
    items: List<String>,
    selectedItem: String,
    onSelectedItemChanged: (newSelectedItem: String) -> Unit,
    error: Int? = null
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it }
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            label = { Text(text = "Type")},
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            isError = error != null,
            supportingText = {
                if (error != null) {
                    Text(text = stringResource(id = error))
                }
            }
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        isExpanded = false
                        onSelectedItemChanged(item)
                    }
                )
            }
        }
    }
}