package io.github.howiezuo.designsystem.compose.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun DlsTheme(
    colors: DlsColorPalette = dlsLightColorPalette(),
    typography: DlsTypography = DlsTypography(),
    children: @Composable() () -> Unit
) {
    CompositionLocalProvider(
        LocalDlsColors provides colors,
        LocalDlsTypography provides typography,
    ) {
        MaterialTheme(
            colors = colors.materialColors,
            typography = typography.materialTypography
        ) {
            children()
        }
    }
}

object DlsTheme {
    val colors: DlsColorPalette
        @Composable
        @ReadOnlyComposable
        get() = LocalDlsColors.current

    val typography: DlsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDlsTypography.current

    val sizes: DlsSize
        @Composable
        @ReadOnlyComposable
        get() = DlsSize()
}

internal val LocalDlsColors = staticCompositionLocalOf { dlsLightColorPalette() }
internal val LocalDlsTypography = staticCompositionLocalOf { DlsTypography() }
