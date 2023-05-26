package com.frt.cardsuits.screens.score

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frt.cardsuits.R
import com.frt.cardsuits.ui.theme.Background
import com.frt.cardsuits.ui.theme.ScoreGradient
import com.frt.cardsuits.ui.theme.ScoreTextColor
import com.frt.cardsuits.ui.theme.fonts


@Composable
fun ScoreScreen(
    score: Int?,
) {
    DialogUI(
        score = score
    )
}

@Composable
fun DialogUI(
    modifier: Modifier = Modifier,
    score: Int?
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(52.dp),
            modifier = modifier
                .padding(top = 32.dp)
                .fillMaxWidth()
                .padding(top = 13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_score),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(250.dp)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .clip(RoundedCornerShape(30.dp))
                    .background(ScoreGradient)
                    .padding(horizontal = 60.dp, vertical = 97.dp)
            ) {
                Text(
                    text = (score ?: 0).toString(),
                    fontSize = 96.sp,
                    fontFamily = fonts,
                    color = ScoreTextColor
                )
            }
        }
    }
}
