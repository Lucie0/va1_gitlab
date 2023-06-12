package cz.pef.mendelu.exam.ui.elements

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cz.pef.mendelu.exam.model.Fault

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRow(
    item: Fault
) {
    ListItem(
        headlineText = { Text(item.text) },
        supportingText = { Text(text = "Pocet bodu: " + (item.points ?: "")) }
    )
}