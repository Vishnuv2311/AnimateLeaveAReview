package dev.vishnuv.animateleaveareview

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import dev.vishnuv.animateleaveareview.ui.theme.AnimateLeaveAReviewTheme
import dev.vishnuv.animateleaveareview.ui.theme.BgBlack

@Composable
fun ArcPainter(modifier: Modifier = Modifier) {
    val path = Path()
    Canvas(modifier = modifier.fillMaxSize())
    {
        path.moveTo(0f, size.height / 2)
        path.quadraticBezierTo(size.width / 2, size.height, size.width, size.height / 2)
        drawPath(path, color = BgBlack, style = Stroke(width = 12f, cap = Round))

    }
}

@Preview
@Composable
private fun ArcPainterPreview() {
    AnimateLeaveAReviewTheme {
        ArcPainter()
    }

}