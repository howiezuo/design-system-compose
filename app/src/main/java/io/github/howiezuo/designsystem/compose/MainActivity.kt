package io.github.howiezuo.designsystem.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.howiezuo.designsystem.compose.ui.DlsTheme
import io.github.howiezuo.designsystem.compose.ui.dlsDarkColorPalette
import io.github.howiezuo.designsystem.compose.ui.dlsLightColorPalette

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isDarkState = mutableStateOf(false)

        setContent {
            DlsTheme(
                colors = if (isDarkState.value) dlsDarkColorPalette() else dlsLightColorPalette()
            ) {
                val (currentSection, setCurrentSection) = rememberSaveable {
                    mutableStateOf(HomeSections.Style)
                }
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Design System Jetpack Compose",
                                    color = DlsTheme.colors.textReverse
                                )
                            },
                            backgroundColor = DlsTheme.colors.primary,
                            actions = {
                                Switch(
                                    checked = isDarkState.value,
                                    onCheckedChange = { checked ->
                                        isDarkState.value = checked
                                    },
                                    colors = SwitchDefaults.colors(
                                        checkedThumbColor = DlsTheme.colors.text,
                                        uncheckedThumbColor = DlsTheme.colors.basic
                                    )
                                )
                            }
                        )
                    },
                    bottomBar = {
                        BottomAppBar(
                            backgroundColor = DlsTheme.colors.primary
                        ) {
                            val navItems = HomeSections.values().toList()
                            navItems.forEach { section ->
                                BottomNavigationItem(
                                    selected = currentSection == section,
                                    onClick = {
                                        setCurrentSection(section)
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = section.icon,
                                            contentDescription = null
                                        )
                                    },
                                    label = {
                                        Text(section.label)
                                    }
                                )
                            }
                        }
                    },
                    backgroundColor = DlsTheme.colors.background
                ) { paddingValues ->
                    Crossfade(
                        currentSection,
                        modifier = Modifier.padding(paddingValues)
                    ) { section ->
                        when (section) {
                            HomeSections.Style -> StyleScreen()
                            HomeSections.Component -> ComponentScreen()
                        }
                    }
                }
            }
        }
    }
}

private enum class HomeSections(
    val label: String,
    val icon: ImageVector
) {
    Style("Style", Icons.Outlined.Favorite),
    Component("Component", Icons.Outlined.List),
}
