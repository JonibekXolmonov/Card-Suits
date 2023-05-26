package com.frt.cardsuits.screens.game

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.frt.cardsuits.R
import com.frt.cardsuits.ui.theme.Background
import com.frt.cardsuits.ui.theme.GameGradient
import com.frt.cardsuits.ui.theme.fonts
import com.frt.cardsuits.utils.noRippleClickable
import kotlinx.coroutines.delay

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = hiltViewModel(),
    onVibrate: () -> Unit,
    onScoreScreen: (score: Int) -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    LaunchedEffect(Unit) {
        viewModel.accelerate()
    }

    val score by remember { viewModel.score }
    val time by remember { viewModel.time }

    val lives by remember { viewModel.lives }

    val image1 by remember { viewModel.image1 }
    val image2 by remember { viewModel.image2 }
    val image3 by remember { viewModel.image3 }
    val image4 by remember { viewModel.image4 }
    val image5 by remember { viewModel.image5 }
    val image6 by remember { viewModel.image6 }
    val image7 by remember { viewModel.image7 }
    val image8 by remember { viewModel.image8 }
    val image9 by remember { viewModel.image9 }
    val image10 by remember { viewModel.image10 }
    val image11 by remember { viewModel.image11 }
    val image12 by remember { viewModel.image12 }

    val xOffset1 by remember { viewModel.xOffset1 }
    val xOffset2 by remember { viewModel.xOffset2 }
    val xOffset3 by remember { viewModel.xOffset3 }
    val xOffset4 by remember { viewModel.xOffset4 }
    val xOffset5 by remember { viewModel.xOffset5 }
    val xOffset6 by remember { viewModel.xOffset6 }
    val xOffset7 by remember { viewModel.xOffset7 }
    val xOffset8 by remember { viewModel.xOffset8 }
    val xOffset9 by remember { viewModel.xOffset9 }
    val xOffset10 by remember { viewModel.xOffset10 }
    val xOffset11 by remember { viewModel.xOffset11 }
    val xOffset12 by remember { viewModel.xOffset12 }

    var showDialog by remember { mutableStateOf(false) }
    var scoreOnScreen = 0

    if (score != 0) {
        scoreOnScreen = score
    }

    if (lives == 0) showDialog = true

    if (showDialog) {
        onScoreScreen(scoreOnScreen)
        showDialog = false
        viewModel.reset()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ScoreAndLiveRow(score = score, lives = lives)

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .weight(1f)
                .offset(y = 100.dp)
        ) {
            FirstLine(
                modifier.offset(y = 100.dp),
                timeChange = time,
                screenHeight = screenHeight + 100,
                image1 = image1,
                image2 = image2,
                image3 = image3,
                image4 = image4,
                xOffset1 = xOffset1,
                xOffset2 = xOffset2,
                xOffset3 = xOffset3,
                xOffset4 = xOffset4,
                generate = { num ->
                    when (num) {
                        1 -> {
                            viewModel.generate1()
                            viewModel.generateOffset1()
                        }
                        2 -> {
                            viewModel.generate2()
                            viewModel.generateOffset2()
                        }
                        3 -> {
                            viewModel.generate3()
                            viewModel.generateOffset3()
                        }
                        4 -> {
                            viewModel.generate4()
                            viewModel.generateOffset4()
                        }
                    }
                },
                onClick = {
                    val wrongClick = it == R.drawable.club || it == R.drawable.heart
                    if (wrongClick)
                        viewModel.decreaseLive()
                    else viewModel.increaseScore()
                    onVibrate()
                }
            )

            FirstLine(
                timeChange = time,
                screenHeight = screenHeight,
                image1 = image5,
                image2 = image6,
                image3 = image7,
                image4 = image8,
                xOffset1 = xOffset5,
                xOffset2 = xOffset6,
                xOffset3 = xOffset7,
                xOffset4 = xOffset8,
                generate = { num ->
                    when (num) {
                        1 -> {
                            viewModel.generate5()
                            viewModel.generateOffset5()
                        }
                        2 -> {
                            viewModel.generate6()
                            viewModel.generateOffset6()
                        }
                        3 -> {
                            viewModel.generate7()
                            viewModel.generateOffset7()
                        }
                        4 -> {
                            viewModel.generate8()
                            viewModel.generateOffset8()
                        }
                    }
                },
                onClick = {
                    val wrongClick = it == R.drawable.club || it == R.drawable.heart
                    if (wrongClick)
                        viewModel.decreaseLive()
                    else viewModel.increaseScore()
                    onVibrate()
                }
            )

            FirstLine(
                modifier.offset(y = 48.dp),
                timeChange = time,
                screenHeight = screenHeight + 48,
                image1 = image9,
                image2 = image10,
                image3 = image11,
                image4 = image12,
                xOffset1 = xOffset9,
                xOffset2 = xOffset10,
                xOffset3 = xOffset11,
                xOffset4 = xOffset12,
                generate = { num ->
                    when (num) {
                        1 -> {
                            viewModel.generate9()
                            viewModel.generateOffset9()
                        }
                        2 -> {
                            viewModel.generate10()
                            viewModel.generateOffset10()
                        }
                        3 -> {
                            viewModel.generate11()
                            viewModel.generateOffset11()
                        }
                        4 -> {
                            viewModel.generate12()
                            viewModel.generateOffset12()
                        }
                    }
                },
                onClick = {
                    val wrongClick = it == R.drawable.club || it == R.drawable.heart
                    if (wrongClick)
                        viewModel.decreaseLive()
                    else viewModel.increaseScore()
                    onVibrate()
                }
            )
        }

        BottomCardImage()
    }
}

