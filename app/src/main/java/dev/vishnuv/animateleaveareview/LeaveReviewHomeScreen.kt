package dev.vishnuv.animateleaveareview

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import dev.vishnuv.animateleaveareview.ui.theme.AnimateLeaveAReviewTheme
import dev.vishnuv.animateleaveareview.ui.theme.BgGreen
import dev.vishnuv.animateleaveareview.ui.theme.BgOrange
import dev.vishnuv.animateleaveareview.ui.theme.BgRed
import kotlin.math.roundToInt

@Composable
fun LeaveReviewHomeScreen(modifier: Modifier = Modifier) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    var activeIndex by remember { mutableIntStateOf(0) }
    var sliderValue by remember { mutableFloatStateOf(0f) }

    val bgColor = when {
        sliderValue <= 0.5 -> BgRed
        sliderValue in 0.5..1.2 -> BgOrange
        else -> BgGreen
    }

    val bgColorAnimation by animateColorAsState(
        targetValue = bgColor,
        label = "Background Color Animation",
        animationSpec = tween(durationMillis = 500)
    )

    val translateAnimation by animateFloatAsState(
        targetValue = 0f,
        label = "Translate Animation",
        animationSpec = tween(durationMillis = 1000, easing = EaseOutBack)
    )

    Scaffold { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .background(bgColorAnimation)
                .padding(innerPadding)
        ) {

            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f).offset {
                    IntOffset(0, (translateAnimation * screenHeight/2).roundToInt())
                }, horizontalAlignment = Alignment.CenterHorizontally) {
                    HeaderSection()
                    EyesSection(activeIndex = activeIndex, value = sliderValue)
                }

                TextAndSliderSection(
                    modifier = Modifier.weight(1f),
                    onPageChanged = {
                        activeIndex = it
                    },
                    onValueChange = {
                        sliderValue = it
                    }
                )

            }

        }
    }
}

@Preview
@Composable
private fun LeaveReviewHomeScreenPreview() {
    AnimateLeaveAReviewTheme {
        LeaveReviewHomeScreen()
    }
}