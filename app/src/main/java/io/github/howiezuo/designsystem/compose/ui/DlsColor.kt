package io.github.howiezuo.designsystem.compose.ui

import androidx.compose.staticAmbientOf
import androidx.ui.graphics.Color
import androidx.ui.material.ColorPalette
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette

val primary = Color(0xFF3366FF)
val background = Color(0xFFFFFFFF)
val backgroundReverse = Color(0xFF192038)
val basic = Color(0xFF8F9BB3)
val text = Color(0xFF192038)
val textReverse = Color(0xFFFFFFFF)
val success = Color(0xFF00E096)
val link = Color(0xFF0095FF)
val warning = Color(0xFFFFAA00)
val error = Color(0xFFFF3D71)

interface DlsColorPalette {
    val primary: Color
    val background: Color
    val basic: Color
    val text: Color
    val textReverse: Color
    val success: Color
    val link: Color
    val warning: Color
    val error: Color

    val materialColors: ColorPalette
}

private class DlsObservableColorPalette(
    override val primary: Color,
    override val background: Color,
    override val basic: Color,
    override val text: Color,
    override val textReverse: Color,
    override val success: Color,
    override val link: Color,
    override val warning: Color,
    override val error: Color,

    override val materialColors: ColorPalette
) : DlsColorPalette

fun dlsLightColorPalette(): DlsColorPalette = DlsObservableColorPalette(
    primary = primary,
    background = background,
    basic = basic,
    text = text,
    textReverse = textReverse,
    success = success,
    link = link,
    warning = warning,
    error = error,

    materialColors = lightColorPalette(
        primary = primary,
        surface = background,
        onSurface = text
    )
)

fun dlsDarkColorPalette(): DlsColorPalette = DlsObservableColorPalette(
    primary = primary,
    background = backgroundReverse,
    basic = basic,
    text = textReverse,
    textReverse = text,
    success = success,
    link = link,
    warning = warning,
    error = error,

    materialColors = darkColorPalette(
        primary = primary,
        surface = backgroundReverse,
        onSurface = textReverse
    )
)

internal val DlsColorAmbient = staticAmbientOf { dlsLightColorPalette() }
