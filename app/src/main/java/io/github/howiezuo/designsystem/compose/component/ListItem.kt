package io.github.howiezuo.designsystem.compose.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.howiezuo.designsystem.compose.ui.DlsTheme

@Composable
fun ListItem(
    title: String,
    body: @Composable () -> Unit
) {
    Row(
        Modifier.padding(DlsTheme.sizes.medium)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(end = DlsTheme.sizes.small),
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.headline3
        )

        body()
    }
}
