package dev.vishnuv.animateleaveareview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.vishnuv.animateleaveareview.ui.theme.AnimateLeaveAReviewTheme
import dev.vishnuv.animateleaveareview.ui.theme.BgBlack

@Composable
fun HeaderSection(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val height = configuration.screenHeightDp

    Column(Modifier.padding(20.dp)) {
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Box(
                Modifier
                    .size(50.dp)
                    .background(BgBlack.copy(0.1f), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }

            Box(
                Modifier
                    .size(50.dp)
                    .background(BgBlack.copy(0.1f), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.MailOutline, contentDescription = "OutLine")
            }
        }

        Spacer(Modifier.height(20.dp))

        Text(
            "How was your shopping experience",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(Modifier.height((height * 0.05).dp))
    }
}

@Preview
@Composable
private fun HeaderSectionPreview() {
    AnimateLeaveAReviewTheme {
        HeaderSection()
    }
}