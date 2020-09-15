package io.github.howiezuo.designsystem.compose.ui

import androidx.compose.staticAmbientOf
import androidx.ui.unit.Dp
import androidx.ui.unit.dp

data class DlsSize internal constructor(
    val smaller: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val larger: Dp = 40.dp
)

internal val DlsSizeAmbient = staticAmbientOf { DlsSize() }
