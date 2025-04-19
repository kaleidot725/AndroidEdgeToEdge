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
import com.example.edgetoedge.ui.feature.insets.consume.ConsumeScreen
import com.example.edgetoedge.ui.feature.insets.func.InsetsFuncNestScreen
import com.example.edgetoedge.ui.feature.insets.func.InsetsFuncScrollableScreen
import com.example.edgetoedge.ui.feature.insets.modifier.InsetsModifierNestScreen
import com.example.edgetoedge.ui.feature.insets.modifier.InsetsModifierScrollableScreen
import com.example.edgetoedge.ui.feature.padding.PaddingModifierNestScreen
import com.example.edgetoedge.ui.feature.padding.PaddingModifierScrollableScreen

enum class MainRoute {
    HOME,
    INSETS_FUNC_SCROLLABLE,
    INSETS_FUNC_NEST,
    INSETS_MODIFIER_SCROLLABLE,
    INSETS_MODIFIER_NEST,
    PADDING_MODIFIER_SCROLLABLE,
    PADDING_MODIFIER_NEST,
    CONSUME,
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
                    MainRoute.INSETS_FUNC_SCROLLABLE ->
                        InsetsFuncScrollableScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.INSETS_FUNC_NEST ->
                        InsetsFuncNestScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.INSETS_MODIFIER_SCROLLABLE ->
                        InsetsModifierScrollableScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.INSETS_MODIFIER_NEST ->
                        InsetsModifierNestScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.PADDING_MODIFIER_SCROLLABLE ->
                        PaddingModifierScrollableScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.PADDING_MODIFIER_NEST ->
                        PaddingModifierNestScreen(onClose = { mainRoute = MainRoute.HOME })
                    MainRoute.CONSUME ->
                        ConsumeScreen(onClose = { mainRoute = MainRoute.HOME })
                }
            }
        }
    }
}
