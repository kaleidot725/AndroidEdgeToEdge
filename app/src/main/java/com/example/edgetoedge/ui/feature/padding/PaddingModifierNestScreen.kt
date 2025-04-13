package com.example.edgetoedge.ui.feature.padding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PaddingModifierNestScreen(onClose: () -> Unit) {
    BackHandler {
        onClose()
    }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.Red.copy(alpha = 0.5f))
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(WindowInsets.navigationBars.asPaddingValues()),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.Blue.copy(alpha = 0.5f))
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .padding(WindowInsets.navigationBars.asPaddingValues()),
        ) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(Color.Green.copy(alpha = 0.5f)),
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PaddingModifierNestScreen(
        onClose = {},
    )
}
