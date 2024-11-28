package dev.vishnuv.animateleaveareview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.vishnuv.animateleaveareview.ui.theme.AnimateLeaveAReviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimateLeaveAReviewTheme {
                LeaveReviewHomeScreen()
            }
        }
    }
}
