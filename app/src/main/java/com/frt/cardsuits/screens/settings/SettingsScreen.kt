package com.frt.cardsuits.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.frt.cardsuits.R
import com.frt.cardsuits.ui.theme.*
import com.frt.cardsuits.utils.Contants.EN
import com.frt.cardsuits.utils.Contants.RU
import com.frt.cardsuits.utils.noRippleClickable

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
    onVibrate: () -> Unit,
    onSound: (Boolean) -> Unit
) {

    val vibrationEnabled by remember {
        viewModel.vibrationEnabled
    }

    val soundEnabled by remember {
        viewModel.soundEnabled
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

        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(80.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = modifier
                        .padding(start = 8.dp, top = 6.dp)
                        .noRippleClickable { onBackPressed() }
                )

                Image(
                    painter = painterResource(id = R.drawable.settings_top),
                    contentDescription = null,
                    modifier = modifier
                        .size(230.dp, 250.dp)
                )
            }

            Sound(sound = soundEnabled, language = language) {
                viewModel.controlSound(it)
                onVibrate()
                onSound(it)
            }

            Vibration(vibration = vibrationEnabled, language = language) {
                viewModel.controlVibration(it)
                onVibrate()
            }

            Language(language = language) {
                viewModel.saveLanguage(language = it)
            }
        }
    }
}

@Composable
fun Language(modifier: Modifier = Modifier, language: String, onLanguageChange: (String) -> Unit) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = RU,
            modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (language == RU) EnableLanguageBack else DisableLanguageBack)
                .clickable { onLanguageChange(RU) }
                .padding(horizontal = 18.dp, vertical = 12.dp),
            fontFamily = fonts,
            fontSize = 24.sp,
            color = if (language == RU) Color.Black else Color.Black.copy(alpha = 0.5f)
        )
        Text(
            text = EN,
            modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (language == EN) EnableLanguageBack else DisableLanguageBack)
                .clickable { onLanguageChange(EN) }
                .padding(horizontal = 18.dp, vertical = 12.dp),
            fontFamily = fonts,
            fontSize = 24.sp,
            color = if (language == EN) Color.Black else Color.Black.copy(alpha = 0.5f)
        )
    }
}

@Composable
fun Sound(
    modifier: Modifier = Modifier,
    sound: Boolean,
    language: String,
    onSoundChanged: (Boolean) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 34.dp)
    ) {
        Text(
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontFamily = fonts,
            color = Color.Black,
            text = stringResource(id = if (language == EN) R.string.str_sound else R.string.str_sound_ru),
            fontWeight = if (language == RU) FontWeight.Bold else FontWeight(400),
            modifier = modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = if (sound) R.drawable.ic_on else R.drawable.ic_off),
            contentDescription = null,
            modifier = modifier
                .size(84.dp)
                .noRippleClickable {
                    onSoundChanged(!sound)
                }
        )
    }
}

@Composable
fun Vibration(
    modifier: Modifier = Modifier,
    vibration: Boolean,
    language: String,
    onVibrationChange: (Boolean) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(end = 34.dp)
    ) {
        Text(
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontFamily = fonts,
            color = Color.Black,
            text = stringResource(id = if (language == EN) R.string.str_vibration else R.string.str_vibration_ru),
            fontWeight = if (language == RU) FontWeight.Bold else FontWeight(400),
            modifier = modifier.weight(1f)
        )
        Image(
            painter = painterResource(id = if (vibration) R.drawable.ic_on else R.drawable.ic_off),
            contentDescription = null,
            modifier = modifier
                .size(84.dp)
                .noRippleClickable {
                    onVibrationChange(!vibration)
                }
        )
    }
}