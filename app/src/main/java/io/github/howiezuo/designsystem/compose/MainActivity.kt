package io.github.howiezuo.designsystem.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.mutableStateOf
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.layout.RowScope.gravity
import androidx.ui.material.Button
import androidx.ui.material.Surface
import androidx.ui.text.style.TextAlign
import io.github.howiezuo.designsystem.compose.ui.DlsTheme
import io.github.howiezuo.designsystem.compose.ui.DlsToken
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DlsToken.colors.background
                ) {

                    Column(
                        modifier = Modifier.gravity(Alignment.CenterVertically)
                            .wrapContentSize()
                    ) {

                        Text(
                            text = if (isDarkState.value) "Is Dark" else "Is Light",
                            color = DlsToken.colors.text,
                            textAlign = TextAlign.Center,
                            style = DlsToken.typography.paragraph1
                        )

                        Spacer(modifier = Modifier.preferredHeight(DlsToken.sizes.medium))

                        CustomButton(
                            text = "Button",
                            onClick = {
                                isDarkState.value = !isDarkState.value
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        backgroundColor = DlsToken.colors.primary,
        padding = InnerPadding(
            start = DlsToken.sizes.small,
            top = DlsToken.sizes.smaller,
            end = DlsToken.sizes.small,
            bottom = DlsToken.sizes.smaller
        )
    ) {
        Text(
            text = text,
            color = DlsToken.colors.textReverse,
            style = DlsToken.typography.button
        )
    }
}
