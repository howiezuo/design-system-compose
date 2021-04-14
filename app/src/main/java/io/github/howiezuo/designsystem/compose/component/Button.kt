package io.github.howiezuo.designsystem.compose.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.howiezuo.designsystem.compose.ui.DlsTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = DlsTheme.colors.primary,
            contentColor = DlsTheme.colors.textReverse
        ),
        contentPadding = PaddingValues(
            start = DlsTheme.sizes.large,
            top = DlsTheme.sizes.medium,
            end = DlsTheme.sizes.large,
            bottom = DlsTheme.sizes.medium
        )
    ) {
        Text(
            text = text,
            style = DlsTheme.typography.button
        )
    }
}

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = DlsTheme.colors.primary
        ),
        border = BorderStroke(1.dp, DlsTheme.colors.primary),
        contentPadding = PaddingValues(
            start = DlsTheme.sizes.large,
            top = DlsTheme.sizes.medium,
            end = DlsTheme.sizes.large,
            bottom = DlsTheme.sizes.medium
        )
    ) {
        Text(
            text = text,
            style = DlsTheme.typography.button
        )
    }
}
