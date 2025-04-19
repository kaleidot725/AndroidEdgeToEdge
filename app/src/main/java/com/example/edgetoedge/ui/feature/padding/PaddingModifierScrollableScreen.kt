package com.example.edgetoedge.ui.feature.padding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PaddingModifierScrollableScreen(onClose: () -> Unit) {
    BackHandler {
        onClose()
    }

    val items = (0 until 100).toList()

    Row(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.Green.copy(alpha = 0.5f)),
    ) {
        Column(
            modifier =
                Modifier
                    .weight(1.0f)
                    .consumeWindowInsets(WindowInsets.statusBars)
                    .background(Color.Red.copy(alpha = 0.5f))
                    .verticalScroll(rememberScrollState())
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .padding(WindowInsets.navigationBars.asPaddingValues())
                    .background(Color.Blue.copy(alpha = 0.5f)),
        ) {
            items.forEach { index ->
                Text(
                    text = "リスト1 : $index",
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }

        Column(
            modifier =
                Modifier
                    .weight(1.0f)
                    .background(Color.Yellow.copy(alpha = 0.5f))
                    .verticalScroll(rememberScrollState())
                    .padding(WindowInsets.statusBars.asPaddingValues())
                    .padding(WindowInsets.navigationBars.asPaddingValues())
                    .background(Color.Cyan.copy(alpha = 0.5f)),
        ) {
            items.forEach { index ->
                Text(
                    text = "リスト2 : $index",
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PaddingModifierScrollableScreen(
        onClose = {},
    )
}
