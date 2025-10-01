package com.hn.sprase.presentation.screen.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

enum class TimeRange { Week, Month, Year }

@Composable
fun RangePill(
    range : TimeRange,
    onRangeChange : (TimeRange) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Box(modifier, contentAlignment = Alignment.TopStart) {
        Surface {
            
        }
    }
}