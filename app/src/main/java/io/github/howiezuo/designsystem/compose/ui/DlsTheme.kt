package io.github.howiezuo.designsystem.compose.ui

import androidx.compose.Composable
import androidx.compose.Providers
import androidx.ui.material.MaterialTheme

@Composable
fun DlsTheme(
    colors: DlsColorPalette = dlsLightColorPalette(),
    typography: DlsTypography = DlsTypography(),
    children: @Composable() () -> Unit
) {
    Providers(
        DlsColorAmbient provides colors,
        DlsTypographyAmbient provides typography,
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
    @Composable
    val colors: DlsColorPalette
        get() = DlsColorAmbient.current

    @Composable
    val typography: DlsTypography
        get() = DlsTypographyAmbient.current

    @Composable
    val sizes: DlsSize
        get() = DlsSizeAmbient.current
}
