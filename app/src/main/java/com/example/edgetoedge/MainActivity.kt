package com.example.edgetoedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.edgetoedge.ui.feature.home.HomeScreen
import com.example.edgetoedge.ui.feature.insets.func.InsetsFuncScreen
import com.example.edgetoedge.ui.feature.insets.modifier.InsetsModifierScreen
import com.example.edgetoedge.ui.feature.padding.PaddingModifierScreen

enum class MainRoute {
    HOME,
    INSETS_FUNC,
    INSETS_MODIFIER,
    PADDING_MODIFIER,
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var mainRoute by remember { mutableStateOf(MainRoute.HOME) }
            MaterialTheme {
                when (mainRoute) {
                    MainRoute.HOME ->
                        HomeScreen(
                            onNavigate = { mainRoute = it },
                            modifier = Modifier.fillMaxSize(),
                        )
                    MainRoute.INSETS_FUNC ->
                        InsetsFuncScreen(
                            onClose = { mainRoute = MainRoute.HOME },
                        )
                    MainRoute.INSETS_MODIFIER ->
                        InsetsModifierScreen(
                            onClose = { mainRoute = MainRoute.HOME },
                        )
                    MainRoute.PADDING_MODIFIER ->
                        PaddingModifierScreen(
                            onClose = { mainRoute = MainRoute.HOME },
                        )
                }
            }
        }
    }
}