@Composable
fun MovingImage(
    modifier: Modifier = Modifier,
    screenHeight: Int,
    image: Int,
    timeChange: Int,
    delayMillis: Long,
    randomXOffset: Dp,
    onChange: () -> Unit,
    onClick: (Int) -> Unit
) {

    var animationPlayed by remember {
        mutableStateOf(false)
    }

    var isClicked by remember {
        mutableStateOf(false)
    }

    var showImage by remember {
        mutableStateOf(false)
    }

    var time by remember {
        mutableStateOf(timeChange)
    }

    val yOffset =
        animateFloatAsState(targetValue = if (animationPlayed) -screenHeight.toFloat() else 0f,
            animationSpec = tween(
                time, easing = LinearEasing
            ),
            finishedListener = {
                animationPlayed = !animationPlayed
                time = if (!animationPlayed) 0 else timeChange
                showImage = animationPlayed
                onChange()
                isClicked = false
                showImage = true
            })

    LaunchedEffect(true) {
        delay(delayMillis)
        animationPlayed = true
        showImage = true
    }

    if (showImage) AsyncImage(
        model = image,
        contentDescription = null,
        modifier = modifier
            .offset(y = yOffset.value.dp, x = randomXOffset)
            .size(65.dp)
            .noRippleClickable {
                if (!isClicked)
                    onClick(image)
                isClicked = true
                showImage = image == R.drawable.club || image == R.drawable.heart
            }
    )
}

@Composable
fun FirstLine(
    modifier: Modifier = Modifier,
    screenHeight: Int,
    image1: Int,
    image2: Int,
    image3: Int,
    image4: Int,
    xOffset1: Dp,
    xOffset2: Dp,
    xOffset3: Dp,
    xOffset4: Dp,
    timeChange: Int,
    generate: (Int) -> Unit,
    onClick: (Int) -> Unit
) {
    Box(modifier) {

        MovingImage(
            timeChange = timeChange,
            screenHeight = screenHeight,
            image = image1,
            delayMillis = 0,
            randomXOffset = xOffset1,
            onChange = {
                generate(1)
            },
            onClick = onClick
        )

        MovingImage(
            timeChange = timeChange,
            screenHeight = screenHeight,
            image = image2,
            delayMillis = timeChange / 4L,
            randomXOffset = xOffset2, onChange = {
                generate(2)
            },
            onClick = onClick
        )

        MovingImage(
            timeChange = timeChange,
            screenHeight = screenHeight,
            image = image3,
            delayMillis = timeChange / 2L,
            randomXOffset = xOffset3,
            onChange = {
                generate(3)
            },
            onClick = onClick
        )

        MovingImage(
            timeChange = timeChange,
            screenHeight = screenHeight,
            image = image4,
            delayMillis = timeChange * 3 / 4L,
            randomXOffset = xOffset4,
            onChange = {
                generate(4)
            },
            onClick = onClick
        )
    }
}

@Composable
fun ScoreAndLiveRow(modifier: Modifier = Modifier, score: Int, lives: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(top = 32.dp)
            .fillMaxWidth()
            .padding(start = 11.dp, end = 10.dp)
    ) {
        Text(
            text = "x$lives",
            fontSize = 32.sp,
            fontFamily = fonts,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(GameGradient)
                .padding(horizontal = 21.dp, vertical = 20.dp)
        )
        Text(
            text = score.toString(),
            fontSize = 32.sp,
            fontFamily = fonts,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(GameGradient)
                .padding(horizontal = 13.dp, vertical = 20.dp)
        )
    }
}

@Composable
fun BottomCardImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_game_cards),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .background(
                Background,
                shape = RoundedCornerShape(topStartPercent = 50, topEndPercent = 50)
            )
            .height(182.dp)
            .padding(horizontal = 18.dp),
        contentScale = ContentScale.Crop
    )
}
