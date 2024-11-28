package dev.vishnuv.animateleaveareview

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vishnuv.animateleaveareview.ui.theme.AnimateLeaveAReviewTheme
import dev.vishnuv.animateleaveareview.ui.theme.BgBlack

@Composable
fun Eye(modifier: Modifier = Modifier, value: Float) {
    var width = 70
    var height = 35

    when {
        value <= 0.5f -> {
            width = 70
            height = 70
        }

        value > 0.5 && value < 1.2 -> {
            width = 70
            height = 30
        }

        value >= 1.2 -> {
            height = 120
            width = 120
        }
    }

    Box(
        modifier = modifier
            .background(color = BgBlack, shape = CircleShape)
            .animateContentSize(animationSpec = tween(durationMillis = 500))
            .size(width = width.dp, height = height.dp)
    )

}

@Preview
@Composable
private fun EyePreview() {
    AnimateLeaveAReviewTheme {
        Eye(value = 0.5f)
    }
}