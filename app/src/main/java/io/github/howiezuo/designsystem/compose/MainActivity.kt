package io.github.howiezuo.designsystem.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DlsTheme.colors.background),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = if (isDarkState.value) "Is Dark" else "Is Light",
                        color = DlsTheme.colors.text,
                        style = DlsTheme.typography.paragraph1
                    )

                    Spacer(modifier = Modifier.height(DlsTheme.sizes.medium))

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

@Composable
fun CustomButton(
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
