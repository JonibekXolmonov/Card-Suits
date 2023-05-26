package com.frt.cardsuits.screens.rule

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
class RuleViewModel @Inject constructor(private val sharedPref: SharedPref) : ViewModel() {

    private var _language = mutableStateOf(EN)
    val language get() = _language

    private fun getLanguage() {
        viewModelScope.launch {
            _language.value = sharedPref.getString() ?: EN
        }
    }

    init {
        viewModelScope.launch {
            getLanguage()
        }
    }
}