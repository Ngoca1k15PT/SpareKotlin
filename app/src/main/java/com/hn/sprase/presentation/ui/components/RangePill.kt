package com.hn.sprase.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hn.sprase.domain.model.TimeRange

@Composable
fun RangePill(
    range: TimeRange,
    onRangeChange: (TimeRange) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Box(modifier, contentAlignment = Alignment.TopStart) {
        Surface(
            onClick = {expanded = true},
            shape = RoundedCornerShape(50),
            color = Color(0xFFE9EFFF),
            contentColor = Color(0xFF407AFF),
            shadowElevation = 0.dp,
            tonalElevation = 0.dp
        ) {
            Row(Modifier.padding(horizontal = 12.dp, vertical = 6.dp,), verticalAlignment = Alignment.CenterVertically) {
                Text(range.name, style = MaterialTheme.typography.labelLarge, color =Color(0xFF407AFF))
//                Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = null, tint = Color(0xFF407AFF))
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color(0xFF407AFF))
            }
        }

        DropdownMenu(expanded = expanded, onDismissRequest = {expanded = false}) {
            TimeRange.entries.forEach { option ->
                DropdownMenuItem(
                    text = {Text(option.name)},
                    onClick = {
                        expanded = false
                        if (option != range) onRangeChange(option)
                    }
                )
            }
        }
    }
}
