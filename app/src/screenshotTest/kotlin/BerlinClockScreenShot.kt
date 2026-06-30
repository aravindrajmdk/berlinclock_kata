import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import com.example.berlinclock_kata.ui.BerlinClockContent
import com.example.berlinclock_kata.ui.models.BerlinClockUiModel

@Preview(showBackground = true)
@PreviewTest
@Composable
fun BerlinClockScreenPreview() {
    val previewState = BerlinClockUiModel(
        second = Color.Yellow,
        fiveHourRow = listOf(
            Color.Red,
            Color.Red,
            Color.DarkGray,
            Color.DarkGray
        ),
        oneHourRow = listOf(
            Color.Red,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray
        ),
        fiveMinRow = listOf(
            Color.Yellow,
            Color.Yellow,
            Color.Red,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray
        ),
        oneMinRow = listOf(
            Color.Yellow,
            Color.DarkGray,
            Color.DarkGray,
            Color.DarkGray
        )
    )
    BerlinClockContent(previewState)
}