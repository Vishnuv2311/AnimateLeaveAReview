package dev.vishnuv.animateleaveareview

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vishnuv.animateleaveareview.ui.theme.AnimateLeaveAReviewTheme

@Composable
fun EyesSection(modifier: Modifier = Modifier, activeIndex: Int, value: Float = 0.0f) {

    val tween = tween<Float>(durationMillis = 500)

    val rotationAngle = when (value) {
        in 0f..0.3f -> 180f
        in 0.4f..0.5f -> 0f
        in 0.5f..1.6f -> 180f
        in 1.6f..2f -> 0f
        else -> 180f
    }

    val rotationAnimation by animateFloatAsState(
        label = "Smile Rotation",
        targetValue = if (activeIndex==1) -10f else if (activeIndex==2) 0f else 180f, //0 Happy, 180 Dull
        animationSpec = tween
    )

    Column(horizontalAlignment = CenterHorizontally) {
        Row(verticalAlignment = CenterVertically) {
            Eye(value = value)
            Spacer(Modifier.width(20.dp))
            Eye(value = value)
        }
        Spacer(Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .size(50.dp)
                .rotate(rotationAnimation)
        ) {
            ArcPainter()
        }

    }

}


@Preview
@Composable
private fun EyesSectionPreview() {
    AnimateLeaveAReviewTheme {
        EyesSection(activeIndex = 2)
    }
}