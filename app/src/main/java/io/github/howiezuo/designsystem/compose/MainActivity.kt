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
import io.github.howiezuo.designsystem.compose.ui.DlsTheme
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
                    color = DlsTheme.colors.background
                ) {

                    Column(
                        modifier = Modifier.gravity(Alignment.CenterVertically)
                            .wrapContentSize(),
                        horizontalGravity = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = if (isDarkState.value) "Is Dark" else "Is Light",
                            color = DlsTheme.colors.text,
                            style = DlsTheme.typography.paragraph1
                        )

                        Spacer(modifier = Modifier.preferredHeight(DlsTheme.sizes.medium))

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
        backgroundColor = DlsTheme.colors.primary,
        padding = InnerPadding(
            start = DlsTheme.sizes.large,
            top = DlsTheme.sizes.medium,
            end = DlsTheme.sizes.large,
            bottom = DlsTheme.sizes.medium
        )
    ) {
        Text(
            text = text,
            color = DlsTheme.colors.textReverse,
            style = DlsTheme.typography.button
        )
    }
}
