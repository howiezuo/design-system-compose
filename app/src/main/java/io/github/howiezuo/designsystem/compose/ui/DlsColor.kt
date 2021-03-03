package io.github.howiezuo.designsystem.compose.ui

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object DlsColors {
    val primary = Color(0xFF3366FF)
    val background = Color(0xFFFFFFFF)
    val backgroundReverse = Color(0xFF192038)
    val basic = Color(0xFF8F9BB3)
    val disable = basic.copy(alpha = 0.24f)
    val text = Color(0xFF192038)
    val textReverse = Color(0xFFFFFFFF)
    val success = Color(0xFF00E096)
    val link = Color(0xFF0095FF)
    val warning = Color(0xFFFFAA00)
    val error = Color(0xFFFF3D71)
}

interface DlsColorPalette {
    val primary: Color
    val background: Color
    val basic: Color
    val disable: Color
    val text: Color
    val textReverse: Color
    val success: Color
    val link: Color
    val warning: Color
    val error: Color

    val materialColors: Colors
}

fun dlsLightColorPalette(): DlsColorPalette = object : DlsColorPalette {
    override val primary: Color = DlsColors.primary
    override val background: Color = DlsColors.background
    override val basic: Color = DlsColors.basic
    override val disable: Color = DlsColors.disable
    override val text: Color = DlsColors.text
    override val textReverse: Color = DlsColors.textReverse
    override val success: Color = DlsColors.success
    override val link: Color = DlsColors.link
    override val warning: Color = DlsColors.warning
    override val error: Color = DlsColors.error

    override val materialColors: Colors = lightColors(
        primary = DlsColors.primary,
        surface = DlsColors.backgroundReverse,
        onSurface = DlsColors.textReverse
    )
}

fun dlsDarkColorPalette(): DlsColorPalette = object : DlsColorPalette {
    override val primary: Color = DlsColors.primary
    override val background: Color = DlsColors.backgroundReverse
    override val basic: Color = DlsColors.basic
    override val disable: Color = DlsColors.disable
    override val text: Color = DlsColors.textReverse
    override val textReverse: Color = DlsColors.text
    override val success: Color = DlsColors.success
    override val link: Color = DlsColors.link
    override val warning: Color = DlsColors.warning
    override val error: Color = DlsColors.error

    override val materialColors: Colors = darkColors(
        primary = DlsColors.primary,
        surface = DlsColors.background,
        onSurface = DlsColors.textReverse
    )
}
