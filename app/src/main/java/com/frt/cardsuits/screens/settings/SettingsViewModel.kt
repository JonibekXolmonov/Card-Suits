package com.frt.cardsuits.screens.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frt.cardsuits.utils.Contants.EN
import com.frt.cardsuits.utils.Contants.SOUND
import com.frt.cardsuits.utils.Contants.VIBRATION
import com.frt.cardsuits.utils.SharedPref
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val sharedPref: SharedPref) : ViewModel() {

    private var _vibrationEnabled = mutableStateOf(false)
    val vibrationEnabled get() = _vibrationEnabled


    private var _language = mutableStateOf(EN)
    val language get() = _language

    private var _soundEnabled = mutableStateOf(false)
    val soundEnabled get() = _soundEnabled

    fun controlVibration(isEnabled: Boolean) {
        viewModelScope.launch {
            try {
                sharedPref.saveBoolean(VIBRATION, isEnabled)
                _vibrationEnabled.value = isEnabled
            } catch (e: Exception) {
                //not saved
            }
        }
    }

    private fun getVibration() {
        viewModelScope.launch {
            _vibrationEnabled.value = sharedPref.getBoolean(VIBRATION)
        }
    }

    fun controlSound(isEnabled: Boolean) {
        viewModelScope.launch {
            try {
                sharedPref.saveBoolean(SOUND, isEnabled)
                _soundEnabled.value = isEnabled
            } catch (e: Exception) {
                //not saved
            }
        }
    }

    private fun getSound() {
        viewModelScope.launch {
            _soundEnabled.value = sharedPref.getBoolean(SOUND)
        }
    }

    private fun getLanguage() {
        viewModelScope.launch {
            _language.value = sharedPref.getString() ?: EN
        }
    }

    fun saveLanguage(language: String) {
        viewModelScope.launch {
            sharedPref.saveString(data = language)
            _language.value = language
        }
    }

    init {
        viewModelScope.launch {
            getSound()
            getVibration()
            getLanguage()
        }
    }
}