package io.github.howiezuo.designsystem.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.howiezuo.designsystem.compose.component.Avatar
import io.github.howiezuo.designsystem.compose.component.ListItem
import io.github.howiezuo.designsystem.compose.component.PrimaryButton
import io.github.howiezuo.designsystem.compose.component.SecondaryButton
import io.github.howiezuo.designsystem.compose.ui.DlsTheme

@Composable
fun ComponentScreen() {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .padding(DlsTheme.sizes.medium)
    ) {
        Text(
            text = "Button",
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.headline2
        )

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Row(
            horizontalArrangement = Arrangement.spacedBy(DlsTheme.sizes.medium)
        ) {
            PrimaryButton("PrimaryButton") { }
            SecondaryButton("SecondaryButton") { }
        }

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Text(
            text = "Avatar",
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.headline2
        )

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Row(
            horizontalArrangement = Arrangement.spacedBy(DlsTheme.sizes.medium),
            verticalAlignment = Alignment.Bottom
        ) {
            Avatar(
                painter = painterResource(id = R.drawable.cat),
                sizeVariant = Avatar.SizeVariant.Large
            )
            Avatar(
                painter = painterResource(id = R.drawable.cat),
                sizeVariant = Avatar.SizeVariant.Medium
            )
            Avatar(
                painter = painterResource(id = R.drawable.cat),
                sizeVariant = Avatar.SizeVariant.Small
            )
        }

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Text(
            text = "List Item",
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.headline2
        )

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Surface(
            elevation = DlsTheme.sizes.smaller
        ) {
            ListItem(title = "Title") {
                Text(
                    text = "Body",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .border(1.dp, color = DlsTheme.colors.success),
                    color = DlsTheme.colors.success,
                    textAlign = TextAlign.Center,
                    style = DlsTheme.typography.headline3
                )
            }
        }
    }
}
