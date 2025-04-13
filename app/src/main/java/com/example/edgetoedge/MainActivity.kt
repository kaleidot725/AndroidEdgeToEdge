package com.example.edgetoedge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.edgetoedge.ui.feature.home.HomeScreen
import com.example.edgetoedge.ui.feature.insets.func.InsetsFuncNestScreen
import com.example.edgetoedge.ui.feature.insets.func.InsetsFuncScreen
import com.example.edgetoedge.ui.feature.insets.modifier.InsetsModifierNestScreen
import com.example.edgetoedge.ui.feature.insets.modifier.InsetsModifierScreen
import com.example.edgetoedge.ui.feature.padding.PaddingModifierNestScreen
import com.example.edgetoedge.ui.feature.padding.PaddingModifierScreen

enum class MainRoute {
    HOME,
    INSETS_FUNC,
    INSETS_FUNC_NEST,
    INSETS_MODIFIER,
    INSETS_MODIFIER_NEST,
    PADDING_MODIFIER,
    PADDING_MODIFIER_NEST,
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
                        HomeScreen(onNavigate = { mainRoute = it })
                    MainRoute.INSETS_FUNC ->
                        InsetsFuncScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.INSETS_FUNC_NEST ->
                        InsetsFuncNestScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.INSETS_MODIFIER ->
                        InsetsModifierScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.INSETS_MODIFIER_NEST ->
                        InsetsModifierNestScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.PADDING_MODIFIER ->
                        PaddingModifierScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.PADDING_MODIFIER_NEST ->
                        PaddingModifierNestScreen(onClose = { mainRoute = MainRoute.HOME })
                }
            }
        }
    }
}
