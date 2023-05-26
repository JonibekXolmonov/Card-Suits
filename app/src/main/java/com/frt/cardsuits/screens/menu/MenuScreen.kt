package com.frt.cardsuits.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.frt.cardsuits.R
import com.frt.cardsuits.ui.theme.MenuButtonGradient
import com.frt.cardsuits.ui.theme.fonts
import com.frt.cardsuits.utils.Contants.EN
import com.frt.cardsuits.utils.Contants.RU
import com.frt.cardsuits.utils.noRippleClickable

@Composable
fun MenuScreen(
    modifier: Modifier = Modifier,
    viewModel: MenuViewModel = hiltViewModel(),
    onRulesClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onGameStartClick: () -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getLanguage()
    }

    val language by remember {
        viewModel.language
    }

    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.menu_back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        ConstraintLayout(modifier = modifier.fillMaxSize()) {
            val (card, man, box) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.ic_top_card),
                contentDescription = null,
                modifier = modifier
                    .constrainAs(card) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .size(92.dp, 108.dp)
                    .noRippleClickable {
                        onSettingsClick()
                    }
            )

            Box(modifier = modifier.constrainAs(box) {
                top.linkTo(card.bottom)
                bottom.linkTo(man.top)
            }) {
                ConstraintLayout(modifier = modifier.fillMaxWidth()) {
                    val (rule, game) = createRefs()
                    Button(
                        onClick = onRulesClick,
                        modifier = modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(MenuButtonGradient)
                            .constrainAs(rule) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start, margin = 13.dp)
                            },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            backgroundColor = Color.Transparent
                        ),
                        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        Text(
                            text = stringResource(id = if (language == EN) R.string.str_rules else R.string.str_rules_ru),
                            fontFamily = fonts,
                            fontWeight = if (language == RU) FontWeight.Bold else FontWeight(400),
                            color = Color.Black,
                            fontSize = 40.sp,
                            modifier = modifier.padding(horizontal = 40.dp, vertical = 11.dp)
                        )
                    }

                    Button(
                        onClick = onGameStartClick,
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(MenuButtonGradient)
                            .constrainAs(game) {
                                end.linkTo(parent.end, margin = 10.dp)
                                top.linkTo(rule.bottom, margin = 15.dp)
                                bottom.linkTo(parent.bottom)
                            },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            backgroundColor = Color.Transparent
                        ),
                        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
                    ) {
                        Text(
                            text = stringResource(id = if (language == EN) R.string.str_game else R.string.str_game_ru),
                            fontFamily = fonts,
                            color = Color.Black,
                            fontSize = 40.sp,
                            fontWeight = if (language == RU) FontWeight.Bold else FontWeight(400),
                            modifier = modifier.padding(horizontal = 40.dp, vertical = 11.dp)
                        )
                    }
                }
            }

            Image(
                painter = painterResource(id = R.drawable.card_man),
                contentDescription = null,
                modifier = modifier.constrainAs(man) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                })
        }
    }
}