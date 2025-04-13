package com.example.edgetoedge.ui.feature.insets.func

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InsetsFuncNestScreen(onClose: () -> Unit) {
    BackHandler {
        onClose()
    }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.Red.copy(alpha = 0.5f))
                .statusBarsPadding()
                .navigationBarsPadding(),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color.Blue.copy(alpha = 0.5f))
                    .statusBarsPadding()
                    .navigationBarsPadding(),
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
    InsetsFuncNestScreen(
        onClose = {},
    )
}
