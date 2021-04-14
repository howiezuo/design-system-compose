package io.github.howiezuo.designsystem.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.howiezuo.designsystem.compose.ui.DlsTheme

@Composable
fun StyleScreen() {
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .padding(DlsTheme.sizes.medium)
    ) {
        Text(
            text = "Colors",
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.headline2
        )

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Row(
            horizontalArrangement = Arrangement.spacedBy(DlsTheme.sizes.medium)
        ) {
            ColorSquare(color = DlsTheme.colors.primary, "Primary")
            ColorSquare(color = DlsTheme.colors.background, "Background")
            ColorSquare(color = DlsTheme.colors.basic, "Basic")
            ColorSquare(color = DlsTheme.colors.disable, "Disable")
        }

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Row(
            horizontalArrangement = Arrangement.spacedBy(DlsTheme.sizes.medium)
        ) {
            ColorSquare(color = DlsTheme.colors.text, "Text")
            ColorSquare(color = DlsTheme.colors.textReverse, "TextReverse")
            ColorSquare(color = DlsTheme.colors.basic, "TextDisabled")
        }

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Row(
            horizontalArrangement = Arrangement.spacedBy(DlsTheme.sizes.medium)
        ) {
            ColorSquare(color = DlsTheme.colors.success, "Success")
            ColorSquare(color = DlsTheme.colors.link, "Link")
            ColorSquare(color = DlsTheme.colors.warning, "Warning")
            ColorSquare(color = DlsTheme.colors.error, "Error")
        }

        Spacer(modifier = Modifier.height(DlsTheme.sizes.large))

        Text(
            text = "Sizes",
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.headline2
        )

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Column(
            verticalArrangement = Arrangement.spacedBy(DlsTheme.sizes.smaller)
        ) {
            SizeLine(size = DlsTheme.sizes.smaller, "Smaller")
            SizeLine(size = DlsTheme.sizes.small, "Small")
            SizeLine(size = DlsTheme.sizes.medium, "Medium")
            SizeLine(size = DlsTheme.sizes.large, "Large")
            SizeLine(size = DlsTheme.sizes.larger, "Larger")
        }

        Spacer(modifier = Modifier.height(DlsTheme.sizes.large))

        Text(
            text = "Typography",
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.headline2
        )

        Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

        Column(
            verticalArrangement = Arrangement.spacedBy(DlsTheme.sizes.small)
        ) {
            TypographyText(DlsTheme.typography.headline1, "Headline1")
            TypographyText(DlsTheme.typography.headline2, "Headline2")
            TypographyText(DlsTheme.typography.headline3, "Headline3")
            TypographyText(DlsTheme.typography.headline4, "Headline4")
            TypographyText(DlsTheme.typography.headline5, "Headline5")
            TypographyText(DlsTheme.typography.headline6, "Headline6")
            TypographyText(DlsTheme.typography.subtitle, "Subtitle")
            TypographyText(DlsTheme.typography.paragraph, "Paragraph")
            TypographyText(DlsTheme.typography.caption, "Caption")
            TypographyText(DlsTheme.typography.label, "Label")
            TypographyText(DlsTheme.typography.button, "Button")
        }
    }
}

@Composable
private fun ColorSquare(
    color: Color,
    name: String
) {
    val borderColor = if (DlsTheme.colors.background == color) DlsTheme.colors.text else color
    Column {
        Box(
            modifier = Modifier
                .size(DlsTheme.sizes.larger)
                .clip(RoundedCornerShape(DlsTheme.sizes.smaller))
                .border(1.dp, borderColor, shape = RoundedCornerShape(DlsTheme.sizes.smaller))
                .background(color)
        )
        Text(
            text = name,
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.label
        )
    }
}

@Composable
private fun SizeLine(
    size: Dp,
    name: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            modifier = Modifier.widthIn(min = 80.dp),
            color = DlsTheme.colors.text,
            style = DlsTheme.typography.subtitle
        )

        Box(
            modifier = Modifier
                .width(size)
                .height(DlsTheme.sizes.smaller)
                .background(DlsTheme.colors.primary)
        )
    }
}

@Composable
private fun TypographyText(
    typography: TextStyle,
    name: String
) {
    Text(
        text = name,
        color = DlsTheme.colors.primary,
        style = typography
    )
}
