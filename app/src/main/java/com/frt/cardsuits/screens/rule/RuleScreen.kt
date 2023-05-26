package com.frt.cardsuits.screens.rule

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.frt.cardsuits.R
import com.frt.cardsuits.utils.Contants
import com.frt.cardsuits.utils.noRippleClickable

@Composable
fun RuleScreen(
    modifier: Modifier = Modifier,
    viewModel: RuleViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {

    val language by remember {
        viewModel.language
    }

    Box(modifier = modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.rule_back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(id = if (language == Contants.EN) R.drawable.rules else R.drawable.rules_ru_back),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()
                .background(Color.Transparent)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val back = createRef()
            Image(
                painter = painterResource(id = R.drawable.ic_back_big),
                contentDescription = null,
                modifier = modifier
                    .constrainAs(back) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom, margin = 70.dp)
                    }
                    .noRippleClickable {
                        onBackPressed()
                    }
            )
        }
    }
}