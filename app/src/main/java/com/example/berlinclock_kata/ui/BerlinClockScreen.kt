package com.example.berlinclock_kata.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.berlinclock_kata.ui.models.BerlinClockUiModel
import com.example.berlinclock_kata.ui.theme.Berlinclock_kataTheme
import com.example.berlinclock_kata.ui.viewmodels.BerlinClockViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BerLinClockScreen(viewModel: BerlinClockViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    BerlinClockContent(uiState.value)
}

@Composable
fun BerlinClockContent(uiState: BerlinClockUiModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2C2C2C))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        SecondLamp(uiState.second)
        LightRow(uiState.fiveHourRow)
        LightRow(uiState.oneHourRow)
        LightRow(uiState.fiveMinRow)
        LightRow(uiState.oneMinRow)
    }
}
@Composable
fun SecondLamp(color: Color) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(color)
    )
}

@Composable
fun LightRow(
    colourCode: List<Color>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        for (i in 0 until colourCode.size) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(4.dp))
                    .background(
                        colourCode[i]
                    )
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Berlinclock_kataTheme {
        val previewState = BerlinClockUiModel(
            second = Color.Yellow,
            fiveHourRow = listOf(
                Color.Red,
                Color.Red,
                Color.DarkGray,
                Color.DarkGray
            ),
            oneHourRow = listOf(
                Color.Red,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray
            ),
            fiveMinRow = listOf(
                Color.Yellow,
                Color.Yellow,
                Color.Red,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray
            ),
            oneMinRow = listOf(
                Color.Yellow,
                Color.DarkGray,
                Color.DarkGray,
                Color.DarkGray
            )
        )
        BerlinClockContent(previewState)
    }
}