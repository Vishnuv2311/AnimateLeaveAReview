package dev.vishnuv.animateleaveareview

import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vishnuv.animateleaveareview.ui.theme.AnimateLeaveAReviewTheme
import dev.vishnuv.animateleaveareview.ui.theme.BgBlack
import dev.vishnuv.animateleaveareview.ui.theme.BgWhite
import dev.vishnuv.animateleaveareview.ui.theme.TextWhite
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextAndSliderSection(
    modifier: Modifier = Modifier,
    onPageChanged: (Int) -> Unit,
    onValueChange: (Float) -> Unit
) {

    val items = listOf("BAD", "NOT BAD", "GOOD")
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp

    val pagerState = rememberPagerState(pageCount = { items.size })

    var sliderPosition by remember { mutableFloatStateOf(0f) }

    val coroutineScope = rememberCoroutineScope()

    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
        Box(
            Modifier
                .fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            HorizontalPager(state = pagerState, userScrollEnabled = false) {
                LaunchedEffect(pagerState.currentPage) {
                    onPageChanged(pagerState.currentPage)
                }
                Text(
                    items[pagerState.currentPage],
                    style = MaterialTheme.typography.displayLarge.copy(
                        color = BgBlack.copy(alpha = 0.3f),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Slider(
            value = sliderPosition,
            valueRange = 0f..2f,
            steps = 3,
            onValueChange = { newValue ->
                onValueChange(newValue)
                coroutineScope.launch {
                    pagerState.animateScrollToPage(
                        newValue.toInt(),
                        animationSpec = tween(durationMillis = 1800, easing = EaseOutElastic)
                    )
                }
                println("Pager Scroll: ${(newValue * width) / 3}")
                sliderPosition = newValue
            },
            colors = SliderDefaults.colors(
                thumbColor = BgBlack,
                activeTrackColor = BgBlack,
                inactiveTrackColor = BgBlack.copy(alpha = 0.3f)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )


        Box(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        color = BgBlack.copy(alpha = 0.2f), shape = CircleShape.copy(
                            CornerSize(30.dp)
                        )
                    )
                    .padding(horizontal = 40.dp)
            ) {
                Text(
                    "Add Note",
                    style = MaterialTheme.typography.titleSmall.copy(color = TextWhite),
                    modifier = Modifier.align(Alignment.CenterStart)
                )
            }

            ElevatedButton(
                onClick = {},
                Modifier
                    .align(Alignment.CenterEnd)
                    .height(60.dp),
                colors = ButtonDefaults.elevatedButtonColors(containerColor = BgBlack)
            ) {
                Text("Submit", style = MaterialTheme.typography.titleSmall.copy(color = BgWhite))
                Spacer(Modifier.width(10.dp))
                Icon(
                    Icons.Default.ArrowForward,
                    contentDescription = "Submit Button",
                    tint = BgWhite
                )
            }
        }


    }

}

@Preview(showBackground = true)
@Composable
private fun TextAndSliderSectionPreview() {
    AnimateLeaveAReviewTheme {
        TextAndSliderSection(onPageChanged = {}) {}
    }
}